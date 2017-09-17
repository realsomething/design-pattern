package com.sky.hsf1002.designpattern.Composite;

/**
 * Created by hsf1002 on 2017/9/17.
 */
public class Client {

    public static void main(String [] args)
    {
        Dir root = new Folder("root");
        Folder windows = new Folder("windows");
        Folder system32 = new Folder("system32");
        Folder user = new Folder("user");

        root.addDir(windows);
        root.addDir(system32);
        root.addDir(user);
        root.print();

        File file0 = new File("file0");
        File file1 = new File("file1");
        File file2 = new File("file2");
        windows.addDir(file0);
        system32.addDir(file1);
        user.addDir(file2);
        root.print();

        Folder system64 = new Folder("system64");
        File file3 = new File("file3");
        system64.addDir(file3);
        windows.addDir(system64);
        root.print();
    }
}
