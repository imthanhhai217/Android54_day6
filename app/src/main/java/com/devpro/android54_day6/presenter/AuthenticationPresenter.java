package com.devpro.android54_day6.presenter;

import com.devpro.android54_day6.intefaces.IAuthenticationPresenter;
import com.devpro.android54_day6.intefaces.IAuthenticationView;
import com.devpro.android54_day6.models.UserDatabase;
import com.devpro.android54_day6.models.UserModel;

public class AuthenticationPresenter implements IAuthenticationPresenter {
    private IAuthenticationView iAuthenticationView;
    private UserDatabase userDatabase;

    public AuthenticationPresenter(IAuthenticationView iAuthenticationView) {
        this.iAuthenticationView = iAuthenticationView;
        userDatabase = UserDatabase.getInstances();
        userDatabase.setIAuthenticationPresenter(this);
    }

    public void login(String userName, String password) {
        userDatabase.checkAuthentication(userName, password);
    }

    @Override
    public void addUser(UserModel model) {
        userDatabase.register(model);
    }

    @Override
    public boolean checkAuthentication(String userName, String password) {
        return false;
    }

    @Override
    public void onLoginSuccess(UserModel model) {
        iAuthenticationView.onLoginSuccess(model);
    }

    @Override
    public void onLoginError(String error) {
        iAuthenticationView.onLoginError(error);
    }

    @Override
    public void onRegisterSuccess(UserModel model) {
        iAuthenticationView.onRegisterSuccess(model);
    }

    @Override
    public void onRegisterError(String error) {
        iAuthenticationView.onRegisterError(error);
    }
}
