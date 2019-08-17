package cn.zl.system.email.blog;

import lombok.Getter;
import lombok.Setter;

/**
 * 发送邮件消息包装属性类
 */
@Setter
@Getter
class SendEmailMessage {
    private String type; // 格式类型，如 text/html;charset=gbk
    private String from; // 发送人
    private String subject; // 标题
    private String text; // 内容
    private String recipient; // 接收人，多个接收人用逗号分隔
    private String datetime; // 发送时间
} 