package com.example.demo.MemberRegist.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.MemberRegist.Entity.RegistEntity;
import com.example.demo.MemberRegist.Repository.RegistDao;

@Controller
public class AfterRegistrationController {
	
	@Autowired
	private RegistDao registDao;
	
	@Autowired
    PasswordEncoder passwordEncoder;
	
	private String username;
	private String userid;
	private String password;
	private String repassword;
	
	public AfterRegistrationController() {
		this.username = null;
		this.userid = null;
		this.password = null;
		this.repassword = null;
	}
	
	@PostMapping("/RegistrationSuccess")
	public ModelAndView MemberRegistrationE(@RequestParam("userName") String userName, 
			 				   @RequestParam("userID") String userID,
			 				   @RequestParam("password") String passWord, 
 							   @RequestParam("Repassword") String Repassword) {
		
		ModelAndView mod = new ModelAndView();
		this.username = userName;
		this.userid = userID;
		this.password = passWord;
		this.repassword = Repassword;
		System.out.println(this.username);
		System.out.println(this.userid);
		System.out.println(this.password);
		System.out.println(this.repassword);
		
		if (RegistStatus(this.username, this.userid, this.password, this.repassword)) {
			
			RegistEntity registEntity = new RegistEntity();
			registEntity.setId(this.userid);
			registEntity.setName(this.username);
			registEntity.setPassword(this.password);
			registEntity.setZandaka("0");			
			registDao.save(registEntity);		// ユーザー登録
			mod.setViewName("index");
			return mod;
		} else {
			mod.setViewName("memberRegistration");
			mod.addObject("message", "正しく入力してください");
			return mod;
		}
		
    }
	
	public boolean RegistStatus(String username, String userid, 
							String password, String Repassword) {
		
		if (username.equals("") | username.equals("null")) return false;
		if (userid.equals("") | userid.equals("null")) return false;
		if (password.equals("") | password.equals("null")) return false;
		if (Repassword.equals("") | repassword.equals("null")) return false;
		if (!password.equals(Repassword)) return false;
		
		return true;
		
	}

}
