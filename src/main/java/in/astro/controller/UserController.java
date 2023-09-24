package in.astro.controller;

import in.astro.model.UserDetails;
import in.astro.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService service;
    @GetMapping("/register")
    public String showRegistrationPage(@ModelAttribute("userInfo") UserDetails userDetails){
        return "user_register";
    }
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("userInfo") UserDetails userDetails, Map<String,Object> model){
        String msg = service.register(userDetails);
        model.put("message",msg);
        return "user_registered_success";
    }
    @RequestMapping("/showLogin")
    public String showLoginPage() {
        return "welcome";
    }
}
