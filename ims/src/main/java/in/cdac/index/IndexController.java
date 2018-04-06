package in.cdac.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	ModelAndView mav=new ModelAndView();
	@GetMapping("/")
	public ModelAndView index()
	{
		mav.setViewName("index");
		return mav;
	}
}