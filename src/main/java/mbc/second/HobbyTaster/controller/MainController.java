package mbc.second.HobbyTaster.controller;

import lombok.extern.slf4j.Slf4j;
import mbc.second.HobbyTaster.dto.Class.ClassDTO;
import mbc.second.HobbyTaster.entity.Class.ClassEntity;
import mbc.second.HobbyTaster.service.Class.ClassInterface;
import mbc.second.HobbyTaster.service.Class.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Controller
public class MainController {
    @Autowired
    ClassService classService;

    @GetMapping(value = "/")
    public String main1(Model mo){
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
    public String main2(Model mo){
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

    @PostMapping(value = "/total_search")
    public String main_search(@RequestParam(value = "tot_search", required = false) String totSearch,
                              @RequestParam(value = "tot_day", required = false) LocalDate totDay,
                              @RequestParam(value = "time", required = false) String time,
                              @RequestParam(value = "cat1", required = false) String cat1,
                              @RequestParam(value = "cat2", required = false) String cat2,
                              Model mo) {
        List<ClassEntity> result;

        // 검색어+날짜 다중 조건 검색
        if (totSearch != null && !totSearch.trim().isEmpty() && totDay != null) {
            result = classService.findByCnameOrCteachAndCdate(totSearch.trim(), totDay);
        }
        // 검색어만 입력된 경우
        else if (totSearch != null && !totSearch.trim().isEmpty()) {
            result = classService.findByCnameAndCteach(totSearch.trim());
        }
        // 날짜만 입력된 경우
        else if (totDay != null) {
            result = classService.findByCdate(totDay);
        }
        // 시간만 선택된 경우
        else if (time != null && !time.trim().isEmpty()) {
            result = classService.findByCtime(time);
        }
        // 카테고리 1만 선택된 경우
        else if (cat1 != null && !cat1.trim().isEmpty() && (cat2 == null || cat2.trim().isEmpty())) {
            result = classService.findByCat1(cat1);
        }
        // 카테고리 2가 선택된 경우 ( cat2를 선택하려면 cat1이 선택되어 있어야 함 )
        else if (cat2 != null && !cat2.trim().isEmpty()) {
            result = classService.findByCat2(cat2);
        }
        // 아무 조건도 없을 경우
        else {
            result = List.of(); // 빈 결과
        }

        mo.addAttribute("results", result);
        return "main-search";
    }

    @GetMapping(value = "/category_class")
    public String main_category(@RequestParam("categories") String categories, Model mo) {

        List<ClassEntity> category = classService.category_product(categories);
        mo.addAttribute("category", category);

        return "/class/category";
    }

}
