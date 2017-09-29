package com.sky.hsf1002.designpattern.Prototype;

public class LoginImpl implements ILogin{
    @Override
    public void login(User user) {
        LoginSesstion loginSesstion = LoginSesstion.getInstance();
        loginSesstion.loginUser(user);
    }
}
