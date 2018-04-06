package in.cdac.masters.jsp.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
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
import in.cdac.db.masters.entity.MstLocationLevel1;
import in.cdac.ims.util.entity.ResultDataMap;
import in.cdac.masters.dao.CountryMasterDao;
import in.cdac.masters.dao.LocationLevel1MasterDao;

@Controller
@RequestMapping("site/admin/")
public class LocationLevel1MasterController {
	@Autowired
	CountryMasterDao srd;
	@Autowired
	LocationLevel1MasterDao locationLevel1MasterDao;
	
	@Autowired
	LocationLevel1MasterDao srd1 ;
	@RequestMapping(value="/ChooseLocationLevel1",method=RequestMethod.GET)
	public ModelAndView ChooseTemplateForm(HttpServletRequest request,ModelMap map,ModelAndView mav)
	{
		String name=null;
		MstLocationLevel1 level1 = new MstLocationLevel1();
		//CountryMasterDao srd = new CountryMasterDao();
		HashMap<Integer, String> countryList=new HashMap<Integer, String>();
		countryList = srd.getCountryList();
		//HttpSession session=request.getSession();
		//LocationLevel1MasterDao srd1 = new LocationLevel1MasterDao();
		User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Integer userId=user.getUserId();
		name=srd1.getLocation1Details(userId);
		map.addAttribute("name", name);
		mav.addObject("countryList",countryList);
		mav.addObject("level1", level1);
		System.out.println("ChooseLocationLevel1..........");
		mav.setViewName("LocationLevel1Add");
		return mav;
			
	}
	
	
	@RequestMapping(value="/saveLocationLevel1",method=RequestMethod.POST )
	public ModelAndView saveSelectedTemplate(@RequestParam("locLevel1Name") String locLevel1Name,
											@RequestParam("countryId") Integer countryId,
											@RequestParam("locLevel1Code") Integer locLevel1Code,
											ModelMap map,ModelAndView mav,
											RedirectAttributes redirectAttributes,HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		System.out.println("in controller" + locLevel1Name);
		ResultDataMap rdm =new ResultDataMap();
		MstLocationLevel1 ms= new MstLocationLevel1();
		//LocationLevel1MasterDao srd = new LocationLevel1MasterDao();
		ms.setLocLevel1Name(locLevel1Name);
		ms.setCountryId(countryId);
		ms.setLocLevel1Code(locLevel1Code);
		User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Integer userId=user.getUserId();
		
		ms.setEnteredBy(userId);
		ms.setModifiedBy(userId);
		rdm=locationLevel1MasterDao.saveNewLocLevel1(ms);
		map.addAttribute("resultDataMap",rdm);
		mav.setViewName("redirect:/dashboard");
		return mav;
	
	}
	

}
