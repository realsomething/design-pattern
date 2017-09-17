package com.sky.hsf1002.designpattern.Composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hsf1002 on 2017/9/17.
 */
public abstract class Dir {
    protected String name;
    protected List<Dir> list = new ArrayList<>();

    Dir(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Dir> getList() {
        return list;
    }

    public abstract void addDir(Dir dir);
    public abstract void removeDir(Dir dir);
    public abstract void clear();
    public abstract void print();
}
