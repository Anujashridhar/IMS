/*package in.cdac.ims.program.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.cdac.db.masters.entity.MstLocationLevel1;
import in.cdac.ims.masters.jsp.dao.impl.CountryMasterDaoImpl;
import in.cdac.ims.masters.jsp.dao.impl.LocationLevel1MasterDao;
import in.cdac.ims.program.beans.db.ProgramMaster;
import in.cdac.ims.program.beans.db.SubBranchMaster;
import in.cdac.ims.program.dao.BranchMasterDao;
import in.cdac.ims.program.dao.ProgramMasterDao;
import in.cdac.ims.program.dao.SubBranchMasterDao;
import in.cdac.ims.util.beans.ResultDataMap;

@Controller
public class ProgramMasterController {
	
	
	@RequestMapping(value="/ChooseProgram",method=RequestMethod.GET)
	public ModelAndView ChooseProgram(HttpServletRequest request,ModelMap map,ModelAndView mav)
	{
		ProgramMaster program = new ProgramMaster();
		BranchMasterDao srd = new BranchMasterDao();
		HashMap<Integer, String> branchList=new HashMap<>();
		branchList = srd.getBranchList();
		HttpSession session=request.getSession();
		Integer usr=(Integer)session.getAttribute("userId");
		mav.addObject("branchList",branchList);
		mav.addObject("program", program);
		System.out.println("ChooseProgram..........");
		mav.setViewName("MstNewProgram");
		return mav;
			
	}
	
	
	@RequestMapping(value="/saveProgramDetails",method=RequestMethod.POST )
	public ModelAndView saveSubBranch(@ModelAttribute("program")ProgramMaster program,ModelMap map,ModelAndView mav,
											RedirectAttributes redirectAttributes,HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		System.out.println("in controller program ");
		ResultDataMap rdm =new ResultDataMap();
		ProgramMaster prgm = new ProgramMaster();
		ProgramMasterDao pmd = new ProgramMasterDao();
		prgm.setProgramCode(program.getProgramCode());
		prgm.setProgramName(program.getProgramName());
		prgm.setSemYearly(program.getSemYearly());
		prgm.setBranchId(program.getBranchId());
		prgm.setSubBranchId(program.getSubBranchId());
		prgm.setDurationOfCourse(program.getDurationOfCourse());
		prgm.setFees(program.getFees());
		prgm.setDescription(program.getDescription());
		prgm.setEligibility(program.getEligibility());
		prgm.setEnteredBy((Integer)session.getAttribute("userId"));
		prgm.setModifiedBy((Integer)session.getAttribute("userId"));
		rdm=pmd.saveProgramDetails(prgm);
		map.addAttribute("resultDataMap",rdm);
		mav.setViewName("redirect:/dashboard");
		return mav;
	
	}
	

}
*/