package com.able.courseLearning.weixin.message.resp;
/**
* 类名: VoiceMessage </br>
* 描述: 语音消息</br>
 */
public class VoiceMessage extends BaseMessage {
	//语音
    private Voice Voice;

    public Voice getVoice() {
        return Voice;
    }

    public void setVoice(Voice voice) {
        Voice = voice;
    }
}
