package comclass34.bssm.hellospring34.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 컨트롤러 임을 String boot에게 알림
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "home";
    }

}
