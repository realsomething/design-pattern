package com.sky.hsf1002.designpattern.Mediator;

public class ComponentGraphicCard extends Component {

    ComponentGraphicCard(IMidiator midiator) {
        super(midiator);
    }

    public void playVideo(String data)
    {
        System.out.println("play video data: " + data);
    }
}
