package com.audi.utils;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 邮件服务
 *
 * @author WangQuanzhou
 * @date 2019-05-24
 */
public class MailUtil {
    public static void send(String from, String to, String subject, String content) {

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器主机名
        properties.setProperty("mail.host", "smtp.163.com");
        // 发送邮件协议名称
        properties.setProperty("mail.transport.protocol", "smtp");

        // 获取默认的 Session 对象。
        Session session = Session.getDefaultInstance(properties);

        try {
            // 创建默认的 MimeMessage 对象。
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: 头字段
            message.setSubject(subject);

            // 发送 HTML 消息, 可以插入html标签
            message.setContent(content, "text/html");

            // 发送消息
            Transport transport = session.getTransport();
            // 连接邮件服务器(账号，授权码)
            transport.connect("wangquanzhou666", "W513723");
            transport.sendMessage(message, message.getAllRecipients());
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        send("wangquanzhou666@163.com", "audi.car@qq.com", "this is test e-mail", "<h1>This is actual message</h1> ");
    }
}
