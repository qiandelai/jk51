package cn.itcast.jk.mailTest;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class TestMail {
	@Test
	public void f1(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-mail.xml");
		SimpleMailMessage message = (SimpleMailMessage) context.getBean("mailMessage");
		JavaMailSenderImpl mailSender = (JavaMailSenderImpl) context.getBean("mailSender");
		message.setTo("1147226155@qq.com");
		message.setSubject("面对疾风吧");
		message.setText("开黑吗，我玩压缩贼6");
		mailSender.send(message);
	}
	
	@Test
	public void f2() throws Exception{
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-mail.xml");
		JavaMailSenderImpl mailSender = (JavaMailSenderImpl) context.getBean("mailSender");
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom("itheima14@163.com");
		helper.setTo("1147226155@qq.com");
		helper.setSubject("面对疾风吧");
		helper.setText("<html><head></head><body><h1>hello!!spring image html mail</h1><a href=http://www.baidu.com>baidu</a><img src='cid:image' /></body></html>",true);
		helper.addInline("image", new File("D:\\image\\2a94883b-bc71-4b25-a90e-7c8792743521.jpg"));
		helper.addAttachment("1.sql", new File("D:\\1.sql"));
		mailSender.send(message);
	}
	
	@Test
	public void f3() throws Exception{
	
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-mail.xml");
		JavaMailSenderImpl mailSender = (JavaMailSenderImpl) context.getBean("mailSender");
		mailSender.setHost("localhost");
		mailSender.setUsername("abc");
		mailSender.setPassword("123");
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom("abc@store.com");
//		helper.setTo("18297604236@163.com");
		helper.setTo("kkk@store.com");
		helper.setSubject("面对疾风吧");
		helper.setText("<html><head></head><body><h1>hello!!spring image html mail</h1><a href=http://www.baidu.com>baidu</a><img src='cid:image' /></body></html>",true);
		helper.addInline("image", new File("D:\\image\\2a94883b-bc71-4b25-a90e-7c8792743521.jpg"));
		helper.addAttachment("1.sql", new File("D:\\1.sql"));
		mailSender.send(message);
	}
}
