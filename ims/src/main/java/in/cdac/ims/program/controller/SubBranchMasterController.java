package in.cdac.ims.program.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.cdac.db.auth.entity.User;
import in.cdac.db.program.entity.SubBranchMaster;
import in.cdac.ims.program.service.BranchService;
import in.cdac.ims.program.service.SubBranchService;
import in.cdac.ims.util.entity.MapObject;
import in.cdac.ims.util.entity.ResultDataMap;




@Controller
@RequestMapping("programme/")
public class SubBranchMasterController {
	
	@Autowired
	BranchService branchService;
	@Autowired
	SubBranchService subbranchService;
	
	@RequestMapping(value="/ChooseSubBranch",method=RequestMethod.GET)
	public ModelAndView ChooseSubBranch(HttpServletRequest request,ModelMap map,ModelAndView mav)
	{
		SubBranchMaster subm = new SubBranchMaster();
		HashMap<Integer, String> branchList=new HashMap<>();
		branchList = branchService.getBranchList();
		System.out.println("branchList"+branchList.toString());
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
		User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Integer userId=user.getUserId();
		subm.setSubBranchName(subBranchName);
		subm.setBranchId(branchId);
		subm.setSubBranchCode(subBranchCode);
		subm.setEnteredBy(userId);
		subm.setModifiedBy(userId);
		rdm=subbranchService.saveSubBranch(subm);
		map.addAttribute("resultDataMap",rdm);
		mav.setViewName("redirect:/dashboard");
		return mav;
	
	}
	
	@RequestMapping(value="/GetSubBranch",method=RequestMethod.GET)
	public @ResponseBody ResultDataMap getLocationLevel1(@RequestParam("branchId") Integer branchId,
											HttpServletRequest request,ModelMap map,ModelAndView mav)
	{
		ResultDataMap result=new ResultDataMap();
		System.out.println("program:-getsubbranch");
		List<MapObject> datamap=new ArrayList<>();
		datamap = subbranchService.getSubBranchList(branchId);
		result.setDataMap(datamap);
		System.out.println("GetSubBranch..........");
		return result;
			
	}

}
