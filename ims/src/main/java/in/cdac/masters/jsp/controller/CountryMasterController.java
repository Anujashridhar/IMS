package in.cdac.masters.jsp.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.cdac.db.auth.entity.User;
import in.cdac.db.masters.entity.MstCountry;
import in.cdac.ims.masters.service.CountryMasterService;
import in.cdac.ims.util.entity.ResultDataMap;



@Controller
@RequestMapping("site/admin/")
public class CountryMasterController {

	@Autowired
	CountryMasterService countryMasterService;
	
	@RequestMapping("/countryList")
	public ModelAndView stateList(HttpServletRequest request,
			HttpServletResponse response, Object command,ModelMap model)
	{
		ModelAndView mav=new ModelAndView();

		try 
		{
			MstCountry country = new MstCountry();
			HashMap<Integer, String> countryList=new HashMap<Integer, String>();
			countryList = countryMasterService.getCountryList();
			mav.addObject("countryList",countryList);
			mav.setViewName("MstCountryList");
			mav.addObject("country", country);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return mav;
	}
	
	
	
	
	@RequestMapping(value="/ChooseCountry",method=RequestMethod.GET)
	public String ChooseTemplateForm(HttpServletRequest request)
	{
		System.out.println("ChooseCountry..........");
		return "MstNewCountry";
			
	}
	
	
	@RequestMapping(value="/saveNewCountry",method=RequestMethod.POST )
	public ModelAndView saveSelectedTemplate(@RequestParam(value="countryName",required=false) String countryName,
											 @RequestParam(value="countryCode",required=false) Integer countryCode,
											ModelMap map,ModelAndView mav,
											RedirectAttributes redirectAttributes,HttpServletRequest request)
	{
		
		String url;
		HttpSession session=request.getSession();
		System.out.println("in controller" + countryName);
		ResultDataMap rdm =new ResultDataMap();
		MstCountry mc= new MstCountry();
		mc.setCountryName(countryName);
		mc.setCountryCode(countryCode);
		User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Integer userId=user.getUserId();
		mc.setEnteredBy(userId);
		mc.setModifiedBy(userId);
		System.out.println(mc.getCountryCode());
		rdm=countryMasterService.saveNewCountry(mc);
		System.out.println("New Country added successfully");
		map.addAttribute("resultDataMap",rdm);
		mav.setViewName("redirect:/dashboard");
		return mav;
	
	}
	
}
