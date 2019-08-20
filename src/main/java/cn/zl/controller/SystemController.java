package cn.zl.controller;

import cn.zl.system.email.company.EmailSend;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;

/**
 * @author Alin
 * @version 1.0
 * @description // test
 * @date 2019/7/16 21:47
 */
@Controller
@RequestMapping("/system")
public class SystemController {
    private final EmailSend emailSend;

    public SystemController(EmailSend emailSend) {
        this.emailSend = emailSend;
    }

    @GetMapping("/mail/send")
    @ResponseBody
    public String sendSimpleMail() {
        try {
            byte[] arr= FileUtils.readFileToByteArray(new File("C:\\Users\\king_zl\\Pictures\\Saved Pictures\\4.jpg"));
            emailSend.sendSimpleMail(
                    "@qq.com",
                    "test for company has from",
                    "warning!",
                    "pic.jpg",
                    arr);
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
        System.out.println("send ok");
        return"ok";
    }

}
