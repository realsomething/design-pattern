package com.sky.hsf1002.designpattern.Facade;

/**
 * Created by temp on 17-9-13.
 */

public class Client {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ICamera camera = new Camera();
        IPhone phone = new Phone();
        MobilePhone mp = new MobilePhone(camera, phone);

        mp.takePicture();
        mp.dial();
        mp.videoChat();
    }
}
