package com.able.courseLearning.weixin.pojo;
/**
* 类名: CommonButton </br>
* 包名： com.souvc.weixin.menu
* 描述: 子菜单项 :没有子菜单的菜单项，有可能是二级菜单项，也有可能是不含二级菜单的一级菜单。 </br>
 */
public class CommonButton extends Button {

	/**
	 * 菜单类型
	 */
	private String type;

	/**
	 * KEY值，最大不超过128字节。
	 */
	private String key;


	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}


}
