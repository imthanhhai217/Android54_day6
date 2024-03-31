package com.devpro.android54_day6.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.devpro.android54_day6.R;
import com.devpro.android54_day6.constant.Constant;
import com.devpro.android54_day6.intefaces.IAuthenticationView;
import com.devpro.android54_day6.models.UserModel;
import com.devpro.android54_day6.presenter.AuthenticationPresenter;
import com.devpro.android54_day6.utils.PrefManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, IAuthenticationView {

    EditText edtUserName;
    EditText edtPassword;
    Button btnLogin;
    Button btnRegister;

    private AuthenticationPresenter authenticationPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();
        authenticationPresenter = new AuthenticationPresenter(this);


    }

    private void initView() {
        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        edtUserName.setText(getSavedUserName());

        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                String userName = edtUserName.getText().toString();
                String passwords = edtPassword.getText().toString();

                saveUserName(userName);

                login(userName, passwords);
                break;
            case R.id.btnRegister:
                String userName2 = edtUserName.getText().toString();
                String passwords2 = edtPassword.getText().toString();
                UserModel userModel = new UserModel();
                userModel.setUserName(userName2);
                userModel.setPassword(passwords2);
                userModel.setAddress("HN");
                userModel.setAge(27);
                register(userModel);
                break;

        }
    }

    private void saveUserName(String userName) {
        PrefManager.saveString(Constant.USER_NAME_KEY,userName);
    }

    private String getSavedUserName(){
        return PrefManager.getString(Constant.USER_NAME_KEY);
    }


    @Override
    public void register(UserModel model) {
        authenticationPresenter.addUser(model);
    }

    @Override
    public void login(String userName, String password) {
        authenticationPresenter.login(userName, password);
    }

    @Override
    public void onLoginSuccess(UserModel model) {
        Toast.makeText(this, "Hello " + model.getUserName(), Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this, HomeActivity.class));
        finish();
    }

    @Override
    public void onLoginError(String error) {
        Toast.makeText(this, "Login error : " + error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegisterSuccess(UserModel model) {
        Toast.makeText(this, "Dang ki thanh cong", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegisterError(String error) {
        Toast.makeText(this, "Register error : " + error, Toast.LENGTH_SHORT).show();
    }
}