package chosun.community.web.shop;

import chosun.community.web.member.dto.MemberRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ShopController {

    @GetMapping("/shop")
    public String shopForm(@ModelAttribute("member") MemberRequestDto member, Model model) {
        return "shop/index";
    }

}
