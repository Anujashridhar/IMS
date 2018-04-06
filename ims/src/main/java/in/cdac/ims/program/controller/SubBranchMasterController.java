/*package in.cdac.ims.program.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.cdac.ims.masters.db.beans.MstLocationLevel1;
import in.cdac.ims.masters.jsp.dao.impl.CountryMasterDaoImpl;
import in.cdac.ims.masters.jsp.dao.impl.LocationLevel1MasterDao;
import in.cdac.ims.program.beans.db.SubBranchMaster;
import in.cdac.ims.program.dao.BranchMasterDao;
import in.cdac.ims.program.dao.SubBranchMasterDao;
import in.cdac.ims.util.beans.MapObject;
import in.cdac.ims.util.beans.ResultDataMap;

@Controller
public class SubBranchMasterController {
	
	
	@RequestMapping(value="/ChooseSubBranch",method=RequestMethod.GET)
	public ModelAndView ChooseSubBranch(HttpServletRequest request,ModelMap map,ModelAndView mav)
	{
		SubBranchMaster subm = new SubBranchMaster();
		BranchMasterDao srd = new BranchMasterDao();
		HashMap<Integer, String> branchList=new HashMap<>();
		branchList = srd.getBranchList();
		HttpSession session=request.getSession();
		SubBranchMasterDao srd1 = new SubBranchMasterDao();
		Integer usr=(Integer)session.getAttribute("userId");
		mav.addObject("branchList",branchList);
		mav.addObject("subm", subm);
		System.out.println("ChooseSubBranch..........");
		mav.setViewName("MstNewSubBranch");
		return mav;
			
	}
	
	
	@RequestMapping(value="/saveSubBranch",method=RequestMethod.POST )
	public ModelAndView saveSubBranch(@RequestParam("subBranchName") String subBranchName,
											@RequestParam("branchId") Integer branchId,
											@RequestParam("subBranchCode") Integer subBranchCode,
											ModelMap map,ModelAndView mav,
											RedirectAttributes redirectAttributes,HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		System.out.println("in controller" + subBranchName);
		ResultDataMap rdm =new ResultDataMap();
		SubBranchMaster subm = new SubBranchMaster();
		SubBranchMasterDao srd1 = new SubBranchMasterDao();
		subm.setSubBranchName(subBranchName);
		subm.setBranchId(branchId);
		subm.setSubBranchCode(subBranchCode);
		subm.setEnteredBy((Integer)session.getAttribute("userId"));
		subm.setModifiedBy((Integer)session.getAttribute("userId"));
		rdm=srd1.saveSubBranch(subm);
		map.addAttribute("resultDataMap",rdm);
		mav.setViewName("redirect:/dashboard");
		return mav;
	
	}
	
	@RequestMapping(value="/GetSubBranch",method=RequestMethod.GET)
	public @ResponseBody ResultDataMap getLocationLevel1(@RequestParam("branchId") Integer branchId,
											HttpServletRequest request,ModelMap map,ModelAndView mav)
	{
		ResultDataMap result=new ResultDataMap();
		List<MapObject> datamap=new ArrayList<>();
		SubBranchMasterDao srd1 = new SubBranchMasterDao();
		datamap = srd1.getSubBranchList(branchId);
		result.setDataMap(datamap);
		System.out.println("GetSubBranch..........");
		return result;
			
	}

}
*/