package com.sky.hsf1002.designpattern.Prototype;

public class Client {

    public static void main(String[] args) {
        Address address = new Address("shenzhen", "baoan", "xixiang");
        User user = new User("sky", 20, address);

        LoginImpl login = new LoginImpl();
        login.login(user);      // save user

        LoginSesstion loginSesstion = LoginSesstion.getInstance();
        System.out.println(user);
        System.out.println(loginSesstion.getUser());

        user.setName("lotus");
        user.setAge(23);
        user.setAddress(new Address("shenzhen", "nanshan", "science park"));
        System.out.println(user);
        System.out.println(loginSesstion.getUser());
    }
}
