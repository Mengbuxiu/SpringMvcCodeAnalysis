package cn.zl.system.email.blog;

import java.util.Properties;


/**
 * 邮件默认配置类
 * 方法中的必要参好，可根据实际情况修改
 */
public class DefaultConfigurer {


    /**
     * 获取SMTP默认配置
     * SSL ？
     * @return
     */
    public static Properties getSMTP() {
        Properties p = new Properties();
        p.setProperty("mail.smtp.host", "smtp.163.com"); // 按需要更改
        p.setProperty("mail.smtp.protocol", "smtp");
        p.setProperty("mail.smtp.port", "465");
        p.setProperty("mail.smtp.auth", "true");
// SSL安全连接参数 
        p.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        p.setProperty("mail.smtp.socketFactory.fallback", "false");
        p.setProperty("mail.smtp.socketFactory.port", "465");
        return p;
    }

    /**
     * 获取POP3收信配置
     *
     * @return
     */
    public static Properties getPOP3() {
        Properties p = new Properties();
        p.setProperty("mail.pop3.host", "pop.163.com"); // 按需要更改
        p.setProperty("mail.pop3.port", "995");
// SSL安全连接参数 
        p.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        p.setProperty("mail.pop3.socketFactory.fallback", "false");
        p.setProperty("mail.pop3.socketFactory.port", "995");
        return p;
    }

    /**
     * 获取IMAP收信配置
     *
     * @return
     */
    public static Properties getIMAP() {
        Properties p = new Properties();
        p.setProperty("mail.imap.host", "imap.163.com"); // 按需要更改
        p.setProperty("mail.imap.port", "993");
// SSL安全连接参数 
        p.setProperty("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        p.setProperty("mail.imap.socketFactory.fallback", "false");
        p.setProperty("mail.imap.socketFactory.port", "993");
        return p;
    }
} 