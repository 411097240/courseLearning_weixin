package com.able.courseLearning.weixin.test;

import com.able.courseLearning.weixin.pojo.*;
import com.able.courseLearning.weixin.util.WeixinUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 微信菜单栏设置
 * @author hb
 *
 */
public class MenuManager {

	private static Logger log = LoggerFactory.getLogger(MenuManager.class);

	public static void main(String[] args) {
		/**
		 * 微信二次开发所必需的两个参数
		 * appId
		 * appSecret
		 */
		String appId = "wxfc8eae6dd688043e";
		String appSecret = "103d37579877c2a4e8a9b6b76b4b54bc";

		AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);
		if (null != at) {
			// 调用接口创建菜单
			int result = WeixinUtil.createMenu(getMenu(), at.getToken());
			if (0 == result){
				log.info("菜单创建成功！");
			}else{
				log.info("菜单创建失败，错误码：" + result);
			}
		}
	}
	/**
	 * 组装菜单数据
	 * 待优化：把所需要填写的数据传到前端，由页面填写
	 */
	private static Menu getMenu() {

		ViewButton btn11 = new ViewButton();
		btn11.setName("课堂签到");
		btn11.setType("view");
		btn11.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxfc8eae6dd688043e&redirect_uri=http%3a%2f%2fweixin.411097240qqcom.yxnat.softdev.top%2fcourseLearning_weixin%2ftest&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect");


//		ViewButton btn12 = new ViewButton();
//		btn12.setName("获得信息");
//		btn12.setType("view");
//		btn12.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxfc8eae6dd688043e&redirect_uri=http%3a%2f%2fweixin.411097240qqcom.yxnat.softdev.top%2ftogetinfo&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect");
//
//		ViewButton btn13 = new ViewButton();
//		btn13.setName("我的位置");
//		btn13.setType("view");
//		btn13.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxfc8eae6dd688043e&redirect_uri=http%3a%2f%2fweixin.411097240qqcom.yxnat.softdev.top%2foauthservlet&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect");
//
//		ViewButton btn21 = new ViewButton();
//		btn21.setName("菜单2.1");
//		btn21.setType("view");
//		btn21.setUrl("http://www.baidu.com");

		ViewButton btn22 = new ViewButton();
		btn22.setName("课堂直播");
		btn22.setType("view");
		btn22.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxfc8eae6dd688043e&redirect_uri=http%3a%2f%2fweixin.411097240qqcom.yxnat.softdev.top%2fcourseLearning_weixin%2ftest&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect");

		ViewButton btn23 = new ViewButton();
		btn23.setName("课程论坛");
		btn23.setType("view");
		btn23.setUrl("http://www.baidu.com");

		ViewButton btn31 = new ViewButton();
		btn31.setName("申请入班");
		btn31.setType("view");
		btn31.setUrl("http://weixin.411097240qqcom.yxnat.softdev.top/courseLearning_weixin/toH5Register");

/*		ViewButton btn32 = new ViewButton();
		btn32.setName("账户查询");
		btn32.setType("view");
		btn32.setUrl("http://www.zgjscyw.com/mloginOut.html");

		ViewButton btn33 = new ViewButton();
		btn33.setName("菜单3.2");
		btn33.setType("view");
		btn33.setUrl("http://www.baidu.com");*/

		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("课堂签到");
		mainBtn1.setSub_button( new Button[] {btn11});

		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("课程交流");
		mainBtn2.setSub_button(new ViewButton[] {  btn22, btn23 });

		ComplexButton mainBtn3 = new ComplexButton();
		mainBtn3.setName("申请入班");
		mainBtn3.setSub_button(new ViewButton[] { btn31 });

		Menu menu = new Menu();
		menu.setButton(new Button[] { btn11, mainBtn2, btn31 });
		return menu;
	}
}
