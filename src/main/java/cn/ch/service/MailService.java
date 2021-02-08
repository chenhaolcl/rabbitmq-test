package cn.ch.service;

import org.springframework.mail.SimpleMailMessage;

/**
 * @Interfacename MailService
 * @Description
 * @create 2021/2/5
 * @Author random
 */
public interface MailService {

    SimpleMailMessage createMail();

}
