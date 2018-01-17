package com.able.courseLearning.weixin.message.rep;
	/**
	* 类名: ImageMessage </br>
	* 描述: 请求消息之图片消息 </br>
	 */
public class ImageMessage extends BaseMessage {
	 // 图片链接
    private String PicUrl;
    private String MediaId;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
