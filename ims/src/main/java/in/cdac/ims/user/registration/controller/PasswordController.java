package in.cdac.ims.user.registration.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.cdac.auth.user.service.UserService;
import in.cdac.db.auth.entity.Tocken;
import in.cdac.db.auth.entity.User;
import in.cdac.ims.util.entity.ResultDataMap;
import in.cdac.ims.util.entity.Strings;
import in.cdac.util.Utility;

@Controller
public class PasswordController {

	@Autowired
	UserService userService;
	
	@Autowired PasswordEncoder encoder;

	ModelAndView mav = new ModelAndView();

	@GetMapping("forgotPassword")
	public ModelAndView forgetPasswordForm() {
		mav.setViewName("forgotPasswordForm");
		return mav;

	}

	@PostMapping("forgotPassword")
	public ModelAndView forgetPasswordSubmit(@RequestParam("email") String email, HttpServletRequest request) {
		if (email != null && email.trim() != "") 
		{
			mav.addObject("email", new String());
			System.out.println(email);
			User user = userService.getUserByIdOrEmailOrMobile(email);
			if (user != null && user.getUserId() != null) {
				ResultDataMap rdm = userService.generatePasswordResetLink(user,new Utility().getBaseUrl(request));
				mav.addObject("status", rdm.getStatus());
				mav.addObject("message", rdm.getMessage());
			} else {
				mav.addObject("status", false);
				mav.addObject("message", Strings.EmailNotRegistered);
			}

			mav.setViewName("CustomAck");
		} else {
			mav.addObject("message", Strings.invalidEmail);
			return mav;
		}
		return mav;

	}
	
	@GetMapping("resetPassword")
	public ModelAndView resetPasswordForm(@RequestParam("tocken_no") String tockenNo, HttpServletRequest request) {
		Tocken tocken=userService.ifValidTocken(tockenNo, Strings.PasswordResetTocken);
		if(tocken!=null)
		{
			mav.addObject("tocken_no",tockenNo);
			mav.addObject("message","");
			mav.setViewName("resetPassword");
		}else {
			mav.addObject("status",false);
			mav.addObject("message",Strings.InvalidTocken);
			mav.setViewName("CustomAck");
		}
			
		
		return mav;
	
	}
	
	
	@PostMapping("resetPasswordSave")
	public ModelAndView resetPasswordSave(@RequestParam("password1") String password1,
										@RequestParam("password2") String password2,
										@RequestParam("tocken_no") String tockenNo,
										HttpServletRequest request) {
		System.out.println(tockenNo);
		if (password1 != null && password1.trim() != "" && password2 != null && password2.trim() != "" && password1.equals(password2)) 
		{
			System.out.println(password1);
			ResultDataMap rdm=userService.resetPassword(tockenNo,password1);
			mav.addObject("status",rdm.getStatus());
			mav.addObject("message",rdm.getMessage());
			mav.setViewName("CustomAck");
		} else {
			mav.addObject("message", Strings.badPassword );
			return mav;
		}
		return mav;

	}
	
	@GetMapping("dashboard/ChangePassword")
	public ModelAndView changePasswordForm(ModelAndView mav)
	{
		User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.setViewName("ChangePassword");
		return mav;
	}
	
	@PostMapping("dashboard/ChangePassword")
	public ModelAndView changePasswordSave(@RequestParam("password1") String password1,
											@RequestParam("password2") String password2,
											@RequestParam("oldPassword") String oldPassword,
											HttpServletRequest request,
											ModelAndView mav)
	{
		User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(encoder.matches(oldPassword, user.getPassword()))
		{
			if (password1 != null && password1.trim() != "" && password2 != null && password2.trim() != "" && password1.equals(password2)) 
			{
			
				ResultDataMap rdm=userService.changePassword(password2,user.getUserId());
				if(rdm.getStatus())
				{
					mav.addObject("message",Strings.passwordChanged);
					mav.setViewName("forward:/logout");
				}else {
					rdm.setStatus(false);
					rdm.setMessage(Strings.error);
				}
				mav.addObject("status",rdm.getStatus());
				mav.addObject("message",rdm.getMessage());
				mav.setViewName("CustomAck");
			} else {
				mav.addObject("message", Strings.badPassword );
				mav.setViewName("ChangePassword");
				return mav;
			}
			
			
		}else {
			mav.addObject("message", Strings.IncorrectOldPassword );
			mav.setViewName("ChangePassword");
		}
		return mav;
	}
	
}
