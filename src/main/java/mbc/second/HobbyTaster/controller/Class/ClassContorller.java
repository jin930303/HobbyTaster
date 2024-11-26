package mbc.second.HobbyTaster.controller.Class;


import lombok.extern.slf4j.Slf4j;
import mbc.second.HobbyTaster.dto.Class.ClassDTO;

import mbc.second.HobbyTaster.dto.Review.ReviewDTO;
import mbc.second.HobbyTaster.entity.Class.ClassEntity;
import mbc.second.HobbyTaster.entity.MemberEntity;
import mbc.second.HobbyTaster.entity.review.CommentEntity;
import mbc.second.HobbyTaster.entity.review.ReviewEntity;
import mbc.second.HobbyTaster.service.Class.ClassService;
import mbc.second.HobbyTaster.service.Member.MemberService;

import mbc.second.HobbyTaster.service.Review.CommentService;
import mbc.second.HobbyTaster.service.Review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
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

    @Autowired
    CommentService commentService;

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

    @GetMapping(value = "/cupdate")
    public String class9(Model mo, @RequestParam("cnum") long cnum){
       ClassEntity entity= classService.cfind(cnum);
       mo.addAttribute("entity",entity);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = (UserDetails)principal;
        String id = ((UserDetails) principal).getUsername();
        MemberEntity dto=memberService.findbyid(id);

        mo.addAttribute("dto",dto);

        return "/class/cupdate";
    }

    @PostMapping(value = "cupdate1")
    public String class10(@ModelAttribute("classDTO") ClassDTO classDTO, MultipartHttpServletRequest mul)throws IOException {

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
        classService.cupdate(centity);

        return "redirect:/";
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

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = (UserDetails) principal;
        String id = userDetails.getUsername();
        mo.addAttribute("id",id);
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

    @PostMapping("/reviews/{revnum}/comment")
    public String addComment(@PathVariable("revnum") Long revnum,
                             @RequestParam("id") String id,
                             @RequestParam("cnum") long num,
                             @RequestParam("comcontents") String comcontents,
                             Model model) {
        commentService.saveComment(revnum, id, comcontents);

        // 리뷰와 댓글 목록을 다시 모델에 추가하여, 댓글을 작성 후 해당 리뷰 페이지로 리다이렉트
        List<CommentEntity> comments = commentService.getCommentsByReview(revnum);
        model.addAttribute("comments", comments);

        return "redirect:/detail?num=" + num; // 해당 리뷰 페이지로 리다이렉트
    }

    @GetMapping("/reviews/{revnum}/comments")
    public String getComments(@PathVariable("revnum") Long revnum, Model model,@RequestParam("cnum") long num) {
        // 해당 리뷰의 댓글 목록을 가져와서 모델에 추가
        List<CommentEntity> comments = commentService.getCommentsByReview(revnum);
        model.addAttribute("comments", comments);
        log.info("내용물 : "+comments);
        // 리뷰 페이지로 이동
        return "redirect:/detail?num=" + num; // 리뷰 페이지에서 댓글 목록을 보여줌
    }
}
