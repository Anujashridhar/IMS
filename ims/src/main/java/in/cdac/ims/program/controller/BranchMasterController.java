package in.cdac.ims.program.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.cdac.ims.program.beans.db.BranchMaster;
import in.cdac.ims.program.dao.BranchMasterDao;
import in.cdac.ims.util.entity.ResultDataMap;


@Controller
public class BranchMasterController {

	
	
	@RequestMapping(value="ChooseBranch",method=RequestMethod.GET)
	public String ChooseTemplateForm(HttpServletRequest request)
	{
		System.out.println("ChooseBranch..........");
		return "MstNewBranch";
			
	}
	
	
	@RequestMapping(value="saveNewBranch",method=RequestMethod.POST )
	public ModelAndView saveSelectedTemplate(@RequestParam("branchName") String branchName,
											 @RequestParam("branchCode") Integer branchCode,
											ModelMap map,ModelAndView mav,
											RedirectAttributes redirectAttributes,HttpServletRequest request)
	{
		
		HttpSession session=request.getSession();
		System.out.println("in controller" + branchName);
		ResultDataMap rdm =new ResultDataMap();
		BranchMaster bm= new BranchMaster();
		BranchMasterDao srd = new BranchMasterDao();
		bm.setBranchName(branchName);
		bm.setBranchCode(branchCode);
		bm.setEnteredBy((Integer)session.getAttribute("userId"));
		bm.setModifiedBy((Integer)session.getAttribute("userId"));
		System.out.println(bm.getBranchCode());
		rdm=srd.saveNewBranch(bm);
		System.out.println("New branch added successfully");
		map.addAttribute("resultDataMap",rdm);
		mav.setViewName("redirect:/dashboard");
		return mav;
	
	}
	
}
