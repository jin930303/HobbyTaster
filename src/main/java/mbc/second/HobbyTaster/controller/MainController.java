package mbc.second.HobbyTaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = "/")
    public String home(){
        return "main";
    }

    @GetMapping(value = "/main")
    public String main(){
        return "main";
    }
}
