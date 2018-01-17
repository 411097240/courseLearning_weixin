package com.able.courseLearning.weixin.message.event;
/**
* 类名: MenuEvent </br>
* 描述: 自定义菜单事件 </br>
 */
public class MenuEvent {

	/**
	 * 事件KEY值，与自定义菜单接口中KEY值对应
	 */
    private String EventKey;

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }
}
