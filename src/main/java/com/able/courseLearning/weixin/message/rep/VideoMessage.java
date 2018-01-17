package com.able.courseLearning.weixin.message.rep;
/**
* 类名: VideoMessage </br>
* 描述: 请求消息之视频消息 </br>
 */

public class VideoMessage extends BaseMessage {
    // 媒体ID
    private String MediaId;
    // 语音格式
    private String ThumbMediaId;

    public String getMediaId() {
        return MediaId;
    }
    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
    public String getThumbMediaId() {
        return ThumbMediaId;
    }
    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }

}
