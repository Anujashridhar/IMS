package in.cdac.ims.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import in.cdac.ims.campus.entity.Site;
import in.cdac.ims.campus.site.service.SiteService;
import in.cdac.ims.site.rendring.service.RendringService;
import in.cdac.ims.util.entity.ResultDataMap;

@Controller

public class SiteRenderController {
	
	@Autowired
	SiteService siteService;
	
	@Autowired
	RendringService renderingService;
	
	@RequestMapping("/loc/{siteName}/{siteId}")

	public String renderSite(@PathVariable String siteName, 
							@PathVariable String siteId,ModelMap map)
	{
		ResultDataMap result=renderingService.getRenderingData(siteName);
		if(result.getData().isEmpty())
		{
			return "commonIndex";
		}
		map.addAttribute("result",result);
		Site site=(Site)result.getData().get("site");
		site.setMenuSubmenuData(siteService.convertMenusToMap(site.getMenuDetails(),site.getSubmenu()));
		map.addAttribute("site",site);
		return "templatePages/index";
		
	}
}
