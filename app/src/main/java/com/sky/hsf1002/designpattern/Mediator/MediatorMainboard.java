package com.sky.hsf1002.designpattern.Mediator;

public class MediatorMainboard implements IMidiator{
    private ComponentCD cd;
    private ComponentCPU cpu;
    private ComponentSoundCard soundCard;
    private ComponentGraphicCard graphicCard;


    @Override
    public void changeState(Component component) {
        if (component == cd)
        {
            handleCD(cd.getData());
        }
        else if (component == cpu)
        {
            handleCPU();
        }
    }

    private void handleCD(String data)
    {
        cpu.decode(data);
    }


    private void handleCPU()
    {
        soundCard.playSound(cpu.getAudioData());
        graphicCard.playVideo(cpu.getVideoData());
    }


    public void setCd(ComponentCD cd) {
        this.cd = cd;
    }

    public void setCpu(ComponentCPU cpu) {
        this.cpu = cpu;
    }

    public void setSoundCard(ComponentSoundCard soundCard) {
        this.soundCard = soundCard;
    }

    public void setGraphicCard(ComponentGraphicCard graphicCard) {
        this.graphicCard = graphicCard;
    }
}
