package kg.mega.rentcarv2.service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.cloud.openfeign.FeignClient(name = "mailSender", url = "http://localhost:7070/api/v1/mail")
public interface FeignClient {
    @PostMapping("/sendMail")
    void sendMail(@RequestParam String to, @RequestParam String subject, @RequestParam String text);
}
