package in.cdac.ims.campus.site.controller.jsp;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.cdac.db.auth.entity.User;
import in.cdac.db.campus.entity.DivDetails;
import in.cdac.db.campus.entity.ImageDetails;
import in.cdac.ims.campus.entity.ImageForm;
import in.cdac.ims.campus.entity.Site;
import in.cdac.ims.campus.site.service.SiteContentService;
import in.cdac.ims.campus.site.service.SiteService;
import in.cdac.ims.util.entity.ResultDataMap;
import in.cdac.ims.util.entity.Strings;


@Controller
@RequestMapping(value="site/content/")
public class SiteContentController {
	@Autowired
	SiteContentService siteContentService;
	
	@Autowired
	SiteService siteService;

	@GetMapping("uploadLogo")
	public String getUploadLogoForm(ModelMap map,
										HttpServletRequest request,
										@RequestParam(value="redirectedAck",defaultValue="false",required=false)boolean redirectedAck, 
										@RequestParam(value="status",required=false)String status,	
										@RequestParam(value="message",required=false)String message
									)
	{
		
		ResultDataMap result=new ResultDataMap();
		System.out.println("upload logo form");
		String url="/LoginForm";
		try {
		
				if(redirectedAck)
				{   
					map.addAttribute("status",status);
					map.addAttribute("message",message);
					return "siteRegistrationAck";
				}
				Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

				User user=(User)principal;
				Integer userType=user.getUserType();
				Integer userId=user.getUserId();
				
				/*
				String userType=(String)session.getAttribute("userType");
				Integer userId=(Integer)session.getAttribute("userId");
				*/if(userType!=null && userType.equals(2))
				{
					
					
					url="uploadLogoForm";
				}else{
					result.setStatus(false);
					result.setMessage(Strings.accessDenied);
					map.addAttribute("result",result);
					url="redirect:loginForm";
				}
				
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		return url;
	}
	
	
	
	@PostMapping("uploadLogoSubmit" )
	public String saveSiteImages(@RequestParam(value="logo",required=false)MultipartFile logoFile,
												ModelMap map,
												RedirectAttributes redirectAttributes,
												MultipartHttpServletRequest request)
	{
		System.out.println(logoFile);
		ResultDataMap result=new ResultDataMap();
		String url="";
		try {
			
			User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				Integer userType=user.getUserType();
				Integer userId=user.getUserId();
				if(userType!=null && userType.equals(2))
				{
					
					if(logoFile==null)
					{
						url="redirect:uploadLogo";
						return url;
					}else{
						
						result=siteContentService.saveLogo(logoFile,userId);
						map.addAttribute("result",result);
						map.addAttribute("message",result.getMessage());
						map.addAttribute("status",result.getStatus());
						map.addAttribute("redirectedAck",true);
						if(result.getStatus())
						{
							url="Ack";
						}
					}
					
					
				}
				
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		return url;
	}

	
	@RequestMapping(value="SiteImagesForm",method=RequestMethod.GET)
	public ModelAndView getSiteImagesForm(ModelMap map,
										HttpServletRequest request,
										@RequestParam(value="redirectedAck",defaultValue="false",required=false)boolean redirectedAck, 
										@RequestParam(value="status",required=false)String status,	
										@RequestParam(value="message",required=false)String message
									)
	{
		System.out.println("SiteImagesForm");
		
		ModelAndView mav=new ModelAndView();
		String url="/LoginForm";
		try {
			ImageForm imageForm=new ImageForm();
				if(redirectedAck)
				{   
					map.addAttribute("status",status);
					map.addAttribute("message",message);
					mav.setViewName("Ack");
					return mav;
				}
				
				User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				Integer userType=user.getUserType();
				Integer userId=user.getUserId();
				if(userType!=null && userType.equals(2))
				{
					Site site=siteService.getSiteByAdminId(userId);
					List<ImageDetails> imageList=site.getImageList();
					System.out.println("imageList"+imageList);
					if(imageList==null || imageList.isEmpty())
					{
						imageList=new ArrayList<ImageDetails>();
					}
					imageForm.setImageList(imageList);
					map.addAttribute("imageForm",imageForm);
					url="SiteImagesForm";
				}else{
					
				}
				
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		mav.setViewName(url);
		return mav;
	}
/*	 protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
				throws ServletException {
					
				// Convert multipart object to byte[]
				binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
			 }
				
	*/

@RequestMapping(value="saveSiteImages", method=RequestMethod.POST )
public ModelAndView saveSiteImages(@ModelAttribute("site")ImageForm imageForm,
																BindingResult bindingResult,
																ModelMap map,
																RedirectAttributes redirectAttributes,
																HttpServletRequest request,
																ModelAndView mav)
{
	System.out.println("SiteImagesForm");
	
	ResultDataMap result=new ResultDataMap();
	String url="";
	try {
		
		User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Integer userId= user.getUserId();
		
			Integer userType=user.getUserType();
			if(userType!=null && userType.equals(2))
			{
				
				if(bindingResult.hasErrors() )
				{
					url="SiteDataSetupForm";
					mav.setViewName(url);
					return mav;
				}else{
					result=siteContentService.saveImages(imageForm,userId);
					map.addAttribute("result",result);
					map.addAttribute("redirectedAck",true);
					if(result.getStatus())
					{
						//redirectAttributes.addAttribute("result",result);
						redirectAttributes.addAttribute("status",result.getStatus());
						redirectAttributes.addAttribute("message",result.getMessage());
						redirectAttributes.addAttribute("redirectedAck","true");
						url="redirect:SiteImagesForm";
					}
				}
				
				
			}
			
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	mav.setViewName(url);
	return mav;
}

/*

@RequestMapping(value="saveSiteImages", method=RequestMethod.POST )
public String saveSiteImages(@ModelAttribute("imageDetail")ImageDetails imageDetail,
																BindingResult bindingResult,
																ModelMap map,
																RedirectAttributes redirectAttributes,
																HttpServletRequest request)
{
	ResultDataMap result=new ResultDataMap();
	String url="";
	try {
		HttpSession session=request.getSession();
		Boolean login=(Boolean)request.getSession().getAttribute("login");
		if(login!=null && login)
		{
			String userType=(String)session.getAttribute("userType");
			Integer userId=(Integer)session.getAttribute("userId");
			if(userType!=null && userType.equals(Strings.siteAdmin))
			{
				
				if(bindingResult.hasErrors() 
						|| imageDetail.getSiteId().equals(null) 
						||  !imageDetail.getSiteId().equals(new SiteService().getSiteByAdminId(userId).getSiteId()))
				{
					url="SiteDataSetupForm";
					return url;
				}else{
					ContentManagmentService siteContentService=new ContentManagmentService();
					result=siteContentService.saveImages(imageDetail);
					map.addAttribute("result",result);
					map.addAttribute("redirectedAck",true);
					if(result.getStatus())
					{
						url="redirect:SiteImagesForm";
					}
				}
				
				
			}
			
		}else{
			session.invalidate();
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	return url;
}*/


@RequestMapping(value="contentDetail",method=RequestMethod.GET)
public ModelAndView getContentDetailForm(HttpServletRequest request,ModelMap map,ModelAndView mav)
{
	System.out.println("contentDetail");
	
	String url="/LoginForm";
	HttpSession session=request.getSession();
	Site site=new Site();
	List<DivDetails> divdtl=null;
	User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	Integer userid= user.getUserId();
	System.out.println("userId"+userid);
	ArrayList<Integer> ids=new ArrayList<Integer>();
	ids=siteContentService.countDivs(userid);
	Integer siteId=ids.get(0);
	Integer cnt=ids.get(1);
	Integer div = siteContentService.getNoOfDivs(userid);
	Integer noOfDiv=div-1;
	
	if(cnt!=0)
	{
		divdtl=siteContentService.getContentData(siteId);
		site.setDivDetails(divdtl);
	}
	mav.addObject("noOfDiv",noOfDiv);
	mav.addObject("cnt",cnt);
	mav.addObject("siteId",siteId);
	mav.addObject("site", site);
	mav.setViewName("contentForm");
	return mav;
	
	
}


@RequestMapping(value="/saveContentDetail",method=RequestMethod.POST )
public ModelAndView saveContentDetail(@ModelAttribute("site") Site site,ModelMap map,ModelAndView mav,
										RedirectAttributes redirectAttributes,HttpServletRequest request)
{
	System.out.println("contentDetail");
	
	HttpSession session=request.getSession();
	System.out.println("in controller");
	int i;
	ResultDataMap rdm =new ResultDataMap();
	User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	Integer userid= user.getUserId();
		DivDetails divDtl = new DivDetails();
	Integer n=Integer.parseInt(request.getParameter("divs"));
	Integer cnt=Integer.parseInt(request.getParameter("countdivs"));
	Integer siteId=Integer.parseInt(request.getParameter("siteId"));
	if(cnt==0)
	{
		for(i=0;i<=n;i++)
		{
			divDtl.setDivName(site.getDivDetails().get(i).getDivName());
			divDtl.setDivContent(site.getDivDetails().get(i).getDivContent());
			divDtl.setActiveFlag('Y');
			divDtl.setDateOfEntry(new Date());
			divDtl.setDateOfModification(new Date());
			rdm=siteContentService.saveContentDetails(divDtl,userid);
		}
	}
	else
	{
		for(i=0;i<=n;i++)
		{
			Integer divId=site.getDivDetails().get(i).getDivId();
			divDtl.setDivName(site.getDivDetails().get(i).getDivName());
			divDtl.setDivContent(site.getDivDetails().get(i).getDivContent());
			rdm=siteContentService.updateContentDetails(divDtl,siteId,divId);
		}
	}
	map.addAttribute("resultDataMap",rdm);
	mav.setViewName("redirect:/dashboard");
	return mav;

}



}