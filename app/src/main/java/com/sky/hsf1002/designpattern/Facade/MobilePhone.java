package com.sky.hsf1002.designpattern.Facade;

/**
 * Created by temp on 17-9-13.
 */

public class MobilePhone {
    private ICamera camera;
    private IPhone phone;

    MobilePhone(ICamera camera, IPhone phone)
    {
        this.camera = camera;
        this.phone = phone;
    }

    public void takePicture()
    {
        camera.open();
        camera.takePicture();
    }

    public void dial()
    {
        phone.dial();
    }

    public void videoChat()
    {
        System.out.println("videoChat....");
        camera.open();
        phone.dial();
    }
}
