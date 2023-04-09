package chosun.community.web.login;

import chosun.community.domain.member.Member;
import chosun.community.service.LoginService;
import chosun.community.web.SessionConst;
import chosun.community.web.login.dto.LoginDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@RequiredArgsConstructor
@Controller
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("login") LoginDto loginDto) {return "login/loginForm";}

    @PostMapping("/login")
    public String login(@Validated @ModelAttribute("login") LoginDto login, BindingResult bindingResult,
                        @RequestParam(defaultValue = "/") String redirectURL, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "login/loginForm";
        }

        Member loginMember = loginService.login(login.getLoginId(), login.getPassword());

        log.info("login {}", loginMember);

        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 혹은 비밀번호가 다릅니다.");
            return "login/loginForm";
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

        return "redirect:" + redirectURL;
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false); //세션 없으면 null 반환
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}
