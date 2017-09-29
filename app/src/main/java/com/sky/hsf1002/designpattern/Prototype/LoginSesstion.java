package com.sky.hsf1002.designpattern.Prototype;

public class LoginSesstion {
    private static LoginSesstion sLoginSession;
    private User user;

    private LoginSesstion(){}

    public static LoginSesstion getInstance()
    {
        if (sLoginSession == null)
        {
            sLoginSession = new LoginSesstion();
        }

        return sLoginSession;
    }

    // default package visit attribute, inaccessible for other modules
    /*public*/void  loginUser(User user)
    {
        this.user = user;
    }

    public User getUser(){
        return (User)user.clone();
    }
}
