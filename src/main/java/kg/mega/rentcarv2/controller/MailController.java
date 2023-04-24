package kg.mega.rentcarv2.controller;

import kg.mega.rentcarv2.service.FeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/mail")
@RequiredArgsConstructor
public class MailController {
    private final FeignClient feignClient;

    @PostMapping("/sendMail")
    public void sendMail(@RequestParam String to, @RequestParam String subject, @RequestParam String text){
        feignClient.sendMail(to,subject,text);
    }
}
