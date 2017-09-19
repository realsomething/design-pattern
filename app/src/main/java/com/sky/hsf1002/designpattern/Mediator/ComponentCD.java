package com.sky.hsf1002.designpattern.Mediator;

public class ComponentCD extends Component{
    private String data;

    ComponentCD(IMidiator midiator) {
        super(midiator);
    }

    public String getData()
    {
        return data;
    }

    public void load()
    {
        data = "Backstreets.,GodFather.";
        midiator.changeState(this);
    }
}
