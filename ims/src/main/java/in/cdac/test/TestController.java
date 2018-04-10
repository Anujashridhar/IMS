package in.cdac.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@GetMapping("helloWorld")
	public ModelAndView HelloWorld(ModelAndView mav) throws Exception
	{
		throw new Exception();
		//mav.setViewName("faltu");
		//return mav;
	}
}
