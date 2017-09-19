package com.sky.hsf1002.designpattern.Mediator;

public abstract class Component {
    protected IMidiator midiator;

    Component(IMidiator midiator)
    {
        this.midiator = midiator;
    }
}
