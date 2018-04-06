package in.cdac.auth.login;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import in.cdac.auth.entity.UserPrincipal;
import in.cdac.auth.login.service.LoginService;
import in.cdac.auth.user.service.UserService;
import in.cdac.db.auth.entity.User;
import in.cdac.db.dashboard.entity.MenuGroup;
import in.cdac.ims.student.Service.StudentAdmissionService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService; 
	
	@Autowired
	UserService userService;
	
	@Autowired
	StudentAdmissionService studentService;
	
	
	@GetMapping("loginForm")
	public ModelAndView loginForm()
	{
		System.out.println("in form controller");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("Login");
		return mav;
	}
	
	@GetMapping("dashboard")
	public ModelAndView loginProcessing(Principal principal)
	{
		System.out.println("principal name ="+principal.getName());
		System.out.println("in dashboardController");
		Object principal2 = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		User user = (User) principal2;
		List<MenuGroup> menus=userService.getMenuGroups(user.getUserId());
		System.out.println(menus);
		ModelAndView mav=new ModelAndView();
		mav.addObject("menus", menus);
		if(!studentService.ifFormSubmitted(user.getUserId()))
				{
			mav.setViewName("redirect:student/studentupdatepage");
				}
		else{
			mav.setViewName("dashboard");
		}
		
		return mav;
	}
	
	@GetMapping("access-denied")
	public ModelAndView accessDenied()
	{
		System.out.println("in post form");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("accessDenied");
		return mav;
	}
}
