package cn.zl.system.email;

/**
 * 测试类
 */
public class TestEmail {

    /**
     * 程序入口点
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
// 默认情况下，在这里输入QQ号和密码，便可收信与发信 
        EmailUtil email = new EmailUtil("15910344021@163.com", "lin123456789");
        SendEmailMessage message = new SendEmailMessage();
        message.setFrom("15910344021@163.com");
        message.setRecipient("1343168470@qq.com");
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