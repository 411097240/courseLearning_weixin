package com.able.courseLearning.weixin.message.resp;
/**
* 类名: ImageMessage </br>
* 描述: 图片消息</br>
 */
public class ImageMessage extends BaseMessage {

    private Image Image;

    public Image getImage() {
        return Image;
    }

    public void setImage(Image image) {
        Image = image;
    }
}
