package com.devpro.android54_day6.models;

import com.devpro.android54_day6.intefaces.IAuthenticationPresenter;

import java.util.ArrayList;

public class UserDatabase {
    private ArrayList<UserModel> mListUser = new ArrayList<>();
    private static UserDatabase instances;

    public void setIAuthenticationPresenter(IAuthenticationPresenter iAuthenticationPresenter) {
        this.iAuthenticationPresenter = iAuthenticationPresenter;
    }

    private IAuthenticationPresenter iAuthenticationPresenter;

    public static UserDatabase getInstances() {
        if (instances == null) {
            instances = new UserDatabase();
        }

        return instances;
    }

    public boolean isUserExisted(String userName) {
        for (UserModel model : mListUser) {
            if (model.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }

    public void checkAuthentication(String userName, String password) {
        if (isUserExisted(userName)) {
            for (UserModel model : mListUser) {
                if (model.getUserName().equals(userName) && model.getPassword().equals(password)) {
                    iAuthenticationPresenter.onLoginSuccess(model);
                    return;
                }
            }
            iAuthenticationPresenter.onLoginError("Sai ten dang nhap hoac mat khau");
        } else {
            iAuthenticationPresenter.onLoginError("Khong tim thay nguoi dung nay");
        }
    }

    public void register(UserModel model) {
        if (isUserExisted(model.getUserName())) {
            iAuthenticationPresenter.onRegisterError("Nguoi dung nay da dang ki, vui long dang nhap");
        } else {
            mListUser.add(model);
            iAuthenticationPresenter.onRegisterSuccess(model);
        }
    }
}
