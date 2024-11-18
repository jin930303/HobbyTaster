package mbc.second.HobbyTaster.controller;

import mbc.second.HobbyTaster.dto.MemberDTO;
import mbc.second.HobbyTaster.entity.MemberEntity;
import mbc.second.HobbyTaster.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
        dto.setPhone("010"+"-"+phonemid+"-"+phoneend);
        dto.setEmail(email+domain);
        dto.setAuth(1);
        MemberEntity me=dto.entity();
        ms.insertm(me);
        return "redirect:/main";
    }


}
