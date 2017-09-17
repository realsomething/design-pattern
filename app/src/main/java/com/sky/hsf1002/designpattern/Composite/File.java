package com.sky.hsf1002.designpattern.Composite;

import java.util.List;

/**
 * Created by hsf1002 on 2017/9/17.
 */
public class File extends Dir {
    File(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public List<Dir> getList() {
        throw new UnsupportedOperationException("file not supported this operation.");
    }

    @Override
    public void addDir(Dir dir) {
        throw new UnsupportedOperationException("file not supported this operation.");
    }

    @Override
    public void removeDir(Dir dir) {
        throw new UnsupportedOperationException("file not supported this operation.");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("file not supported this operation.");
    }

    @Override
    public void print() {
        System.out.print(getName());
    }
}
