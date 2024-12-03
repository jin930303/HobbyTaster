package mbc.second.HobbyTaster.Controller.Reserve;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReserveController {

    @GetMapping(value = "/reserve_out")
    public String reserve() {

        return "reserve_out";
    }
}
