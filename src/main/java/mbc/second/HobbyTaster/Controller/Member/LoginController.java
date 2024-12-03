package mbc.second.HobbyTaster.Controller.Member;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @Value("${kakao.client_id}")
    private String kakao_client_id;
    @Value("${kakao.redirect_uri}")
    private String kakao_redirect_uri;

    @Value("${naver.client.id}")
    private String naver_client_id;
    @Value("${naver.client.secret}")
    private String naver_client_secret;
    @Value("${naver.redirect.url}")
    private String naver_redirect_uri;

    @GetMapping(value = "/login")
    public String login(Model mo) {
        String kakaolocation = "https://kauth.kakao.com/oauth/authorize?response_type=code&client_id="+
                kakao_client_id+
                "&redirect_uri="+
                kakao_redirect_uri;
        String naverlocation="https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=" +
                naver_client_id +
                "&state=STATE_STRING&redirect_uri=" +
                naver_redirect_uri;
        mo.addAttribute("kakaolocation", kakaolocation);
        mo.addAttribute("naverlocation", naverlocation);
        return "member/login";
    }

}
