package util;


import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;



import message.resp.Article;
import message.resp.NewsMessage;
import message.resp.TextMessage;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class MessageUtil 
{
	/**
	 * 返回消息类型：文本
	 */
	public static final String RESP_MESSAGE_TYPE_TEXT = "text";

	/**
	 * 返回消息类型：音乐
	 */
	public static final String RESP_MESSAGE_TYPE_MUSIC = "music";

	/**
	 * 返回消息类型：图文
	 */
	public static final String RESP_MESSAGE_TYPE_NEWS = "news";

	/**
	 * 请求消息类型：文本
	 */
	public static final String REQ_MESSAGE_TYPE_TEXT = "text";

	/**
	 * 请求消息类型：图片
	 */
	public static final String REQ_MESSAGE_TYPE_IMAGE = "image";

	/**
	 * 请求消息类型：链接
	 */
	public static final String REQ_MESSAGE_TYPE_LINK = "link";

	/**
	 * 请求消息类型：地理位置
	 */
	public static final String REQ_MESSAGE_TYPE_LOCATION = "location";

	/**
	 * 请求消息类型：音频
	 */
	public static final String REQ_MESSAGE_TYPE_VOICE = "voice";

	/**
	 * 请求消息类型：推送
	 */
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";

	/**
	 * 事件类型：subscribe(订阅)
	 */
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";

	/**
	 * 事件类型：unsubscribe(取消订阅)
	 */
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

	/**
	 * 事件类型：CLICK(自定义菜单点击事件)
	 */
	public static final String EVENT_TYPE_CLICK = "CLICK";
    @SuppressWarnings("unchecked") 
    public static Map<String, String> parseXml(HttpServletRequest request) throws Exception
    {  
        Map<String, String> map = new HashMap<String, String>();  
        InputStream inputStream = request.getInputStream();  
        SAXReader reader = new SAXReader();  
        Document document = reader.read(inputStream);  
        Element root = document.getRootElement();  
        List<Element> elementList = root.elements();     
        for (Element e : elementList)  
            map.put(e.getName(), e.getText());  
        inputStream.close();  
        inputStream = null;  
        return map;  
    }
    private static XStream xstream = new XStream(new XppDriver()
    {  
        public HierarchicalStreamWriter createWriter(Writer out) 
        {  
            return new PrettyPrintWriter(out) 
            {  
                boolean cdata = true;  
                @SuppressWarnings("rawtypes")
				public void startNode(String name, Class clazz)
                {  
                    super.startNode(name, clazz);  
                }  
                protected void writeText(QuickWriter writer, String text) 
                {  
                    if (cdata) 
                    {  
                        writer.write("<![CDATA[");  
                        writer.write(text);  
                        writer.write("]]>");  
                    } 
                    else 
                    {  
                        writer.write(text);  
                    }  
                }  
            };  
        }  
    });
    public static String textMessageToXml(TextMessage textMessage) 
    {  
        xstream.alias("xml", textMessage.getClass());  
        return xstream.toXML(textMessage);  
    } 
    public static String newsMessageToXml(NewsMessage newsMessage) 
    {  
        xstream.alias("xml", newsMessage.getClass());  
        xstream.alias("item", new Article().getClass());  
        return xstream.toXML(newsMessage);  
    } 

}
