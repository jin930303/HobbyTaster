package mbc.second.HobbyTaster.controller;

import mbc.second.HobbyTaster.entity.Class.ClassEntity;
import mbc.second.HobbyTaster.service.Class.ClassInterface;
import mbc.second.HobbyTaster.service.Class.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    ClassService classService;

    @GetMapping(value = "/")
    public String home(Model mo){
        List<ClassInterface> doye = classService.categoryclass("공예","도예");
        mo.addAttribute("doye",doye);

        List<ClassInterface> doll = classService.categoryclass("공예","인형");
        mo.addAttribute("doll",doll);

        List<ClassInterface> jewell = classService.categoryclass("공예","쥬얼리");
        mo.addAttribute("jewell",jewell);

        List<ClassInterface> drawing = classService.categoryclass("예술","드로잉");
        mo.addAttribute("drawing",drawing);

        List<ClassInterface> picture = classService.categoryclass("예술","사진");
        mo.addAttribute("picture",picture);

        List<ClassInterface> music = classService.categoryclass("예술","음악");
        mo.addAttribute("music",music);

        List<ClassInterface> cookie = classService.categoryclass("베이킹","쿠키");
        mo.addAttribute("cookie",cookie);

        List<ClassInterface> cake = classService.categoryclass("베이킹","케이크");
        mo.addAttribute("cake",cake);

        List<ClassInterface> bread = classService.categoryclass("베이킹","빵");
        mo.addAttribute("bread",bread);

        List<ClassInterface> wine = classService.categoryclass("주류","와인");
        mo.addAttribute("wine",wine);

        List<ClassInterface> beer = classService.categoryclass("주류","맥주");
        mo.addAttribute("beer",beer);

        List<ClassInterface> tradition = classService.categoryclass("주류","전통주");
        mo.addAttribute("tradition",tradition);
        return "main";
    }

    @GetMapping(value = "/main")
    public String main(Model mo){
        return "main";
    }
}
