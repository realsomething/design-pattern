package com.sky.hsf1002.designpattern.Facade;

import android.util.Log;

/**
 * Created by temp on 17-9-13.
 */

public class Camera implements ICamera {

    @Override
    public void open() {
        System.out.println("open: Camera");
    }

    @Override
    public void takePicture() {
        System.out.println("takePicture: Camera");
    }

    @Override
    public void close() {
        System.out.println("close: Camera");
    }
}
