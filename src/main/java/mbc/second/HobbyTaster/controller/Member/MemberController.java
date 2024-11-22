package mbc.second.HobbyTaster.controller.Member;

import lombok.extern.slf4j.Slf4j;
import mbc.second.HobbyTaster.dto.Member.KakaoInfoDTO;
import mbc.second.HobbyTaster.dto.Member.MemberDTO;
import mbc.second.HobbyTaster.repository.MemberRepository;
import mbc.second.HobbyTaster.service.Member.KakaoLoginService;
import mbc.second.HobbyTaster.service.Member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@Slf4j
@Controller
public class MemberController {

    @Autowired
    MemberService ms;

    @Autowired
    MemberRepository mr;

    @GetMapping(value = "/member")
    public String member1(){
        return "member/member";
    }

    @GetMapping(value = "/memberinput")
    public String memberinput(){
        return "member/memberinput";
    }

    @GetMapping(value = "/teacherinput")
    public String teacherinput(){
        return "member/teacherinput";
    }

    @GetMapping("/kakaoinput")
    public String kakaoinput(@RequestParam("code") String code, Model mo) throws IOException {
        String accessToken = KakaoLoginService.getAccessTokenFromKakao(code);
        KakaoInfoDTO userInfo = KakaoLoginService.getUserInfo(accessToken);
        String id=userInfo.getKakaoAccount().profile.getNickname()+"@kakao";
        String pw=userInfo.getKakaoAccount().getEmail();
        int count=ms.idcheck(id);
        if(count==0) {
            mo.addAttribute("userInfo",userInfo);
            return "member/kakaoinput";
        }
        else {
            mo.addAttribute("id", id);
            mo.addAttribute("pw", pw);
            return "member/kakaologin";
        }
    }

    @PostMapping(value = "/membersave")
    public String membersave(@RequestParam("phonemid") int phonemid, @RequestParam("phoneend") int phoneend,
                             @RequestParam("email") String email, @RequestParam("domain") String domain,
                             @RequestParam("postnum") String postnum, @RequestParam("address") String address,
                             @RequestParam("detailaddress") String detailaddress, MemberDTO dto) {
        dto.setAddress(postnum+" "+address+" "+detailaddress);
        dto.setEmail(email+domain);
        dto.setPhone("010"+"-"+phonemid+"-"+phoneend);
        dto.setAuth(1);
        dto.setState("승인");
        ms.insertm(dto);
        return "redirect:/main";
    }

    @PostMapping(value = "/kakaosave")
    public String kakaosave(@RequestParam("phonemid") int phonemid, @RequestParam("phoneend") int phoneend,
                            @RequestParam("postnum") String postnum, @RequestParam("address") String address,
                            @RequestParam("detailaddress") String detailaddress, MemberDTO dto) {
        dto.setAddress(postnum+" "+address+" "+detailaddress);
        dto.setPhone("010"+"-"+phonemid+"-"+phoneend);
        dto.setAuth(1);
        dto.setState("승인");
        ms.insertm(dto);
        return "redirect:/main";
    }

    @PostMapping(value = "/teachersave")
    public String teachersave(@RequestParam("phonemid") int phonemid, @RequestParam("phoneend") int phoneend,
                              @RequestParam("email") String email, @RequestParam("domain") String domain,
                              @RequestParam("postnum") String postnum, @RequestParam("address") String address,
                              @RequestParam("detailaddress") String detailaddress, MemberDTO dto) {
        dto.setAddress(postnum+" "+address+" "+detailaddress);
        dto.setEmail(email+domain);
        dto.setPhone("010"+"-"+phonemid+"-"+phoneend);
        dto.setAuth(2);
        dto.setState("대기");
        ms.insertm(dto);
        return "redirect:/main";
    }

    @PostMapping("/idcheck")
    @ResponseBody
    public String idcheck(@RequestParam("id") String id) {
        int count=ms.idcheck(id);
        if(count==0) {
            return "ok";
        }
        else {
            return "no";
        }
    }

    @PostMapping("/nicknamecheck")
    @ResponseBody
    public String nicknamecheck(@RequestParam("nickname") String nickname) {
        int count=ms.nicknamecheck(nickname);
        if(count==0) {
            return "ok";
        }
        else {
            return "no";
        }
    }

    @PostMapping("/phonecheck")
    @ResponseBody
    public String phonecheck(@RequestParam("fullphone") String fullphone) {
        int count=ms.phonecheck(fullphone);
        if(count==0) {
            return "ok";
        }
        else {
            return "no";
        }
    }
}
