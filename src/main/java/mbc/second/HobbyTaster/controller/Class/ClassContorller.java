package mbc.second.HobbyTaster.controller.Class;

import mbc.second.HobbyTaster.dto.Class.ClassDTO;
import mbc.second.HobbyTaster.entity.Class.ClassEntity;
import mbc.second.HobbyTaster.service.Class.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Controller
public class ClassContorller {

    @Autowired
    ClassService classService;

    String path = "C:\\mbc6\\spring_boot\\HobbyTaster\\src\\main\\resources\\static\\image";

    @GetMapping(value = "cinput")
    public String class0(){

       return "/class/cinput";
   }

    @PostMapping(value = "csave")
    public String class1(@ModelAttribute("classDTO") ClassDTO classDTO, MultipartHttpServletRequest mul)throws IOException {

        MultipartFile mf1= mul.getFile("cmimage");
        MultipartFile mf2= mul.getFile("cdimage");

        String fname1 = mf1 != null ? mf1.getOriginalFilename() : null;
        String fname2 = mf2 != null ? mf2.getOriginalFilename() : null;

        UUID uu=UUID.randomUUID();
        String fname3=uu.toString()+"-"+fname1;
        String fname4=uu.toString()+"-"+fname2;
        mf1.transferTo(new File(path+"\\"+fname3));
        mf2.transferTo(new File(path+"\\"+fname4));

        classDTO.setCmimage(fname1);
        classDTO.setCdimage(fname2);
        ClassEntity centity=classDTO.centity();
        classService.cinsert(centity);

        return "redirect:/";
    }

    @GetMapping(value = "cout")
    public String class2(Model mo){
            List<ClassEntity>list= classService.out();
            mo.addAttribute("list",list);


        return "/class/cout";
    }
}
