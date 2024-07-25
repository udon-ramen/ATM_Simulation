package com.example.demo.Login.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.Login.entity.MyUser;

public class AccountUserDetails implements UserDetails {
	private final MyUser myUser;

	public AccountUserDetails(MyUser myUser) {
		this.myUser = myUser;
	}

	public MyUser getUser() { // --- Entityである MyUserを返却するメソッド
		return myUser;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { // --- ユーザに与えられている権限リストを返却するメソッド
		return AuthorityUtils.createAuthorityList("ROLE_USER");
	}

	@Override
	public String getPassword() { // --- 登録されているパスワードを返却するメソッド
		return this.myUser.getPassword();
	}

	@Override
	public String getUsername() { // --- ユーザ名を返却するメソッド
		return this.myUser.getName();
	}
	
	public String getID() { // --- ユーザ名を返却するメソッド
		return this.myUser.getId();
	}

	@Override
	public boolean isAccountNonExpired() { // --- アカウントの有効期限の状態を判定するメソッド
		return true;
	}

	@Override
	public boolean isAccountNonLocked() { // --- アカウントのロック状態を判定するメソッド
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() { // --- 資格情報の有効期限の状態を判定するメソッド
		return true;
	}

	@Override
	public boolean isEnabled() { // --- 有効なユーザかを判定するメソッド
		return true;
	}
}
