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
 */
public class TestEmail {

    @Test
    public void testJavaMailSender() throws IOException, MessagingException {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost("smtp.163.com");
        sender.setUsername("1591034021@163.com");
        sender.setPassword("lin123456789");
        sender.setPort(25);
        sender.setProtocol("smtp");

        EmailSend emailSend = new EmailSend(sender);
        byte[] arr= FileUtils.readFileToByteArray(new File("C:\\Users\\king_zl\\Pictures\\Saved Pictures\\3.jpg"));
        emailSend.sendSimpleMail(
                "1343168470@qq.com",
                "test for company has from",
                "warning!",
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
        EmailUtil email = new EmailUtil("159121@163.com", "9");
        SendEmailMessage message = new SendEmailMessage();
        message.setFrom("159121@163.com");
        message.setRecipient("134470@qq.com");
        message.setSubject("镇长");
        message.setText("hello world");
        email.sendMail(DefaultConfigurer.getSMTP(), message);
        System.out.println("发送成功");
// 收邮件 
        /*email.receiveMail(DefaultConfigurer.getPOP3(), "pop3"); // pop3收信
        System.out.println("收取完毕");*/
// 使用IMAP收信会抛出 Failed to load IMAP envelope 异常 
//email.receiveMail(DefaultConfigurer.getIMAP(), "imap"); // imap收信
    }
} 