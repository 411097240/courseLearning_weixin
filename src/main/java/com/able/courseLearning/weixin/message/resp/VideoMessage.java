package com.able.courseLearning.weixin.message.resp;
/**
* 类名: VideoMessage </br>
* 描述: 视频消息 </br>
 */
public class VideoMessage extends BaseMessage {
    // 视频
    private Video Video;

    public Video getVideo() {
        return Video;
    }

    public void setVideo(Video video) {
        Video = video;
    }
}
