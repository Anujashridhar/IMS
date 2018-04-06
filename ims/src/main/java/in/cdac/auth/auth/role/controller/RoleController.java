package in.cdac.auth.auth.role.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.tool.schema.extract.spi.ExtractionContext.DatabaseObjectAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.cdac.auth.entity.RoleWrapper;
import in.cdac.auth.role.service.RoleService;
import in.cdac.db.auth.entity.User;
import in.cdac.ims.util.entity.ResultDataMap;

@Controller
@RequestMapping("auth/")
public class RoleController {

	@Autowired
	RoleService roleService;
	
	@GetMapping("createModifyRole")
	public ModelAndView createRole(@RequestParam(name="roleId",required=false,defaultValue="0")Integer roleId, ModelMap modelMap )
	{
		System.out.println("createROle");
		ModelAndView mav=new ModelAndView();
		RoleWrapper roleWrapper=new RoleWrapper();
		ResultDataMap rdm=roleService.getRoleByRoleId(roleId);
		
		if(rdm!=null && rdm.getDataObject()!=null) {
		roleWrapper=(RoleWrapper)rdm.getDataObject();
		System.out.println(roleWrapper);
		}
		
		mav.addObject("roleWrapper",roleWrapper);
		mav.setViewName("userroles/CreateRole");
		
		
		return mav;
	}
	
	@PostMapping("saveRole")
	public ModelAndView saveRole(@Valid @ModelAttribute("roleWrapper")RoleWrapper roleWrapper,ModelMap modelMap )
	{
		System.out.println("roleWrapper" + roleWrapper.getRoleName()+" :: "+roleWrapper.getSelectedAuthorities());
		ModelAndView mav=new ModelAndView();
//		RoleWrapper roleWrapper=new RoleWrapper();
		User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ResultDataMap a=roleService.saveRole(roleWrapper, user.getUserId());
		if(a!=null && a.getStatus())
		{
			mav.setViewName("redirect:viewRoles");
				
		}else {
			
					
			mav.addObject("roleWrapper",roleWrapper);
			
			mav.setViewName("userroles/CreateRole");
			
		}
		mav.addObject("roleWrapper",roleWrapper);
		
		
		return mav;
	}
	@PostMapping("test")
	public String test(HttpServletRequest request)
	{
		Enumeration<String> en=request.getParameterNames();
		while (en.hasMoreElements()) {
			String string = (String) en.nextElement();
			System.out.println(request.getParameterValues("selectName"));
			
		}
		System.out.println();
		
		return "";
	}
	
	
	@SuppressWarnings("unchecked")
	@GetMapping("viewRoles")
	public ModelAndView viewRoles(ModelMap modelMap )
	{
		System.out.println("createROle");
		ModelAndView mav=new ModelAndView();
		List<RoleWrapper> roleWrapperList=new ArrayList<RoleWrapper>();
		ResultDataMap rdm=roleService.getAllRoleAuthorities();
		
		if(rdm!=null && rdm.getDataObject()!=null) {
		roleWrapperList=(List<RoleWrapper>)rdm.getDataObject();
		System.out.println(roleWrapperList);
		}
		
		mav.addObject("roleWrapperList",roleWrapperList);
		mav.setViewName("userroles/ViewRoles");
		
		
		return mav;
	}
}
