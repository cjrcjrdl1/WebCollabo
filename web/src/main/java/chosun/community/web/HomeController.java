package chosun.community.web;

import chosun.community.service.MemberService;
import chosun.community.web.member.dto.MemberResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final MemberService memberService;

    @GetMapping("/")
    public String home(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) MemberResponseDto loginMember,
                       Model model) {
        if (loginMember == null) {
            return "index";
        }

        model.addAttribute("member", loginMember);
        return "index";
    }


}
