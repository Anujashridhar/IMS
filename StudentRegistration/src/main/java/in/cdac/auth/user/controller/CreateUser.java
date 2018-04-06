package in.cdac.auth.user.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import in.cdac.auth.role.service.RoleService;
import in.cdac.auth.user.service.UserService;
import in.cdac.db.auth.entity.User;
import in.cdac.ims.util.entity.ResultDataMap;
import in.cdac.ims.util.entity.Strings;
import in.cdac.util.Utility;

@Controller
@RequestMapping("auth/")
public class CreateUser {

	@Autowired
	RoleService roleService;
	@Autowired
	UserService userService;

	//ModelAndView mav = new ModelAndView();

	@GetMapping("createUser")
	public ModelAndView createUser(@RequestParam(name = "userId", required = false, defaultValue = "0") Integer userId,
			@RequestParam(name = "status", required = false) Boolean status,
			@RequestParam(name = "message", required = false, defaultValue = "0") String message,ModelAndView mav) {

		User user = new User();
		if (userId != 0) {
			user = userService.getUserById(userId);
		}
		User loggedInuser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(loggedInuser.getUserType().equals(Integer.parseInt(Strings.SuperAdminUserId)))
				{
					mav.addObject("roles", (LinkedHashMap<Integer, String>) roleService.getAllRoles().getDataObject());
			
				}else if(loggedInuser.getUserType().equals(Integer.parseInt(Strings.HRAdminUserId)))
				{
					mav.addObject("roles", (LinkedHashMap<Integer, String>) roleService.getFilterdRoles().getDataObject());
				}
		
		mav.addObject("user", user);
		mav.setViewName("userroles/CreateUser");
		return mav;
	}

	@PostMapping("saveUser")
	public ModelAndView saveUser(@ModelAttribute("user")@Valid  User user, BindingResult bindingResult,ModelAndView mav,
			HttpServletRequest request) {
		
		String contextPath=new Utility().getBaseUrl(request);
		
		Integer id = 0;
		User loggedInuser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		//validate
		if (bindingResult.hasErrors()) {
			System.out.println("data error" + bindingResult);
			mav.addObject("user", user);
			mav.addObject("roles", (LinkedHashMap<Integer, String>) roleService.getAllRoles().getDataObject());
			
			// map.addAttribute("message", Strings.error);
			mav.setViewName("userroles/CreateUser");
			return mav;
		}
		// get modifiers Id
		if (loggedInuser != null) {
			id = loggedInuser.getUserId();
		}
		
		//save User
		ResultDataMap rdm = userService.saveUser(user, id, contextPath);
	
		//check saved status
		if (rdm.getStatus()) {
			User savedUser = (User) rdm.getDataObject();
			if (savedUser != null && savedUser.getUserId() != null) {
				
				//redirect to blank create user form with success message
				mav.addObject("user", savedUser);
		
				mav.setViewName(
						"redirect:userRegisterSuccess?userId="+savedUser.getUserId());
				mav.addObject("roles", (LinkedHashMap<Integer, String>) roleService.getAllRoles().getDataObject());
				
				return mav;
			} else {
				
				//send error message
				System.out.println("data error" + bindingResult);
				mav.addObject("user", user);
				mav.addObject("message", rdm.getMessage());
				mav.setViewName("userroles/CreateUser");
				mav.addObject("roles", (LinkedHashMap<Integer, String>) roleService.getAllRoles().getDataObject());
				
				return mav;
			}
		} else {
			//send error message
			System.out.println("data error" + bindingResult);
			mav.addObject("user", user);
			mav.addObject("message", rdm.getMessage());
			mav.setViewName("userroles/CreateUser");
			mav.addObject("roles", (LinkedHashMap<Integer, String>) roleService.getAllRoles().getDataObject());
			
			return mav;
		}
	}
	
	
	@GetMapping("userRegisterSuccess")
	public ModelAndView userSuccessPage(@RequestParam("userId")Integer userId,ModelAndView mav)
	{
		mav.addObject("user",userService.getUserById(userId));
		mav.setViewName("userroles/userRegisterSuccess");
		return mav;
	}

	

	@GetMapping("viewUser")
	public ModelAndView viewUser(@RequestParam(name="userId",required=false,defaultValue="0")Integer userId,ModelAndView mav)
	{
		List<User> userList=new ArrayList();
		if(userId!=0)
		{
			User user=userService.getUserById(userId);
			userList.add(user);
		}
		else {
			userList=userService.getAllUserList();
		}
		mav.addObject("userList",userList);
		mav.setViewName("userroles/ViewUsers");
		return mav;
	}
}
