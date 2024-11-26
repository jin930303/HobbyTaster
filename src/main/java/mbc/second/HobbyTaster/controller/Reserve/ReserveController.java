package mbc.second.HobbyTaster.controller.Reserve;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReserveController {

    @GetMapping(value = "/reserve_out")
    public String reserve() {

        return "reserve_out";
    }
}
