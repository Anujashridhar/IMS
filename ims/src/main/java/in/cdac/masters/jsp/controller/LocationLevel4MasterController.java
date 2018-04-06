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
import in.cdac.db.masters.entity.MstLocationLevel4;
import in.cdac.ims.util.entity.MapObject;
import in.cdac.ims.util.entity.ResultDataMap;
import in.cdac.masters.dao.CountryMasterDao;
import in.cdac.masters.dao.LocationLevel3MasterDao;
import in.cdac.masters.dao.LocationLevel4MasterDao;

@Controller
@RequestMapping("site/admin/")
public class LocationLevel4MasterController {
	
	@Autowired
	LocationLevel4MasterDao srd1;
	@Autowired
	LocationLevel4MasterDao srd;
	
	@Autowired
	LocationLevel3MasterDao loclevel3;
	
	@RequestMapping(value="/ChooseLocationLevel4",method=RequestMethod.GET)
	public ModelAndView ChooseTemplateForm(HttpServletRequest request,ModelMap map,ModelAndView mav)
	{
		
		
		
		
		MstLocationLevel4 level4 = new MstLocationLevel4();
		CountryMasterDao srd = new CountryMasterDao();
		HashMap<Integer, String> countryList=new HashMap<Integer, String>();
		countryList = srd.getCountryList();
		ArrayList<String> name = new ArrayList<String>();
		HttpSession session=request.getSession();
		//LocationLevel4MasterDao srd1 = new LocationLevel4MasterDao();
		User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Integer userId=user.getUserId();
	name=srd1.getLocation4Details(userId);
		String loc1=name.get(0);
		String loc2=name.get(1);
		String loc3=name.get(2);
		String loc4=name.get(3);
		map.addAttribute("loc1", loc1);
		map.addAttribute("loc2", loc2);
		map.addAttribute("loc3", loc3);
		map.addAttribute("loc4", loc4);
		mav.addObject("countryList",countryList);
		mav.addObject("level4", level4);
		System.out.println("ChooseLocationLevel4..........");
		mav.setViewName("LocationLevel4Add");
		return mav;
	}
	
	
	@RequestMapping(value="/saveLocationLevel4",method=RequestMethod.POST )
	public ModelAndView saveSelectedTemplate(@ModelAttribute("level4") MstLocationLevel4 level4,
											ModelMap map,ModelAndView mav,
											RedirectAttributes redirectAttributes,HttpServletRequest request)
	{
		System.out.println("in controller" + level4.getLocLevel4Name());
		ResultDataMap rdm =new ResultDataMap();
		User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Integer userId=user.getUserId();
		MstLocationLevel4 ms= new MstLocationLevel4();
		//LocationLevel4MasterDao srd = new LocationLevel4MasterDao();
		ms.setLocLevel4Name(level4.getLocLevel4Name());
		ms.setCountryId(level4.getCountryId());
		ms.setLocLevel1Id(Integer.valueOf(level4.getLocLevel1Id()));
		ms.setLocLevel2Id(Integer.valueOf(level4.getLocLevel2Id()));
		ms.setLocLevel3Id(Integer.valueOf(level4.getLocLevel3Id()));
		ms.setLocLevel4Code(level4.getLocLevel4Code());
		ms.setEnteredBy(userId);
		ms.setModifiedBy(userId);
		rdm=srd.saveNewLocLevel4(ms);
		System.out.println("saved" + level4.getLocLevel4Name());
		map.addAttribute("resultDataMap",rdm);
		mav.setViewName("redirect:/dashboard");
		return mav;
	}
	

	@RequestMapping(value="/GetLocationLevel3",method=RequestMethod.GET)
	public @ResponseBody ResultDataMap getLocationLevel1(@RequestParam("countryId") Integer countryId,
											@RequestParam("locLevel1Id") Integer locLevel1Id,
											@RequestParam("locLevel2Id") Integer locLevel2Id,
											HttpServletRequest request,ModelMap map,ModelAndView mav)
	{
		ResultDataMap result=new ResultDataMap();
		List<MapObject> datamap=new ArrayList<MapObject>();
	//	LocationLevel3MasterDao loclevel3 = new LocationLevel3MasterDao();
		datamap = loclevel3.getLocationLevel2List(countryId,locLevel1Id,locLevel2Id);
		result.setDataMap(datamap);
		System.out.println("GetLocationLevel3..........");
		return result;
			
	}
	
}
