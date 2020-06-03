package com.example.homework;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.homework.base.BaseActivity;
import com.example.homework.base.BasePre;


public class LoginActivity extends BaseActivity{

    private EditText mUsernameLogin;
    private EditText mPassWordLogin;
    private Button mSubmitLogin;
    private Button mOkLogin;

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {

        mUsernameLogin = (EditText) findViewById(R.id.login_username);
        mPassWordLogin = (EditText) findViewById(R.id.login_passWord);
        mSubmitLogin = (Button) findViewById(R.id.login_submit);

        mOkLogin = (Button) findViewById(R.id.login_ok);

    }

    @Override
    protected BasePre initPre() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }



}