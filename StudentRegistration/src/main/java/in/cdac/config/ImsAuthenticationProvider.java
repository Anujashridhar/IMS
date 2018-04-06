package in.cdac.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import in.cdac.auth.login.service.LoginService;
import in.cdac.db.auth.entity.Authorities;
import in.cdac.db.auth.entity.User;
@Component
public class ImsAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	HttpSession httpSession;
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	LoginService loginService;
	
	//@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		System.out.println("in custom auth provioder");
		Collection<? extends GrantedAuthority> authorities = new ArrayList();
		User user=loginService.getUserByIdOrEmailOrMobile(authentication.getName());
		String password=(String) authentication.getCredentials();
		
		
		if (user == null) {
    		//request.getSession().setAttribute("errormsg", "");
    		//request.getSession().setAttribute("msgPass", "Bad Credentials.");
            throw new UsernameNotFoundException(authentication.getName()+"not found ");
        }else if(passwordEncoder.matches(password, user.getPassword()))
				{
        				if(user.getEmailVerifiedFlag()!=null && user.getEmailVerifiedFlag().equals('Y'))
        				{
        					authorities = loginService.getUserAuthorities(user.getUserId());
                			for (GrantedAuthority grantedAuthority : authorities) {
        						System.out.println(grantedAuthority.getAuthority());
        					}
		                	/*Authorities aut=new Authorities();
		                			aut.setName("EMPLOYEE");
		                			authorities.add(aut);*/
		                		//	request.getSession().setAttribute("userAuthorities", authorities);
		        		}
        				else {
        					throw new LockedException("Email is not verified Yet <br> <a href='email_form'>click here to get new Email Verification Link in you email</a>");
        				}
        			
					}
				else{
					user = null;
		        	//request.getSession().setAttribute("msgPass", "Bad credentials.");
		        	throw new BadCredentialsException("Bad credentials.");
				}
		
		return new UsernamePasswordAuthenticationToken(user, password, authorities);
	}
	
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

	public ImsAuthenticationProvider(){}
	public ImsAuthenticationProvider(HttpServletRequest request) {
		super();
		this.request = request;
	}


}
