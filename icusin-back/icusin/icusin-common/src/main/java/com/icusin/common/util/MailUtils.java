package com.icusin.common.util;

import com.icusin.common.constant.ConfigConsts;
import com.icusin.common.exception.BusinessException;
import com.sun.mail.util.MailSSLSocketFactory;
import lombok.extern.slf4j.Slf4j;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Properties;

/**
 * 邮件发送工具类
 * http://www.imooc.com/video/14266
 * http://www.runoob.com/java/java-sending-email.html
 *
 * @author xujiangjun
 * @date 2017-07-25 11:27
 */
@Slf4j
public class MailUtils {

    /*时间格式*/
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");

    /**
     * 邮件发送者
     **/
    private static final String from = "icusin@163.com";

    /**
     * 邮件发送者密码
     **/
    private static final String password = "icusin163";

    /**
     * smtp邮件服务器
     **/
    private static final String host = "smtp.163.com";

    /* 邮箱服务器前缀 */
    private static final String MAIL_SERVER_PRE_FIX = "https://mail.";

    /**
     * 发送邮件
     *
     * @param toUser  目标用户
     * @param subject 邮件主题
     * @param content 邮件正文
     */
    public static void sendMail(String toUser, String subject, String content) {
        // 1.创建连接对象，连接到邮箱服务器
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        setMailSSL(props);
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 使用时请替换邮箱账号和密码
                return new PasswordAuthentication(from, password);
            }
        });

        session.setDebug(true);

        // 2.创建默认的MimeMessage对象
        try {
            MimeMessage message = new MimeMessage(session);
            // 2.1设置发件人
            message.setFrom(new InternetAddress(from));
            // 2.2设置收件人
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toUser));
            // 2.3设置邮件主题
            message.setSubject(subject);
            // 2.4设置邮件正文
            message.setContent(content, "text/html;charset=UTF-8");
            // 2.5发送邮件
            Transport.send(message);
        } catch (MessagingException e) {
            String msg = new StringBuilder("邮件发送失败，toUser:").append(toUser).append(", subject:").append(subject)
                    .append(", content:").append(content).toString();
            log.error(msg, e);
            throw new BusinessException("", "邮件发送失败");
        }
    }

    /**
     * 163邮箱可以不用设置SSL，但是QQ邮箱必须设置SSL加密
     *
     * @param props props
     */
    private static void setMailSSL(Properties props) {
        try {
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            props.put("mail.smtp.ssl.enable", "true");
            props.put("mail.smtp.ssl.socketFactory", sf);
        } catch (GeneralSecurityException e) {
            throw new BusinessException("", "初始化MailSSLSocketFactory异常");
        }
    }

    /**
     * 发送注册激活邮件
     *
     * @param toUser 注册用户
     * @param code   激活码 - 通过UUID产生，去除连字符
     */
    public static void sendActivateMail(String toUser, String account, String code) {

        String content = "<div style=\"background-color:#fff; padding: 35px;\">\n" +
                "<table cellpadding=\"0\" align=\"center\" style=\"width: 600px; margin: 0px auto; text-align: left; position: relative; border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 5px; border-bottom-left-radius: 5px; font-size: 14px; font-family:微软雅黑, 黑体; line-height: 1.5; box-shadow: rgb(153, 153, 153) 0px 0px 5px; border-collapse: collapse; background-position: initial initial; background-repeat: initial initial;background:#fff;\">\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<th valign=\"middle\" style=\"height: 25px; line-height: 25px; padding: 15px 35px; border-bottom-width: 0px; border-bottom-style: solid; background-color: #60b030; border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 0px; border-bottom-left-radius: 0px;\">\n" +
                "<font face=\"微软雅黑\" size=\"5\" style=\"color: rgb(255, 255, 255); \">" +
                ConfigConsts.WWW_SERVER_NAME_EN + " （" + ConfigConsts.WWW_SERVER_NAME_ZH + "网）</font>\n" +
                "</th>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td>\n" +
                "<div style=\"padding:25px 35px 40px; background-color:#fff;\">\n" +
                "<h2 style=\"margin: 5px 0px; \"><font color=\"#333333\" style=\"line-height: 20px; \"><font style=\"line-height: 22px; \" size=\"4\">亲爱的表亲：</font></font></h2>\n" +
                "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;首先感谢您加入表亲！\n" +
                "请您在发表言论时，遵守当地法律法规。\n" +
                "哈哈又多一个表亲, 欢迎访问表亲官网:<a href=\"" +
                ConfigConsts.HTTPS_WWW_SERVER_ADD + "\">" +
                ConfigConsts.HTTPS_WWW_SERVER_ADD + "</a>.\n" +
                "如果您有什么疑问请随时联系管理员，Email: " +
                ConfigConsts.WWW_SERVER_ADMIN_EMAIL + "。</p>\n" +
                "<br/>请您点击下面的链接激活新用户:" +
                "<p><div style=\"word-wrap:break-word;\"><a href='" +
                ConfigConsts.HTTPS_WWW_SERVER_ADD + "/user/activate/" +
                account + "?code=" + code + "'>" +
                ConfigConsts.HTTPS_WWW_SERVER_ADD + "/user/activate/" +
                account + "?code=" + code + "</a></div></p>" +
                "<p align=\"right\">表亲! 官方团队</p>\n" +
                "<p align=\"right\">" +
                sdf.format(System.currentTimeMillis()) + "</p>\n" +
                "</div>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "</div>";

        String subject = "来自表亲网的激活邮件";
        sendMail(toUser, subject, content);
    }

    /**
     * 获取邮箱登录地址
     *
     * @param email 邮箱地址
     * @return 返回对应的登录地址
     */
    public static String getMailLoginAdd(String email) {

        int subIndex = email.indexOf("@");

        // 截取后面的部分
        return MAIL_SERVER_PRE_FIX + email.substring(subIndex + 1);
    }
}
