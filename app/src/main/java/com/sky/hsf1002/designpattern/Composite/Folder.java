package com.sky.hsf1002.designpattern.Composite;

import java.util.Iterator;
import java.util.List;

/**
 * Created by hsf1002 on 2017/9/17.
 */
public class Folder extends Dir {

    Folder(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public List<Dir> getList() {
        return super.getList();
    }

    @Override
    public void addDir(Dir dir) {
        list.add(dir);
    }

    @Override
    public void removeDir(Dir dir) {
        list.remove(dir);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public void print() {
        System.out.print(getName() +  "(");
        Iterator<Dir> iter = list.iterator();

        while(iter.hasNext())
        {
            Dir dir = iter.next();
            dir.print();
            if (iter.hasNext())
            {
                System.out.print(",  ");
            }
        }
        System.out.print(") \n");
    }
}
