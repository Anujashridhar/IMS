package in.cdac.ims.student.studentupdate.controler.jsp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.cdac.db.student.entity.StudentRegistrationdetails;
import in.cdac.ims.util.entity.ResultDataMap;

@Controller
public class Studentupdate {
	@Autowired
	ResultDataMap resultDataMap;
	
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
	public ModelAndView StudentForm()
	{
		System.out.println("in form controller");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("student/StudentUpdate");
		return mav;
	}
}


