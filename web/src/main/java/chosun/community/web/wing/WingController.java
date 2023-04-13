package chosun.community.web.wing;

import chosun.community.domain.member.Member;
import chosun.community.web.member.dto.MemberRequestDto;
import chosun.community.web.member.dto.MemberResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/wing")
@Controller
public class WingController {
    @GetMapping
    public String wingControllerForm(Model model){
        Member member = Member
                .builder()
                .loginId("윤호")
                .name("김윤호")
                .password("123")
                .build();

        model.addAttribute("member", member);
        return "wing/index";
    }

    @GetMapping("/passUpdate")
    public String wingPasswordUpdateForm(/*@ModelAttribute("member")MemberRequestDto memberRequestDto*/ Model model){
        Member member = Member
                .builder()
                .loginId("윤호")
                .name("김윤호")
                .password("123")
                .build();
        model.addAttribute("member", member);
        return "wing/basicinfo/passUpdate";
    }
}
