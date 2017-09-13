package com.sky.hsf1002.designpattern.Facade;

import android.util.Log;

/**
 * Created by temp on 17-9-13.
 */

public class Phone implements IPhone {

    @Override
    public void dial() {
        System.out.println("dial: Phone");
    }

    @Override
    public void hangup() {
        System.out.println("hangup: Phone");
    }
}
