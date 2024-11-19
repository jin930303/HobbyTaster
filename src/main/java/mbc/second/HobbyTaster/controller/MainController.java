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
        List<ClassInterface> doye = classService.doye_out();
        mo.addAttribute("doye",doye);

        List<ClassInterface> doll = classService.doll_out();
        mo.addAttribute("doll",doll);

        List<ClassInterface> jewell = classService.jewelle_out();
        mo.addAttribute("jewell",jewell);

        List<ClassInterface> drawing = classService.drawing_out();
        mo.addAttribute("drawing",drawing);

        List<ClassInterface> picture = classService.picture_out();
        mo.addAttribute("picture",picture);

        List<ClassInterface> music = classService.music_out();
        mo.addAttribute("music",music);

        List<ClassInterface> cookie = classService.cookie_out();
        mo.addAttribute("cookie",cookie);

        List<ClassInterface> cake = classService.cake_out();
        mo.addAttribute("cake",cake);

        List<ClassInterface> bread = classService.bread_out();
        mo.addAttribute("bread",bread);

        List<ClassInterface> wine = classService.wine_out();
        mo.addAttribute("wine",wine);

        List<ClassInterface> beer = classService.beer_out();
        mo.addAttribute("beer",beer);

        List<ClassInterface> tradition = classService.tradition_out();
        mo.addAttribute("tradition",tradition);
        return "main";
    }

    @GetMapping(value = "/main")
    public String main(Model mo){
        return "main";
    }
}
