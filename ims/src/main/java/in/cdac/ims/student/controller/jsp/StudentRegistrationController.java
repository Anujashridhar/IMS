/*package in.cdac.ims.student.controller.jsp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.cdac.db.student.entity.StudentRegistrationdetails;
import in.cdac.ims.student.Service.StudentAdmissionService;
import in.cdac.ims.util.entity.ResultDataMap;

@Controller
public class StudentRegistrationController {
	@Autowired
	ResultDataMap resultDataMap;
	@Autowired
	StudentAdmissionService studentAdmissionService;

	
	@RequestMapping(value="StudentRegistration")
	public String StudentDetailForm(@RequestParam(value="redirectedAck",defaultValue="false",required=false)boolean redirectedAck, 
										@RequestParam(value="status",required=false)String status,	
										@RequestParam(value="message",required=false)String message,	
											ModelMap map,HttpServletRequest request) 

		{
		StudentRegistrationdetails studentRegistrationdetails = new StudentRegistrationdetails();
		map.put("message", message);
		map.put("studentobjects", studentRegistrationdetails);
				return "student/StudentRegister";
		};
		
		
		@RequestMapping(value="StudentRegistration",method=RequestMethod.POST )
		public ModelAndView saveContentDetail(@ModelAttribute("studentobjects")
		StudentRegistrationdetails studentRegistrationdetails,ModelMap map,ModelAndView mav,
		RedirectAttributes redirectAttributes,HttpServletRequest request)
		{
			System.out.println("Stuydent register details" + studentRegistrationdetails.toString());
			ResultDataMap rdm = studentAdmissionService.registrationsave(studentRegistrationdetails);
			map.addAttribute("resultDataMap",rdm);
			mav.setViewName("redirect:/dashboard");
			return mav;
		}
}
*/