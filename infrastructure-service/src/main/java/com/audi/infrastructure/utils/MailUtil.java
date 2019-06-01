package com.audi.infrastructure.utils;


import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


/**
 * 邮件服务类
 *
 * @author WangQuanzhou
 * @date 2019-06-01
 */
public class MailUtil {

    public static void sendEmail(String from, String to, String code, String sunject, String content) throws Exception {
        Properties props = new Properties();

        // 开启debug调试
        props.setProperty("mail.debug", "true");
        // 发送服务器需要身份验证
        props.setProperty("mail.smtp.auth", "true");
        // 设置邮件服务器主机名
        props.setProperty("mail.host", "smtp.qq.com");
        // 发送邮件协议名称
        props.setProperty("mail.transport.protocol", "smtp");

        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);

        Session session = Session.getInstance(props);

        MimeMessage msg = new MimeMessage(session);
        msg.setSubject(sunject);
        StringBuilder sb = new StringBuilder();
        sb.append(content).append(code);
        msg.setText(sb.toString());
        msg.setFrom(new InternetAddress(from));
        msg.addRecipients(Message.RecipientType.TO, to);

        Transport transport = session.getTransport();
        transport.connect("smtp.qq.com", from, "jzqldxeyllulbbff");

        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();

    }

    public static void main(String[] args) throws Exception {
        sendEmail("audi.car@qq.com", "wangquanzhou666@163.com", CodeUtil.generateCode(6),
                "注册验证码", "您的验证码是：");
    }

}
