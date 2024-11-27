package mbc.second.HobbyTaster.Controller.Member;

import lombok.extern.slf4j.Slf4j;
import mbc.second.HobbyTaster.DTO.Member.KakaoInfoDTO;
import mbc.second.HobbyTaster.DTO.Member.MemberDTO;
import mbc.second.HobbyTaster.Entity.Class.ClassEntity;
import mbc.second.HobbyTaster.Entity.Member.MemberEntity;
import mbc.second.HobbyTaster.Repository.Member.MemberRepository;
import mbc.second.HobbyTaster.Service.Class.ClassService;
import mbc.second.HobbyTaster.Service.Member.KakaoLoginService;
import mbc.second.HobbyTaster.Service.Member.MemberInterface;
import mbc.second.HobbyTaster.Service.Member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@Slf4j
@Controller
public class MemberController {

    @Autowired
    MemberService ms;

    @Autowired
    ClassService cs;

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
    @GetMapping(value = "/my/myinfo")
    public String myinfo(@RequestParam("id") String id, Model mo) {
        List<MemberInterface> list=ms.infoout(id);
        mo.addAttribute("list",list);
        return "member/myinfo";
    }

    @GetMapping(value = "/my/myinfoupdateview")
    public String myinfoupdate(@RequestParam("id") String id, Model mo) {
        List<MemberInterface> list=ms.infoout(id);
        mo.addAttribute("list",list);
        return "member/myinfoupdateview";
    }

    @GetMapping(value = "/my/myinfodelete")
    public String myinfodelete(@RequestParam("id") String id) {
        ms.deleteinfo(id);
        return "redirect:/logout";
    }

    @PostMapping(value = "/my/myinfoupdate")
    public String myinfoupdate(@RequestParam("postnum") String postnum, @RequestParam("address") String address,
                               @RequestParam("detailaddress") String detailaddress, MemberDTO dto) {
        if(postnum==null || detailaddress==null) {
            dto.setAddress(address);
        }
        else {
            dto.setAddress(postnum+" "+address+" "+detailaddress);
        }
        String id=dto.getId();
        String email=dto.getEmail();
        String gender=dto.getGender();
        String name=dto.getName();
        String nickname=dto.getNickname();
        String phone=dto.getPhone();
        int auth=dto.getAuth();
        String state=dto.getState();
        ms.updateinfo(id, email, gender, name, nickname, phone, auth, state, address);
        return "redirect:/my/myinfo?id="+id;
    }

    @GetMapping(value = "/admin/memberauth")
    public String memberauth(Model mo) {
        List<MemberEntity> list=ms.allmember();
        mo.addAttribute("list", list);
        return "member/memberauth";
    }

    @GetMapping(value = "/admin/memberdelete")
    public String memberdelete(@RequestParam("id") String id) {
        ms.deleteinfo(id);
        return "redirect:/admin/memberauth";
    }

    @GetMapping(value = "/admin/memberok")
    public String memberok(@RequestParam("id") String id) {
        String state="승인";
        ms.updatestate(id, state);
        return "redirect:/admin/memberauth";
    }

    @GetMapping(value = "/admin/memberno")
    public String memberno(@RequestParam("id") String id) {
        String state="보류";
        ms.updatestate(id, state);
        return "redirect:/admin/memberauth";
    }

    @GetMapping(value = "/admin/classdelete")
    public String classdelete(@RequestParam("cnum") long cnum) {
        cs.cdelete(cnum);
        return "redirect:/admin/classauth";
    }

    @GetMapping(value = "/findidview")
    public String findidview() {
        return "member/findid";
    }

    @PostMapping(value = "/findidemail")
    public String findidemail(@RequestParam("email") String email, @RequestParam("domain") String domain, Model mo) {
        String fullemail=email+domain;
        int count=ms.emailcheck(fullemail);
        if(count>0) {
            String findid=ms.findidemail(fullemail);
            mo.addAttribute("findid", findid);
            return "member/findidresult";
        }
        else {
            return "redirect:/findidview";
        }
    }

    @PostMapping(value = "/findidphone")
    public String findidphone(@RequestParam("phonemid") String phonemid, @RequestParam("phoneend") String phoneend, Model mo) {
        String fullphone="010-"+phonemid+"-"+phoneend;
        int count=ms.phonecheck(fullphone);
        if(count>0) {
            String findid=ms.findidphone(fullphone);
            mo.addAttribute("findid", findid);
            return "member/findidresult";
        }
        else {
            return "redirect:/findidview";
        }
    }

    @GetMapping(value = "/findpwview")
    public String findpwview() {
        return "member/findpw";
    }

    @PostMapping(value = "/findpw")
    public String findpw(Model mo, @RequestParam("id") String id,
                         @RequestParam("phonemid") String phonemid, @RequestParam("phoneend") String phoneend,
                         @RequestParam("email") String email, @RequestParam("domain") String domain) {
        String fullphone="010-"+phonemid+"-"+phoneend;
        String fullemail=email+domain;
        int count=ms.pwcheck(id,fullemail,fullphone);
        if(count>0) {
            mo.addAttribute("id", id);
            return "member/pwupdateview";
        }
        else {
            return "redirect:/findpwview";
        }
    }

    @PostMapping(value = "/updatepw")
    public String updatepw(@RequestParam("id") String id, @RequestParam("pw") String pw) {
        ms.pwupdate(id, pw);
        return "redirect:/login";
    }
}
