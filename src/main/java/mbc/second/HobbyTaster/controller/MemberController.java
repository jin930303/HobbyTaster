package mbc.second.HobbyTaster.controller;

import lombok.extern.slf4j.Slf4j;
import mbc.second.HobbyTaster.dto.MemberDTO;
import mbc.second.HobbyTaster.entity.MemberEntity;
import mbc.second.HobbyTaster.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@Controller
public class MemberController {

    @Autowired
    MemberService ms;

    @GetMapping(value = "/memberinput")
    public String memberinput(){
       return "member/memberinput";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "member/login";
    }

    @PostMapping(value = "/membersave")
    public String membersave(@RequestParam("phonemid") int phonemid, @RequestParam("phoneend") int phoneend,
                             @RequestParam("email") String email, @RequestParam("domain") String domain, MemberDTO dto) {
        dto.setEmail(email+domain);
        dto.setPhone("010"+"-"+phonemid+"-"+phoneend);
        dto.setAuth(1);
        ms.insertm(dto);
        return "redirect:/main";
    }


}
