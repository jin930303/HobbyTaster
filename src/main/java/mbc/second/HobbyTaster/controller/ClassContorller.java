package mbc.second.HobbyTaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ClassContorller {

    @GetMapping(value = "cinput")
    public String class0(){

       return "cinput";
   }

}
