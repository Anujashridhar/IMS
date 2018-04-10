package in.cdac.masters.jsp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.cdac.db.auth.entity.User;
import in.cdac.db.masters.entity.MstLocationLevel2;
import in.cdac.ims.masters.service.CountryMasterService;
import in.cdac.ims.masters.service.LocationLevel1MasterService;
import in.cdac.ims.masters.service.LocationLevel2MasterService;
import in.cdac.ims.util.entity.MapObject;
import in.cdac.ims.util.entity.ResultDataMap;

@Controller
@RequestMapping("site/admin/")
public class LocationLevel2MasterController {
	
	@Autowired
	LocationLevel2MasterService locationLevel2MasterService;
	
	@Autowired
	LocationLevel1MasterService locationLevel1MasterService;
	
	@Autowired
	CountryMasterService cmd;
	
	@RequestMapping(value="/ChooseLocationLevel2",method=RequestMethod.GET)
	public ModelAndView ChooseTemplateForm(HttpServletRequest request,ModelMap map,ModelAndView mav)
	{
		MstLocationLevel2 level2 = new MstLocationLevel2();
		//CountryMasterDao srd = new CountryMasterDao();
		HashMap<Integer, String> countryList=new HashMap<Integer, String>();
		countryList = cmd.getCountryList();
		ArrayList<String> name = new ArrayList<String>();
		HttpSession session=request.getSession();
		//LocationLevel2MasterDao srd1 = new LocationLevel2MasterDao();
		User user= (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Integer usr=user.getUserId();
		name=locationLevel2MasterService.getLocation2Details(usr);
		String loc1=name.get(0);
		String loc2=name.get(1);
		map.addAttribute("loc1", loc1);
		map.addAttribute("loc2", loc2);
		mav.addObject("countryList",countryList);
		mav.addObject("level2", level2);
		System.out.println("ChooseLocationLevel2..........");
		mav.setViewName("LocationLevel2Add");
		return mav;
	}
	
	
	@RequestMapping(value="/saveLocationLevel2",method=RequestMethod.POST )
	public ModelAndView saveSelectedTemplate(/*@RequestParam("locLevel2Name") String locLevel2Name,
											@RequestParam("countryId") Integer countryId,
											@RequestParam("locLevel1Id") Integer locLevel1Id,
											@RequestParam("locLevel2Code") Integer locLevel2Code*/
											@ModelAttribute("level2") MstLocationLevel2 level2,
											ModelMap map,ModelAndView mav,
											RedirectAttributes redirectAttributes,HttpServletRequest request)
	{
		System.out.println("in controller" + level2.getLocLevel2Name());
		ResultDataMap rdm =new ResultDataMap();
		//HttpSession session=request.getSession();
		MstLocationLevel2 ms= new MstLocationLevel2();
		//LocationLevel2MasterDao srd = new LocationLevel2MasterDao();
		ms.setLocLevel2Name(level2.getLocLevel2Name());
		ms.setCountryId(level2.getCountryId());
		ms.setLocLevel1Id(Integer.valueOf(level2.getLocLevel1Id()));
		ms.setLocLevel2Code(level2.getLocLevel2Code());
		User user= (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Integer usr=user.getUserId();
	
		ms.setEnteredBy(usr);
		ms.setModifiedBy(usr);
		rdm=locationLevel2MasterService.saveNewLocLevel2(ms);
		System.out.println("saved" + level2.getLocLevel2Name());
		map.addAttribute("resultDataMap",rdm);
		mav.setViewName("redirect:/dashboard");
		return mav;
	}
	

	@RequestMapping(value="/GetLocationLevel1",method=RequestMethod.GET)
	public @ResponseBody ResultDataMap getLocationLevel1(@RequestParam("countryId") Integer countryId,
											HttpServletRequest request,ModelMap map,ModelAndView mav)
	{
		ResultDataMap result=new ResultDataMap();
		List<MapObject> datamap=new ArrayList<MapObject>();
		//LocationLevel1MasterDao loclevel1 = new LocationLevel1MasterDao();
		datamap = locationLevel1MasterService.getLocationLevel1List(countryId);
		result.setDataMap(datamap);
		System.out.println("GetLocationLevel1..........");
		return result;
			
	}
	
}
