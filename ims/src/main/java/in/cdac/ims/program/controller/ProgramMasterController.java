package in.cdac.ims.program.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.cdac.db.auth.entity.User;
import in.cdac.db.masters.entity.MstLocationLevel1;
import in.cdac.db.program.entity.ProgramMaster;
import in.cdac.ims.masters.jsp.dao.impl.CountryMasterDaoImpl;
import in.cdac.ims.program.service.BranchService;
import in.cdac.ims.program.service.ProgramService;
import in.cdac.ims.program.service.SubBranchService;
import in.cdac.ims.util.entity.ResultDataMap;

@Controller
@RequestMapping("programme/")
public class ProgramMasterController {
	
	@Autowired
	ProgramService programService;
	@Autowired
	BranchService branchService;
	
	@RequestMapping(value="/ChooseProgram",method=RequestMethod.GET)
	public ModelAndView ChooseProgram(HttpServletRequest request,ModelMap map,ModelAndView mav)
	{
		ProgramMaster program = new ProgramMaster();
		HashMap<Integer, String> branchList=new HashMap<>();
		branchList = branchService.getBranchList();
		HttpSession session=request.getSession();
		Integer usr=(Integer)session.getAttribute("userId");
		mav.addObject("branchList",branchList);
		mav.addObject("program", program);
		System.out.println("ChooseProgram..........");
		mav.setViewName("MstNewProgram");
		return mav;
			
	}
	
	
	@RequestMapping(value="/saveProgramDetails",method=RequestMethod.POST )
	public ModelAndView saveSubBranch(@Valid @ModelAttribute("program") ProgramMaster program,BindingResult bindingResult,
													ModelMap map,ModelAndView mav,
											RedirectAttributes redirectAttributes,HttpServletRequest request)
	{
		//
		if(bindingResult.hasErrors())
		{
			System.out.println(bindingResult);
			mav.addObject("branchList",branchService.getBranchList());
			mav.addObject("program", program);
			
			mav.setViewName("MstNewProgram");
			return mav;
		}
		//ProgramMaster program=new ProgramMaster();
		HttpSession session=request.getSession();
		System.out.println("in controller program ");
		ResultDataMap rdm =new ResultDataMap();
		ProgramMaster prgm = new ProgramMaster();
		User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Integer userId=user.getUserId();
		prgm.setProgramCode(program.getProgramCode());
		prgm.setProgramName(program.getProgramName());
		prgm.setSemYearly(program.getSemYearly());
		prgm.setBranchId(program.getBranchId());
		prgm.setSubBranchId(program.getSubBranchId());
		prgm.setDurationOfCourse(program.getDurationOfCourse());
		prgm.setFees(program.getFees());
		prgm.setDescription(program.getDescription());
		prgm.setEligibility(program.getEligibility());
		prgm.setEnteredBy(userId);
		prgm.setModifiedBy(userId);
		rdm=programService.saveProgramDetails(prgm);
		map.addAttribute("resultDataMap",rdm);
		map.addAttribute("message" ,rdm.getMessage());
		mav.setViewName("Ack");
		return mav;
	
	}
	

}
