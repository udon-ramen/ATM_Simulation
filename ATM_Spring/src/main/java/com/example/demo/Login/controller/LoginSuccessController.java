package com.example.demo.Login.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Login.service.AccountUserDetails;

@Controller
public class LoginSuccessController {
	
	private ModelAndView mod = new ModelAndView();
	private String username;
	
	public LoginSuccessController(){
		this.username = null;
	}
	
	@GetMapping("/menu")
    public ModelAndView menu(@AuthenticationPrincipal AccountUserDetails user) {
		
		System.out.println(user.getUsername());
		this.username = user.getUsername();
		
		if (!username.equals(null)) {
			mod.setViewName("menu");
			mod.addObject("username", "こんにちわ、" + this.username + "さん！");
	        return mod;
		} else {
			mod.setViewName("menu");
			mod.addObject("username", "名前が分かりません。");
	        return mod;
		}
    }
}
