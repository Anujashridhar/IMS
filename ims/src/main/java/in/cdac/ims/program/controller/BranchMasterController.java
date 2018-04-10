package in.cdac.ims.program.controller;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.cdac.db.auth.entity.User;
import in.cdac.db.program.entity.BranchMaster;
import in.cdac.ims.program.service.BranchService;
import in.cdac.ims.util.entity.ResultDataMap;


@Controller
@RequestMapping("programme/")
public class BranchMasterController {

	@Autowired
	BranchService branchService;
	
	
	@RequestMapping(value="ChooseBranch",method=RequestMethod.GET)
	public String ChooseTemplateForm(HttpServletRequest request)
	{
		System.out.println("ChooseBranch..........");
		return "MstNewBranch";
			
	}
	
	
	@RequestMapping(value="saveNewBranch",method=RequestMethod.POST )
	public ModelAndView saveSelectedTemplate(@RequestParam(value="branchName",required=false) String branchName,
											 @RequestParam(value="branchCode",required=false) Integer branchCode,
											ModelMap map,ModelAndView mav,
											RedirectAttributes redirectAttributes,HttpServletRequest request)
	{
		
		HttpSession session=request.getSession();
		System.out.println("in controller" + branchName);
		ResultDataMap rdm =new ResultDataMap();
		BranchMaster bm= new BranchMaster();
		User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Integer userId=user.getUserId();
		bm.setBranchName(branchName);
		bm.setBranchCode(branchCode);
		bm.setEnteredBy(userId);
		bm.setModifiedBy(userId);
		System.out.println(bm.getBranchCode());
		rdm=branchService.saveNewBranch(bm);
		System.out.println("New branch added successfully");
		map.addAttribute("resultDataMap",rdm);
		mav.setViewName("redirect:/dashboard");
		return mav;
	
	}
	
}
