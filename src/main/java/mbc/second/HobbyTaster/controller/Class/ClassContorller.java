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
import org.springframework.web.bind.annotation.RequestParam;
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

        String fname1= mf1.getOriginalFilename();
        String fname2= mf2.getOriginalFilename();

        UUID uu=UUID.randomUUID();
        fname1=uu.toString()+"-"+fname1;
        fname2=uu.toString()+"-"+fname2;

        mf1.transferTo(new File(path+"\\"+fname1));
        mf2.transferTo(new File(path+"\\"+fname2));

        classDTO.setCmimage1(fname1);
        classDTO.setCdimage1(fname2);
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

    @GetMapping(value = "/detail")
    public String class3(Model mo, @RequestParam("cnum") long cnum){
       ClassEntity dto= classService.detail(cnum);
        mo.addAttribute("dto",dto);

        return "/class/cdetail";
    }

    @GetMapping(value = "/cstart")
    public String class4(Model mo, @RequestParam("cnum") long cnum){
       classService.start(cnum);

        return "redirect:/cout";
    }

    @GetMapping(value = "/creturn")
    public String class5(Model mo, @RequestParam("cnum") long cnum){
        classService.creturn(cnum);

        return "redirect:/cout";
    }

    @GetMapping(value = "/cfinish")
    public String class6(Model mo, @RequestParam("cnum") long cnum){
        classService.cfinish(cnum);

        return "redirect:/cout";
    }

    @GetMapping(value = "/cdelete")
    public String class7(Model mo, @RequestParam("cnum") long cnum,@RequestParam("cdimage") String cdimage,@RequestParam("cmimage")String cmimage){

        classService.cdelete(cnum);
        File f1= new File(path+"\\"+cdimage);
        File f2= new File(path+"\\"+cmimage);
        f1.delete();
        f2.delete();

        return "redirect:/cout";
    }


}
