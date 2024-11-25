package mbc.second.HobbyTaster.controller.Class;


import lombok.extern.slf4j.Slf4j;
import mbc.second.HobbyTaster.dto.Class.ClassDTO;

import mbc.second.HobbyTaster.dto.Review.ReviewDTO;
import mbc.second.HobbyTaster.entity.Class.ClassEntity;
import mbc.second.HobbyTaster.entity.MemberEntity;
import mbc.second.HobbyTaster.entity.review.ReviewEntity;
import mbc.second.HobbyTaster.service.Class.ClassService;
import mbc.second.HobbyTaster.service.Member.MemberService;

import mbc.second.HobbyTaster.service.Review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Slf4j
@Controller
public class ClassContorller {

    @Autowired
    ClassService classService;

    @Autowired
    MemberService memberService;

    @Autowired
    ReviewService reviewService;

    String path = "C:\\mbc6\\spring_boot\\HobbyTaster\\src\\main\\resources\\static\\image";

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
    public String class1(@ModelAttribute("classDTO") ClassDTO classDTO, MultipartHttpServletRequest mul)throws IOException {

        classDTO.mergeAddress();

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

    @GetMapping(value = "/cadmindetail")
    public String class3(Model mo, @RequestParam("cnum") long cnum){
        classService.readcnt(cnum);

        ClassEntity dto= classService.detail(cnum);
        mo.addAttribute("dto",dto);

        return "/class/cadmindetail";
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

    @GetMapping(value = "/detail")
    public String class8(Model mo, @RequestParam("num") long num){
        classService.readcnt(num);

        ClassEntity dto= classService.detail(num);
        mo.addAttribute("dto",dto);

        List<ReviewEntity> reviews = reviewService.getReviewsByClassId(num);
        mo.addAttribute("reviews", reviews);

        // 새로운 리뷰 작성 폼 객체
        mo.addAttribute("review", new ReviewEntity());

        return "/class/detail";
    }

    @PostMapping(value = "/detail/review")
    public String addReview(@RequestParam("num") long num,
                            @ModelAttribute ReviewDTO reviewDTO, MultipartHttpServletRequest mul) throws IOException {
        // 현재 로그인된 사용자 정보 가져오기
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = (UserDetails) principal;
        String id = userDetails.getUsername();
        MemberEntity member = memberService.findbyid(id);

        MultipartFile mf=mul.getFile("image1");
        String fname=mf.getOriginalFilename();
        UUID uu=UUID.randomUUID();
        fname=uu.toString()+"-"+fname;
        mf.transferTo(new File(path+"\\"+fname));
        reviewDTO.setRimage1(fname);
        reviewDTO.setId(id);
        reviewDTO.setNickname(member.getNickname());
        reviewDTO.setRevdate(LocalDate.now());

        ReviewEntity reviewEntity=reviewDTO.reviewEntity();
        reviewService.saveReview(reviewEntity);

        return "redirect:/detail?num=" + num;
    }

}
