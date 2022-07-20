package com.sjh.blog.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sjh.blog.model.User;

// 스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행하고 완료가 되면 UserDetails 타입의 오브젝트를 
// 스프링 시큐리티의 고유한 세션저장소에 저장해준다
public class PrincipalDetail implements UserDetails {
	private User user; // 컴포지션

	public PrincipalDetail(User user) {
		this.user= user;
	}
	@Override
	public String getPassword() {
		return user.getPassword();
	}
	@Override
	public String getUsername() {
		return user.getUsername();
	}
	// 계정의 만료여부 리턴
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	// 계정이 잠겨있는지 여부
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	// 비밀번호 만료여부
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	// 계정 활성화여부
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	// 계정 권한 
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			
			Collection<GrantedAuthority>collectors = new ArrayList<>();
			collectors.add(()->{return "ROLE_"+user.getRole();});
			
			return collectors;
		}
	
}
