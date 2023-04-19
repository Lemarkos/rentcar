package kg.rentcar.emailsender.controller;

import kg.rentcar.emailsender.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/mail")
@RequiredArgsConstructor
public class EmailController{
    private final EmailService emailService;

    @PostMapping("/sendMail")
    public void sendMessage(@RequestParam String to, @RequestParam String subject, @RequestParam String text){
        emailService.sendSimpleMessage(to,subject,text);
    }
}
