package com.able.courseLearning.weixin.message.resp;
/**
* 类名: MusicMessage </br>
* 描述: 音乐消息 </br>
 */
public class MusicMessage extends BaseMessage{
    // 音乐
    private Music Music;

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        Music = music;
    }
}
