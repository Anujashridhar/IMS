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
import in.cdac.db.masters.entity.MstLocationLevel3;
import in.cdac.ims.masters.service.CountryMasterService;
import in.cdac.ims.masters.service.LocationLevel1MasterService;
import in.cdac.ims.masters.service.LocationLevel2MasterService;
import in.cdac.ims.masters.service.LocationLevel3MasterService;
import in.cdac.ims.util.entity.MapObject;
import in.cdac.ims.util.entity.ResultDataMap;

@Controller
@RequestMapping("site/admin/")
public class LocationLevel3MasterController {
	 
	@Autowired
	LocationLevel3MasterService locationLevel3MasterService;
	
	@Autowired
	LocationLevel2MasterService locationLevel2MasterService;
	
	@Autowired
	LocationLevel1MasterService locationLevel1MasterService;
	
	@Autowired
	CountryMasterService cmd;
	
	
	@RequestMapping(value="/ChooseLocationLevel3",method=RequestMethod.GET)
	public ModelAndView ChooseTemplateForm(HttpServletRequest request,ModelMap map,ModelAndView mav)
	{
		MstLocationLevel3 level3 = new MstLocationLevel3();
		//CountryMasterDao srd = new CountryMasterDao();
		HashMap<Integer, String> countryList=new HashMap<Integer, String>();
		countryList = cmd.getCountryList();
		ArrayList<String> name = new ArrayList<String>();
		HttpSession session=request.getSession();
		//LocationLevel3MasterDao srd1 = new LocationLevel3MasterDao();
		User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Integer userId=user.getUserId();
		name=locationLevel3MasterService.getLocation3Details(userId);
		String loc1=name.get(0);
		String loc2=name.get(1);
		String loc3=name.get(2);
		map.addAttribute("loc1", loc1);
		map.addAttribute("loc2", loc2);
		map.addAttribute("loc3", loc3);
		mav.addObject("countryList",countryList);
		mav.addObject("level3", level3);
		System.out.println("ChooseLocationLevel3..........");
		mav.setViewName("LocationLevel3Add");
		return mav;
	}
	
	
	@RequestMapping(value="/saveLocationLevel3",method=RequestMethod.POST )
	public ModelAndView saveSelectedTemplate(/*@RequestParam("locLevel2Name") String locLevel2Name,
											@RequestParam("countryId") Integer countryId,
											@RequestParam("locLevel1Id") Integer locLevel1Id,
											@RequestParam("locLevel2Code") Integer locLevel2Code*/
											@ModelAttribute("level3") MstLocationLevel3 level3,
											ModelMap map,ModelAndView mav,
											RedirectAttributes redirectAttributes,HttpServletRequest request)
	{
		System.out.println("in controller" + level3.getLocLevel3Name());
		ResultDataMap rdm =new ResultDataMap();
		HttpSession session=request.getSession();
		MstLocationLevel3 ms= new MstLocationLevel3();
		//LocationLevel3MasterDao srd = new LocationLevel3MasterDao();
		ms.setLocLevel3Name(level3.getLocLevel3Name());
		ms.setCountryId(level3.getCountryId());
		ms.setLocLevel1Id(Integer.valueOf(level3.getLocLevel1Id()));
		ms.setLocLevel2Id(Integer.valueOf(level3.getLocLevel2Id()));
		ms.setLocLevel3Code(level3.getLocLevel3Code());
		User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Integer userId=user.getUserId();
	
		ms.setEnteredBy(userId);
		ms.setModifiedBy(userId);
		rdm=locationLevel3MasterService.saveNewLocLevel3(ms);
		System.out.println("saved" + level3.getLocLevel3Name());
		map.addAttribute("resultDataMap",rdm);
		mav.setViewName("redirect:/dashboard");
		return mav;
	}
	

	@RequestMapping(value="/GetLocationLevel2",method=RequestMethod.GET)
	public @ResponseBody ResultDataMap getLocationLevel1(@RequestParam("countryId") Integer countryId,
											@RequestParam("locLevel1Id") Integer locLevel1Id,
											HttpServletRequest request,ModelMap map,ModelAndView mav)
	{
		ResultDataMap result=new ResultDataMap();
		List<MapObject> datamap=new ArrayList<MapObject>();
		//LocationLevel2MasterDao loclevel2 = new LocationLevel2MasterDao();
		datamap = locationLevel2MasterService.getLocationLevel2List(countryId,locLevel1Id);
		result.setDataMap(datamap);
		System.out.println("GetLocationLevel2..........");
		return result;
			
	}
	
}
