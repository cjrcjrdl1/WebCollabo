package chosun.community.web.member;

import chosun.community.service.MemberService;
import chosun.community.web.member.dto.MemberRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/register")
    public String memberRegister(@ModelAttribute("member") MemberRequestDto member) {
        return "members/registerForm";
    }

    @PostMapping("/register")
    public String save(@Validated @ModelAttribute("member") MemberRequestDto member, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "members/registerForm";
        }

        memberService.save(member);
        return "redirect:/";
    }
}
