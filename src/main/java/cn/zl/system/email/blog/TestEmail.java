package cn.zl.system.email.blog;

import cn.zl.system.email.company.EmailSend;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;

/**
 * 测试类
 * 常见错误 账号或密码错误导致的
 * javax.mail.AuthenticationFailedException: 535 Error: authentication failed
 */
public class TestEmail {

    @Test
    public void testJavaMailSender() throws IOException, MessagingException {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost("smtp.163.com");
        sender.setUsername("@163.com");
        sender.setPassword("lin123465789");
        sender.setPort(465);
//        sender.setProtocol("ssl");

        EmailSend emailSend = new EmailSend(sender);
        byte[] arr= FileUtils.readFileToByteArray(new File("C:\\Users\\king_zl\\Pictures\\Saved Pictures\\4.jpg"));
        emailSend.sendSimpleMail(
                "@qq.com",
                "test for company has from",
                "hello!",
                "pic.jpg",
                arr);
    }

    /**
     * smtp SSL 发邮件
     * @throws Exception
     */
    @Test
    public void testSSL() throws Exception {
// 默认情况下，在这里输入QQ号和密码，便可收信与发信 
        EmailUtil email = new EmailUtil("@163.com", "");
        SendEmailMessage message = new SendEmailMessage();
        message.setFrom("@163.com");
        message.setRecipient("@qq.com");
        message.setSubject("大哥哎~yo");
        message.setText("类好哇");
        email.sendMail(DefaultConfigurer.getSMTP(), message);
        System.out.println("发送成功");
// 收邮件 
        /*email.receiveMail(DefaultConfigurer.getPOP3(), "pop3"); // pop3收信
        System.out.println("收取完毕");*/
// 使用IMAP收信会抛出 Failed to load IMAP envelope 异常 
//email.receiveMail(DefaultConfigurer.getIMAP(), "imap"); // imap收信
    }
}