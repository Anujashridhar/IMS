package in.cdac.ims.campus.site.controller.jsp;


import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.cdac.db.campus.entity.SiteRegistrationDetail;
import in.cdac.ims.campus.site.service.SiteRegistrationService;
import in.cdac.ims.util.entity.ResultDataMap;
import in.cdac.ims.util.entity.Strings;


@Controller
@RequestMapping("site/")
public class SiteRegistrationController {
	@Autowired
	SiteRegistrationDetail site ;
	
	@Autowired
	SiteRegistrationService siteRegistraionService;
	
	@RequestMapping("/SiteRegistration")
	public String SiteRegistrationForm(@RequestParam(value="redirectedAck",defaultValue="false",required=false)boolean redirectedAck, 
										@RequestParam(value="status",required=false)String status,	
										@RequestParam(value="message",required=false)String message,	
											ModelMap map,HttpServletRequest request)
	{
		
		System.out.println("site Registration Controller");
	
			if(redirectedAck)
			{	//map.addAttribute("site",site);
				map.addAttribute("status",status);
				map.addAttribute("message",message);
				return "SiteRegistrationForm";
			}
			
			map.addAttribute("site",site);
			
			System.out.println("SiteRegistration");
			return "SiteRegistrationForm";
		
		
	}

	@RequestMapping(value="/saveSiteRegistration",method=RequestMethod.POST )
	public ModelAndView saveSiteRegistrationForm(@Valid @ModelAttribute("site") SiteRegistrationDetail site,BindingResult bindingResult,
											ModelMap map,ModelAndView mav,
											RedirectAttributes redirectAttributes,HttpServletRequest request)
	{
		
		System.out.println("in controller");
		ResultDataMap rdm =new ResultDataMap();
		
				System.out.println("data "+bindingResult);
					if(bindingResult.hasErrors() )
					{
						System.out.println("data error"+bindingResult);
						map.addAttribute("site", site);
						//map.addAttribute("message", Strings.error);
						mav.setViewName("SiteRegistrationForm");
						return mav;
						
					}else if(siteRegistraionService.siteExist(site))
					{
						System.out.println("data error"+bindingResult);
						map.addAttribute("site", site);
						map.addAttribute("message", Strings.SiteExist);
						mav.setViewName("SiteRegistrationForm");
						return mav;
					}else{
						rdm=siteRegistraionService.saveSiteDetails(site);
					
						redirectAttributes.addAttribute("status",rdm.getStatus());
						redirectAttributes.addAttribute("message",rdm.getMessage());
						redirectAttributes.addAttribute("redirectedAck",rdm.getData().get("redirectedAck"));
						mav.addObject("status",rdm.getStatus());
						mav.addObject("message",rdm.getMessage());
						mav.setViewName(rdm.getForwardUrl());
						return mav;
					}		
			
		}
			
}