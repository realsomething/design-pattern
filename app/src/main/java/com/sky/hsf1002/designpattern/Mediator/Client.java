package com.sky.hsf1002.designpattern.Mediator;

public class Client {
    public static void main(String [] args)
    {
        MediatorMainboard midiator = new MediatorMainboard();
        ComponentCD cd = new ComponentCD(midiator);
        ComponentCPU cpu = new ComponentCPU(midiator);
        ComponentSoundCard soundCard = new ComponentSoundCard(midiator);
        ComponentGraphicCard graphicCard = new ComponentGraphicCard(midiator);

        midiator.setCd(cd);
        midiator.setCpu(cpu);
        midiator.setSoundCard(soundCard);
        midiator.setGraphicCard(graphicCard);

        cd.load();
    }
}
