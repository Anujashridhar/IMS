package in.cdac.ims.student.studentupdate.controler.jsp;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.cdac.auth.user.service.UserService;
import in.cdac.db.auth.entity.User;
import in.cdac.db.dashboard.entity.MenuGroup;
import in.cdac.db.student.entity.StudentPersonalDetails;
import in.cdac.ims.util.entity.ResultDataMap;
import in.cdac.student.entity.StudentWrapper;

@Controller
@RequestMapping("student/")
public class StudentupdateController {
	@Autowired
	ResultDataMap resultDataMap;
	@Autowired
	UserService userService;
	User user;
	
/*	@RequestMapping(value="StudentRegistration",method=RequestMethod.POST )
	public ModelAndView saveContentDetail(@ModelAttribute("studentobjects") StudentRegistrationdetails studentRegistrationdetails,ModelMap map,ModelAndView mav,
											RedirectAttributes redirectAttributes,HttpServletRequest request)
	{
		System.out.println("Stuydent register details" + studentRegistrationdetails.toString());
		ResultDataMap rdm = studentAdmissionService.registrationsave(studentRegistrationdetails);
		map.addAttribute("resultDataMap",rdm);
		mav.setViewName("redirect:/dashboard");
		return mav;
	}*/
	
	@GetMapping("studentupdatepage")
	public ModelAndView StudentForm(@RequestParam( name="activeTab",required=false ,defaultValue="tab1")String activeTab,ModelAndView mav)
	{
		System.out.println("in form controller");
/*		ModelAndView mav=new ModelAndView();*/
		Object principal2 = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal2!=null || !principal2.getClass().equals(User.class))
		{
			user = (User) principal2;
			
			List<MenuGroup> menus=userService.getMenuGroups(user.getUserId());
			mav.addObject("menus",menus);
		}
		
		
		StudentPersonalDetails spd = new StudentPersonalDetails();
		StudentWrapper studentWrapper = new StudentWrapper();
		studentWrapper.setUser(user);
		studentWrapper.setStudentPersonalDetails(spd);
		mav.addObject("activeTab",activeTab);
		mav.setViewName("student/StudentUpdate");
		mav.addObject("studentWrapper",studentWrapper);
	
		return mav;
	}
	
	@PostMapping("savedata")
	public ModelAndView savedata(
	@ModelAttribute("studentWrapper") StudentWrapper studentWrapper,ModelMap modelandview, ModelAndView mav)
	{
		System.out.println("data " + studentWrapper);
		if(true)
		{
			mav.setViewName("redirect:studentupdatepage?activeTab=tab2");
		}
		return mav;
	}
}


