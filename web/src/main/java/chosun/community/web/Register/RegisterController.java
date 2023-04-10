package chosun.community.web.Register;

import chosun.community.service.MemberService;
import chosun.community.web.Register.dto.RegisterRequestDto;
import chosun.community.web.member.dto.MemberRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;


@RequiredArgsConstructor
@Controller
public class RegisterController {

    private final MemberService memberService;

    @GetMapping("/register")
    public String registerForm(@ModelAttribute("member") MemberRequestDto member) {



//        model.addAttribute("Member_id", new joined_member());
//        Map<String, joined_member> map = new HashMap<>();


        return "register/registerMemberForm";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("member") MemberRequestDto member) {

        memberService.save(member);
        return "redirect:/";
    }
}
