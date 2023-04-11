package chosun.community.web.shop;

import chosun.community.web.member.dto.MemberRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShopController {

    @GetMapping("/shop")
    public String shopForm(@ModelAttribute("member") MemberRequestDto member) {
        return "shop/index";
    }

}
