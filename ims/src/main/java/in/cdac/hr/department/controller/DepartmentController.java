package in.cdac.hr.department.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hr")
public class DepartmentController {

	@GetMapping("departmentForm")
	public ModelAndView getDepartmentForm(ModelAndView mav)
	{
		mav.setViewName("MstNewDept");
		return mav;
	}
	
}
