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

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/register")
    public String memberRegister(@ModelAttribute("member") MemberRequestDto member) {
        return "register/registerMemberForm";
    }

    @PostMapping("/register")
    public String save(@Validated @ModelAttribute("member") MemberRequestDto member, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register/registerMemberForm";
        }

        memberService.save(member);
        return "redirect:/";
    }
}

