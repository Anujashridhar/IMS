package in.cdac.masters.jsp.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.cdac.db.masters.entity.MstState;
import in.cdac.ims.util.entity.ResultDataMap;
import in.cdac.masters.dao.CountryMasterDao;
import in.cdac.masters.dao.StateMasterDao;


@Controller
@RequestMapping("site/admin/")
public class StateMasterController {

	@Autowired
	CountryMasterDao srd;
	
	@Autowired
	StateMasterDao srd2;
	
	@RequestMapping(value="/ChooseState",method=RequestMethod.GET)
	public ModelAndView ChooseTemplateForm(HttpServletRequest request,ModelMap map,ModelAndView mav)
	{
		MstState state = new MstState();
		//CountryMasterDao srd = new CountryMasterDao();
		HashMap<Integer, String> countryList=new HashMap<Integer, String>();
		countryList = srd.getCountryList();
		mav.addObject("countryList",countryList);
		mav.addObject("state", state);
		System.out.println("ChooseState..........");
		mav.setViewName("MstNewState");
		return mav;
			
	}
	
	@RequestMapping(value="/saveNewState",method=RequestMethod.POST )
	public ModelAndView saveSelectedTemplate(@RequestParam("stateName") String stateName,
											@RequestParam("countryId") Integer countryId,
											ModelMap map,ModelAndView mav,
											RedirectAttributes redirectAttributes,HttpServletRequest request)
	{
		
		String url;
		System.out.println("in controller" + stateName);
		ResultDataMap rdm =new ResultDataMap();
		MstState ms= new MstState();
		//StateMasterDao srd2 = new StateMasterDao();
		ms.setStateName(stateName);
		ms.setCountryId(countryId);
		rdm=srd2.saveNewState(ms);
		map.addAttribute("resultDataMap",rdm);
		mav.setViewName("redirect:/dashboard");
		return mav;
	
	}
	
}
