package mbc.second.HobbyTaster.controller.Class;

import lombok.extern.slf4j.Slf4j;
import mbc.second.HobbyTaster.dto.Class.ClassDTO;
import mbc.second.HobbyTaster.entity.Class.ClassEntity;
import mbc.second.HobbyTaster.entity.MemberEntity;
import mbc.second.HobbyTaster.service.Class.ClassService;
import mbc.second.HobbyTaster.service.Member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Slf4j
@Controller
public class ClassContorller {

    @Autowired
    ClassService classService;

    @Autowired
    MemberService memberService;

    @GetMapping(value = "cinput")
    public String class0(Model mo){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = (UserDetails)principal;
        String id = ((UserDetails) principal).getUsername();
        MemberEntity dto=memberService.findbyid(id);
        log.info("확인 : "+dto);
        mo.addAttribute("dto",dto);

       return "/class/cinput";
   }

    @PostMapping(value = "csave")
    public String class1(@ModelAttribute("classDTO") ClassDTO classDTO){
        ClassEntity centity=classDTO.centity();
        classService.cinsert(centity);

        return "redirect:/main";
    }
}
