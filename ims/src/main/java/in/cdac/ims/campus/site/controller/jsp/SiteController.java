package in.cdac.ims.campus.site.controller.jsp;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.cdac.ims.campus.entity.Menus;
import in.cdac.ims.campus.entity.Site;
import in.cdac.ims.campus.site.service.SiteService;
import in.cdac.db.auth.entity.User;
import in.cdac.db.campus.entity.MenuDetails;
import in.cdac.db.campus.entity.SiteData;
import in.cdac.db.campus.entity.SubMenuDetails;
import in.cdac.ims.util.entity.ResultDataMap;
import in.cdac.ims.util.entity.Strings;


@Controller
@RequestMapping("site/admin/")
public class SiteController {

@Autowired
SiteService siteService;
	
	@RequestMapping("ChooseTemplate")
	public String ChooseTemplateForm(ModelMap map,
			HttpServletRequest request,
			@RequestParam(value="redirectedAck",defaultValue="false",required=false)boolean redirectedAck, 
			@RequestParam(value="status",required=false)Boolean status,	
			@RequestParam(value="message",required=false)String message)
	{
		System.out.println("ChooseTemplate");
		
		String url="redirect:LoginForm";
		try {
				
				if(redirectedAck)
				{   
					map.addAttribute("status",status);
					map.addAttribute("message",message);
					if(status!=null && status)
					{
						return "Ack";
					}else{
						return "ChooseTemplate";
					}

				}else{
					Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

					User user = (User) principal;
						Integer userType=user.getUserType();
						Integer userId=user.getUserId();
						if(userType!=null && userType.equals(2))
						{
							//Site site=new SiteDao().getSiteByAdminId(userId);
							//SiteData siteData=site.getSiteData();
							//siteData.setSiteId(site.getSiteId());
							//map.addAttribute("siteData",siteData);
							//map.addAttribute("siteRegistrationDetail",site);
							Site site=siteService.getSiteByAdminId(userId);
							map.addAttribute("templateId",site.getSiteData().getTemplateId());
							url="ChooseTemplate";
						}else{
							map.put("message", Strings.notAuthorized);
							
						}
					}
			
			
		} catch (Exception e) {
			map.addAttribute("message", Strings.error);
			e.printStackTrace();
			return "negativeAck";
		}
		return url;
	

}

@RequestMapping(value="saveSelectedTemplate",method=RequestMethod.POST )
public String saveSelectedTemplate(@RequestParam(value="templateId",required=false ) Integer templateId,
		//@RequestParam("siteId") Integer siteId,
		ModelMap map,
		RedirectAttributes redirectAttributes,
		HttpServletRequest request)
{
	
	System.out.println("saveSelectedTemplate");
	if(templateId!=null && templateId>0 )
	{

		ResultDataMap result=new ResultDataMap();
		String url="";
		try {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			User user = (User) principal;
				Integer userType=user.getUserType();
				Integer adminId=user.getUserId();
				adminId=adminId==null?0:adminId;
				if(userType!=null && userType.equals(2))
				{
					Site site=siteService.getSiteByAdminId(adminId);

					SiteData siteData=site.getSiteData();
					siteData=siteData==null?new SiteData():siteData;
					siteData.setSiteId(site.getSiteRegistraionDetail().getSiteId());
					siteData.setTemplateId(templateId);
					result=siteService.saveSiteData(siteData);
					//redirectAttributes.addAttribute("result",result);
					redirectAttributes.addAttribute("status",result.getStatus());
					redirectAttributes.addAttribute("message",result.getMessage());
					redirectAttributes.addAttribute("redirectedAck",true);
					return "redirect:ChooseTemplate";
				}else{
					redirectAttributes.addAttribute("redirectedAck", true);
					redirectAttributes.addAttribute("message", Strings.notAuthorized);
					return "redirect:ChooseTemplate";
				}

			
		} catch (Exception e) {

			e.printStackTrace();
			redirectAttributes.addAttribute("redirectedAck", true);
			redirectAttributes.addAttribute("message", Strings.error);
			return "redirect:ChooseTemplate";
		}


	}else{
		redirectAttributes.addAttribute("redirectedAck", true);
		redirectAttributes.addAttribute("message", Strings.emptyTemplate);
		return "redirect:ChooseTemplate";
	}

}

@RequestMapping(value="siteTemplateSetupG", method=RequestMethod.GET )
public String siteTemplateSetupForm(ModelMap map,
		HttpServletRequest request,
		@RequestParam(value="redirectedAck",defaultValue="false",required=false)boolean redirectedAck, 
		@RequestParam(value="status",required=false)String status,	
		@RequestParam(value="message",required=false)String message)
{
	System.out.println("siteTemplateSetupG");
	String url="redirect:LoginForm";
	try {
			if(redirectedAck)
			{   
				map.addAttribute("status",status);
				map.addAttribute("message",message);
				return "Ack";
			}
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			User user = (User) principal;
				Integer userType=user.getUserType();
				Integer adminId=user.getUserId();
				adminId=adminId==null?0:adminId;
		
			if(userType!=null && userType.equals(2))
			{
				Site site=siteService.getSiteByAdminId(adminId);
				
				SiteData siteData=new SiteData();
				//siteData.setSiteId(site.getSiteId());
				//map.addAttribute("siteData",site.getSiteData());
				Map<MenuDetails, List<SubMenuDetails>> menuMap=siteService.convertMenusToMap(site.getMenuDetails(),site.getSubmenu());
				System.out.println("Menu Map is "+menuMap);
			
				site.setMenuSubmenuData(menuMap);
				map.addAttribute("site",site);
				url="SiteDetailForm";
			}else{
				
			}

		
	} catch (Exception e) {

		e.printStackTrace();
	}
	return url;
}

@RequestMapping(value="siteTemplateSetup", method=RequestMethod.POST )
public ModelAndView saveSiteTemplateSetup(@Valid @ModelAttribute("site")Site site,
		BindingResult bindingResult,
		ModelMap map,ModelAndView mav,
		RedirectAttributes redirectAttributes,
		HttpServletRequest request)
{
	
	ResultDataMap result=new ResultDataMap();
	mav.setViewName("");
	String url="";
	try {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		User user = (User) principal;
			Integer userType=user.getUserType();
			Integer adminId=user.getUserId();
			adminId=adminId==null?0:adminId;
	
			if(userType!=null && userType.equals(2))
			{

				
				
			
				
				if(!bindingResult.hasErrors() && 
							site!=null  )
				{
					
					result=siteService.saveSiteTemplateSetup(site,adminId);
					map.addAttribute("site",site);
					redirectAttributes.addAttribute("message",result.getMessage());
					redirectAttributes.addAttribute("status",result.getStatus());
					if(result.getStatus())
					{
						mav.setViewName("redirect:siteTemplateSetupG");
					}else{
						mav.setViewName("SiteDetailForm");
					}
					redirectAttributes.addAttribute("redirectedAck",true);
					
					
				}else{
					System.out.println(bindingResult.getAllErrors());
					map.addAttribute("site", site);
					map.addAttribute("message","please correct the errors");
					url="SiteDetailForm";
					mav.setViewName(url);
					return mav;
				}


			}

		
	} catch (Exception e) {

		e.printStackTrace();
	}
	return mav;
}


}
