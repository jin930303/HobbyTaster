package mbc.second.HobbyTaster.controller.Class;

import mbc.second.HobbyTaster.dto.Class.ClassDTO;
import mbc.second.HobbyTaster.entity.Class.ClassEntity;
import mbc.second.HobbyTaster.service.Class.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ClassContorller {

    @Autowired
    ClassService classService;

    @GetMapping(value = "cinput")
    public String class0(){

       return "/class/cinput";
   }

    @PostMapping(value = "csave")
    public String class1(@ModelAttribute("classDTO") ClassDTO classDTO){
        ClassEntity centity=classDTO.centity();
        classService.cinsert(centity);

        return "redirect:/main";
    }
}
