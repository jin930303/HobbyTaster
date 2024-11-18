package mbc.second.HobbyTaster.controller.FAQ;

import mbc.second.HobbyTaster.dto.FAQ.FAQDTO;
import mbc.second.HobbyTaster.entity.FAQ.FAQEntity;
import mbc.second.HobbyTaster.service.FAQ.FAQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FAQController {

    @Autowired
    FAQService faqService;

    @GetMapping(value = "/faqin")
    public String faq1() {return "/faq/faqinput";}

    @PostMapping(value = "/faqinput_save")
    public String faq2(FAQDTO faqdto) {
        FAQEntity faqEntity = faqdto.entity();
        faqService.faqinput_save(faqEntity);
        return "redirect:/";
    }

    @GetMapping(value = "/faqout")
    public String faq3(Model mo) {
        List<FAQEntity> faqEntityList = faqService.faqout();
        mo.addAttribute("faqout", faqEntityList);

        return "/faq/faqoutput";
    }
}
