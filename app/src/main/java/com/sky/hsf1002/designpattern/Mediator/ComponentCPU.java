package com.sky.hsf1002.designpattern.Mediator;

public class ComponentCPU extends Component {

    private String audioData;
    private String videoData;

    ComponentCPU(IMidiator midiator) {
        super(midiator);
    }

    public String getVideoData() {
        return videoData;
    }

    public String getAudioData() {
        return audioData;
    }


    public void decode(String data)
    {
        String [] datas = data.split(",");
        audioData = datas[0];
        videoData = datas[1];
        midiator.changeState(this);
    }
}
