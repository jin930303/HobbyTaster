package mbc.second.HobbyTaster.Controller.Reserve;

import lombok.extern.slf4j.Slf4j;
import mbc.second.HobbyTaster.Entity.Reserve.ReserveEntity;
import mbc.second.HobbyTaster.Service.Class.ClassInterface;
import mbc.second.HobbyTaster.Service.Reserve.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
public class ReserveController {

    @Autowired
    ReserveService service;

    @PostMapping("/reserve_plus")
    public String reserve(@RequestParam(name="cnum", required = false, defaultValue = "0") long cnum,
                          @RequestParam(name="cteach", required = false, defaultValue = "0") String reserveTeach,
                          Model mo) {
        // 로그인 중 아이디 찾기
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        service.reserve_save(cnum, userId, reserveTeach);

        return  "redirect:/";
    }

    @GetMapping(value = "/my/reserve_out")
    public String reserve1(Model mo) {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        List<ReserveEntity> list = service.reserve_out(userId);
        mo.addAttribute("reserve",list);
        return "reserve/reserve_out";
    }

    @GetMapping(value = "/teacher/teacher_class")
    public String reserve2(Model mo) {
        // 아이디 찾기
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        // 닉네임 찾기
        String nickname = service.findNickname(userId);
        // 데이터 찾기
        List<ClassInterface> data = service.class_out(nickname);
        mo.addAttribute("data", data);
        // 모집인원 리미트 걸기

        log.info("list Data check : " + data);
        log.info("USER ID check : " + userId);
        log.info("USER Nickname: " + nickname);
        return "reserve/class_out";
    }
}
