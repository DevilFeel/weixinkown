package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import message.resp.Article;
import message.resp.NewsMessage;
import message.resp.TextMessage;
import util.MessageUtil;

public class CoreService {

	public static String processRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String respMessage = null;
		try{
			//默认返回的文本消息内容
			String respContent = "请求处理异常，请稍后尝试！";
			
			//xml解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			
			//发送方帐号(open_id)
			String fromUserName = requestMap.get("FromUserName");
			
			//公众帐号
			String toUserName = requestMap.get("ToUserName");
			
			//消息类型
			String msgType = requestMap.get("MsgType");
			
			//回复文本消息
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);
			
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				String reqContent = requestMap.get("Content").replace(" ", "");
				
				//创建图文消息
				NewsMessage newsMessage = new NewsMessage();
				newsMessage.setToUserName(fromUserName);
				newsMessage.setFromUserName(toUserName);
				newsMessage.setCreateTime(new Date().getTime());
				newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
				newsMessage.setFuncFlag(0);
				
				List<Article> articleList = new ArrayList<Article>();
				if("1".equals(reqContent)){
					Article article = new Article();
					article.setTitle("【计算机 • 迎新专栏】大学生生活规划指导】");
					article.setDescription("大学生活规划应从大一做起，大学时期是毕业起跑的助跑期。只有做好了规划，才能坦然地面对大学四年和未来的生活。");
					article.setPicUrl("http://1.weixinkown.sinaapp.com/images/life.jpg");
					article.setUrl("http://mp.weixin.qq.com/s?__biz=MzA5MjM2MjYxNA==&mid=200819203&idx=1&sn=a2c85400c5fe468731828411ce1d08e3#rd");
					articleList.add(article);
					//设置图文消息个数
					newsMessage.setArticleCount(articleList.size());
					//设置图文消息包含的图文集合
					newsMessage.setArticles(articleList);
					//将图文消息对象转换成xml字符串
					respMessage = MessageUtil.newsMessageToXml(newsMessage);
				}
				
//				respContent = "您发送的是文本消息！";
			}
			// 图片消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				respContent = "您发送的是图片消息！";
			}
			// 地理位置消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "您发送的是地理位置消息！";
			}
			// 链接消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "您发送的是链接消息！";
			}
			// 音频消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respContent = "您发送的是音频消息！";
			}
			// 事件推送
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// 事件类型
				String eventType = requestMap.get("Event");
				// 订阅
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					respContent = "谢谢您的关注！";
				}
				// 取消订阅
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
				}
				// 自定义菜单点击事件
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					// TODO 自定义菜单权没有开放，暂不处理该类消息
				}
			}

			//textMessage.setContent(respContent);
			//respMessage = MessageUtil.textMessageToXml(textMessage);
		}catch(Exception e){
			e.printStackTrace();
		}
		return respMessage;
	}
	
}