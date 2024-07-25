package com.example.demo.MemberRegist.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberRegistrationController {
	
	@PostMapping("/MemberRegistration")
    String MemberRegistration() {
        return "memberRegistration";
    }

}
