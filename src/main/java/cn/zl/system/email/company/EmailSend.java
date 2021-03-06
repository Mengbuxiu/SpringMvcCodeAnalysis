package cn.zl.system.email.company;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.UnsupportedEncodingException;

/**
 * @author Alin
 * @version 1.0
 * @description // 邮件发送工具类
 * @date 2019/8/15 14:12
 */
@Component("emailSend")
public class EmailSend {
    private final JavaMailSender mailSender;

    public EmailSend(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendSimpleMail(String to,
                               String mailTitle,
                               String mailContent,
                               String attachmentFileName,
                               byte[] attachmentFile) throws MessagingException, UnsupportedEncodingException {
        MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
        if (attachmentFile != null && attachmentFile.length != 0) {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage,true,"UTF-8");
            mimeMessageHelper.addAttachment(
                    MimeUtility.encodeWord(attachmentFileName),
                    new ByteArrayResource(attachmentFile));
        }else {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        }
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setFrom("@163.com");
        mimeMessageHelper.setSubject(mailTitle);
        mimeMessageHelper.setText(mailContent);
        mailSender.send(mimeMessage);
    }

}

