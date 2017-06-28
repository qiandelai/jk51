package cn.itcast.jk.utils;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 邮件发送的工具类
 * @author Administrator
 */
public class MailUtils {
	
	/**
	 * 发送邮件的方法
	 * @param toAddress	收件人地址
	 * @param subject	邮件的主题
	 * @param content	邮件的正文
	 * @throws Exception
	 */
	public static void sendMessage(String toAddress,String subject,String content) throws Exception{
		// 创建Properties属性文件
		Properties pro = new Properties();
		// 主机地址是163，如果采用其他服务器可以设置，例如：smtp.qq.com smtp.126.com smtp.sina.com
		pro.put("mail.smtp.host","smtp.163.com");
		// 设置是否需要认证
		pro.put("mail.smtp.auth",true);
		// 获取到Session的连接对象
		Session session = Session.getInstance(pro);
		// 创建邮件对象
		MimeMessage message = new MimeMessage(session);
		// 发件人地址
		Address fromAddr = new InternetAddress("itheima14@163.com");
		// 设置发件人
		message.setFrom(fromAddr);
		// 收件人地址
		Address toAddr = new InternetAddress(toAddress);
		// 设置收件人
		message.setRecipient(RecipientType.TO, toAddr);
		// 设置邮件的主题
		message.setSubject(subject);
		// 设置邮件的正文
		message.setText(content);
		// 保存这封邮件
		message.saveChanges();
		// 获取发送邮件对象
		Transport transport = session.getTransport("smtp");
		// 设置邮件的账号和密码
		transport.connect("smtp.163.com", "itheima14", "iamsorry123");
		// 发送邮件
		transport.sendMessage(message, message.getAllRecipients());
		// 关闭资源
		transport.close();
	}

}
