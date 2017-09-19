package com.sky.hsf1002.designpattern.Mediator;

public class ComponentSoundCard extends Component {


    ComponentSoundCard(IMidiator midiator) {
        super(midiator);
    }

    public void playSound(String audioData)
    {
        System.out.println("play audio data: " + audioData);
    }

}
