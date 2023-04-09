package chosun.community.web.Register;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;


@Controller()

public class Registercontroller {
    @GetMapping("/Register")
    public String Register(Model model){
        model.addAttribute("Member_id", new joined_member());
        Map<String,joined_member> map = new HashMap<>();

        return "Register/Register_Member";
    }
}
