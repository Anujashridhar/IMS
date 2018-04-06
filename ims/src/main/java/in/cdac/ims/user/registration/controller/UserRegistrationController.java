package in.cdac.ims.user.registration.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.cdac.ims.user.registration.service.UserRegistrationService;
import in.cdac.db.auth.entity.User;
import in.cdac.ims.util.entity.ResultDataMap;
import in.cdac.ims.util.entity.Strings;
import in.cdac.util.Utility;

@Controller
public class UserRegistrationController {
	@Autowired
	ResultDataMap resultDataMap;
	@Autowired
	UserRegistrationService userRegistrationService;

	
	@RequestMapping(value="UserRegistration")
	public ModelAndView StudentDetailForm(@RequestParam(value="redirectedAck",defaultValue="false",required=false)String redirectedAck, 
										@RequestParam(value="status",required=false)String status,	
										@RequestParam(value="message",required=false)String message,	
										RedirectAttributes redirectAttributes,
											ModelAndView mav,
											Model map,
											HttpServletRequest request) 

		{
		
		if(map.asMap().get("redirectedAck")!=null && map.asMap().get("redirectedAck").equals("true"))
		{
			
			mav.setViewName("userroles/RegistrationAck");
			return mav;
		}
		User user=new User();
		user.setUserType(2);
		//StudentRegistrationdetails studentRegistrationdetails = new StudentRegistrationdetails();
		
		mav.addObject("userObject", user);
		mav.setViewName("userroles/UserRegister");
				return mav;
		};
		
		/*@ExceptionHandler
		@ResponseStatus(value=HttpStatus.BAD_REQUEST)
		public void handle(Exception e) {
		    System.out.println("Returning HTTP 400 Bad Request"+ e);
		}*/
		@RequestMapping(value="UserRegistration",method=RequestMethod.POST )
		public ModelAndView saveUserRegistration(@Valid @ModelAttribute("userObject")
		User user,BindingResult bindingResult,ModelMap map,ModelAndView mav,
		RedirectAttributes redirectAttributes,HttpServletRequest request)
		{
			if(bindingResult.hasErrors())
			{
				System.out.println(bindingResult);
				mav.addObject("userObject",user);
				
				mav.setViewName("userroles/UserRegister");
				return mav;
			}
			
			System.out.println("User register details" + user.toString());
			
				
			String contextPath=new Utility().getBaseUrl(request);
			
			ResultDataMap rdm = userRegistrationService.registrationsave(user, null, contextPath);
			if(rdm.getStatus())
			{
				/*//mav.addObject("student", rdm.getDataObject());
				
				//mav.addObject("resultDataMap",rdm);
				redirectAttributes.addAttribute("message",(String)rdm.getMessage());
				redirectAttributes.addAttribute("status",rdm.getStatus().toString());
				redirectAttributes.addAttribute("Email",(String)((User)rdm.getDataObject()).getUserEmail());
				redirectAttributes.addAttribute("phone",(String)((User)rdm.getDataObject()).getUserContactNo());
				redirectAttributes.addAttribute("name",(String)((User)rdm.getDataObject()).getUserContactNo());*/
				
				redirectAttributes.addFlashAttribute("redirectedAck","true");
				
				redirectAttributes.addFlashAttribute("message",(String)rdm.getMessage());
				redirectAttributes.addFlashAttribute("status",rdm.getStatus());
				mav.setViewName("redirect:UserRegister");
			}else {
				mav.addObject("message",(String)rdm.getMessage());
				mav.addObject("status",rdm.getStatus().toString());
				mav.setViewName("userroles/UserRegister");
			}
			
			return mav;
		}
		
		@RequestMapping(value="UserRegistrationAck",method=RequestMethod.GET )
		public ModelAndView studentRegistrationAck(@RequestParam(value="message",required=false)String message,
													@RequestParam(value="status",required=false)String status,
													@RequestParam(value="Email",required=false)String Email,
													@RequestParam(value="phone",required=false)String phone,
													@RequestParam(value="name",required=false)String name,
													ModelAndView mav,
													HttpServletRequest request)
		{
			mav.addObject("message",Strings.savedSuccessfully);
		/*	mav.addObject("status",status);
			mav.addObject("Email",Email);
			mav.addObject("phone",phone);
			mav.addObject("name",name);*/
			
			mav.setViewName("userroles/RegistrationAck");
			return mav;
		}
		
		@GetMapping(value="verify_user")
		public ModelAndView verify_user(@RequestParam("tocken_no") String tocken,ModelAndView mav,RedirectAttributes redirectAttributes,
													HttpServletRequest request)
		{
			System.out.println(tocken);
			ResultDataMap rdm=userRegistrationService.verifyEmailAddress(tocken);
			if(rdm.getStatus())
			{
				redirectAttributes.addFlashAttribute("successMessage",Strings.EmailVerifiedSuccess);
				mav.addObject("message", rdm.getMessage());
				mav.setViewName("redirect:loginForm");
			}else {
				mav.addObject("status", rdm.getStatus());
				mav.addObject("message", rdm.getMessage());
				mav.setViewName("userroles/RegistrationAck");
			}
			return mav;
		}
		@GetMapping(value="email_form")
		public ModelAndView emailForm(ModelAndView mav,
										HttpServletRequest request)
		{
			mav.setViewName("userroles/getEmail");
			return mav;
		}

		
		@PostMapping(value="get_verification_link")
		public ModelAndView getVerificationLink(@RequestParam("emailId") String emailId,ModelAndView mav,
													HttpServletRequest request)
		{
			System.out.println(emailId);
			String contextPath=new Utility().getBaseUrl(request);
			ResultDataMap rdm=userRegistrationService.getVerificationLink(emailId,contextPath);
			if(rdm.getStatus())
			{
				mav.addObject("message", rdm.getMessage());
				mav.setViewName("redirect:dashboard");
			}else {
				mav.addObject("status", rdm.getStatus());
				mav.addObject("message", rdm.getMessage());
				mav.setViewName("userroles/RegistrationAck");
			}
			return mav;
		}
}
