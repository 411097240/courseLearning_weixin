package com.able.courseLearning.weixin.util;

import com.able.courseLearning.weixin.message.resp.TextMessage;
import com.able.courseLearning.weixin.message.resp.Article;
import com.able.courseLearning.weixin.message.resp.NewsMessage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 描述: 核心服务类 </br>
 */
public class CoreService {
	/**
	 * 处理微信发来的请求
	 * @param request
	 * @return xml
	 * 代码待优化：所需数据可以从前端获取，写一些相关页面
	 */
	public static String processRequest(HttpServletRequest request,HttpServletResponse response) {
		String respXml = null;
		String respContent = null;
		try {
			// 调用parseXml方法解析请求消息
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			String fromUserName = requestMap.get("FromUserName");
			String toUserName = requestMap.get("ToUserName");
			String msgType = requestMap.get("MsgType");
			String content = requestMap.get("Content");
			//经度
			String Longitude = requestMap.get("Longitude");
			//纬度
			String Latitude = requestMap.get("Latitude");
			//openId
			String FromUserName = requestMap.get("FromUserName");

			/**
			 * 回复文本消息
			 */
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

			 //回复图文消息
			NewsMessage newsMessage = new NewsMessage();
			newsMessage.setToUserName(fromUserName);
			newsMessage.setFromUserName(toUserName);
			newsMessage.setCreateTime(new Date().getTime());
			newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
			// 文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				if ("1".equals(content)) {
					respContent = "开发者姓名：***";
				} else if ("2".equals(content)) {
					respContent = "QQ:*********";
				} else{
					respContent = "您发送的是"+content;
				}
			}
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				respContent = "您发送的是图片消息！";
			}
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respContent = "您发送的是语音消息！";
			}
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {
				respContent = "您发送的是视频消息！";
			}
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_SHORTVIDEO)) {
				respContent = "您发送的是小视频消息！";
			}
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "您发送的是地理位置消息！";
			}
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "您发送的是链接消息！";
			}
			/**
			 * 事件推送
			 */
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				String eventType = requestMap.get("Event");
				/**
				 * 关注
				 */
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					respContent = "欢迎你关注weixin411097240接口测试号\n回复1查看开发者姓名；\n回复2查看开发者联系方式；";
				}
				/**
				 * 取消关注
				 */
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// 取消订阅后用户不会再收到公众账号发送的消息，因此不需要回复
				}
				/**
				 * 扫描带参数二维码事件
				 */
				else if (eventType.equals(MessageUtil.EVENT_TYPE_SCAN)) {
				}
				/**
				 * 上报地理位置事件
				 */
				else if (eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)) {
					// TODO 处理上报地理位置事件
					System.out.println("openId:"+FromUserName);
					System.out.println("上报地理位置事件  经度："+ Longitude+"   纬度："+Latitude);
					//redis保存用户的位置信息
							
				}
				// 自定义菜单消息处理
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					String eventKey = requestMap.get("EventKey");
					if(eventKey.equals("key_1")){
						System.out.print("key_1");
						Article article = new Article();
						//单图文消息图片下边的简介
						article.setDescription("中国建设产业网经10年建设行业经验累积而成，是集工程项目、建材供需、名人优企、人才输送、行业信息等为一体的多元化的全产业信息集群建设产业门户导航。");
						// 图片的链接
						article.setPicUrl("https://mmbiz.qlogo.cn/mmbiz_jpg/mQoia4S35C4iadkU2RWON3pzqnFNpnqWYj8X1l7ZdSpTxaHS1D593M7NoqMGmQhp3CvM1FhR3k0oiaQ0uicPEnUgjQ/0?wx_fmt=jpeg");
						//单图文消息的标题
						article.setTitle("中国建设产业网：关于公司");
						// 图文消息的链接地址
						article.setUrl("http://mp.weixin.qq.com/s/jNPD6F_dI6SEtykb0sXAUQ");
						List<Article> list = new ArrayList<Article>();
						// 这里发送的是单图文，如果需要发送多图文则在这里list中加入多个Article即可！
						list.add(article);
						newsMessage.setArticleCount(list.size());
						newsMessage.setArticles(list);
						return MessageUtil.messageToXml(newsMessage);
					}
					
					if(eventKey.equals("key_2")){
						System.out.print("key_2");
						respContent = "你点击的是click按钮2！";
						
					}
					
					/*String eventKey = requestMap.get("EventKey");
					if (eventKey.equals("11")) {
						Article article = new Article();
						//单图文消息图片下边的简介
						article.setDescription("中国建设产业网经10年建设行业经验累积而成，是集工程项目、建材供需、名人优企、人才输送、行业信息等为一体的多元化的全产业信息集群建设产业门户导航。");
						// 图片的链接
						article.setPicUrl("https://mmbiz.qlogo.cn/mmbiz_jpg/mQoia4S35C4iadkU2RWON3pzqnFNpnqWYj8X1l7ZdSpTxaHS1D593M7NoqMGmQhp3CvM1FhR3k0oiaQ0uicPEnUgjQ/0?wx_fmt=jpeg");
						//单图文消息的标题
						article.setTitle("中国建设产业网：关于公司");
						// 图文消息的链接地址
						article.setUrl("http://mp.weixin.qq.com/s/jNPD6F_dI6SEtykb0sXAUQ");
						List<Article> list = new ArrayList<Article>();
						// 这里发送的是单图文，如果需要发送多图文则在这里list中加入多个Article即可！
						list.add(article);
						newsMessage.setArticleCount(list.size());
						newsMessage.setArticles(list);
						return MessageUtil.messageToXml(newsMessage);
					}

					if (eventKey.equals("12")) {
						Article article = new Article();
						article.setDescription("中国建设产业网经10年建设行业经验累积而成，是集工程项目、建材供需、名人优企、人才输送、行业信息等为一体的多元化的全产业信息集群建设产业门户导航。");
						article.setPicUrl("https://mmbiz.qlogo.cn/mmbiz_jpg/mQoia4S35C4gvfYVeCmwD2OXPjhgA4xmyPmUYpJ5Wl2rgo3ricaemk0z7NwpUHD2wFNn0tovwhpRws8OWzVGo9yw/0?wx_fmt=jpeg");
						article.setTitle("中国建设产业网：关于团队");
						article.setUrl("http://mp.weixin.qq.com/s/_Gf_DpHTR1yH03qX1mCRkg");
						List<Article> list = new ArrayList<Article>();
						list.add(article);
						newsMessage.setArticleCount(list.size());
						newsMessage.setArticles(list);
						return MessageUtil.messageToXml(newsMessage);
					}*/
				}
			}
			textMessage.setContent(respContent);
			respXml = MessageUtil.messageToXml(textMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respXml;
	}
}
