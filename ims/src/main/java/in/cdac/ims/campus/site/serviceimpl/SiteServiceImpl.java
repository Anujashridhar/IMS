package in.cdac.ims.campus.site.serviceimpl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdac.db.campus.entity.MenuDetails;
import in.cdac.db.campus.entity.SiteData;
import in.cdac.db.campus.entity.SubMenuDetails;
import in.cdac.ims.campus.entity.Menus;
import in.cdac.ims.campus.entity.Site;
import in.cdac.ims.campus.site.dao.SiteDao;
import in.cdac.ims.campus.site.service.SiteService;
import in.cdac.ims.util.entity.ResultDataMap;
@Service
@Transactional
public class SiteServiceImpl implements SiteService {

	@Autowired
	SiteDao siteDao;
	
	public Site getSiteByAdminId(Integer adminId) {
		
		return siteDao.getSiteByAdminId(adminId);
	}

	public Integer getSiteIdByAdminId(Integer adminId) {
	
		return siteDao.getSiteIdByAdminId(adminId);
	}

	public ResultDataMap saveSiteTemplateSetup(Site site, Integer adminId) {
	
		site.setSiteId(getSiteIdByAdminId(adminId));
		return siteDao.saveSiteTemplateSetup(site, adminId);
	}

	public ResultDataMap saveSiteData(SiteData site) {
		
		return siteDao.saveSiteData(site);
	}

	

	public Map<String, Menus> convertMenusToMap(List<MenuDetails> menuDetails) {
		
		Map<String, Menus> finResult=new LinkedHashMap<String, Menus>();
	    
		for (MenuDetails menutemp : menuDetails) {
			 Menus menu=new Menus();
				
			menu.convertToMenu(menutemp);
			if(menu.getParentId().equals(0))
			{
				menu.getSumenuList().addAll(findChildren(menuDetails,menu.getMenuId()));
				finResult.put(menu.getMenuName(), menu);
				
				
			}else{
				/*List<String> parents=findParents(menuDetails, menu.getParentId());
				String key="";
				for (String string : parents) {
					key=key+string+" ==>> ";
				}
				key=key+menu.getMenuName();
				System.out.println(key);
				menu.getSumenuList().addAll(findChildren(menuDetails, menu.getMenuId()));
				finResult.put(key, menu);*/
			}
		}
		return finResult;
	}

public Map<MenuDetails, List<SubMenuDetails>> convertMenusToMap(List<MenuDetails> menuDetails,List<SubMenuDetails> submenuDetails) {
		
		Map<MenuDetails, List<SubMenuDetails>> finResult=new LinkedHashMap<MenuDetails, List<SubMenuDetails>>();
	    if(menuDetails !=null && !menuDetails.isEmpty()){
		try {
			for (MenuDetails menutemp : menuDetails) {
				List<SubMenuDetails> submenus=new ArrayList<SubMenuDetails>();
				if(submenuDetails!=null && !submenuDetails.isEmpty()){
					for (SubMenuDetails subMenuDetails2 : submenuDetails) {
						if(menutemp.getMenuId().equals(subMenuDetails2.getParentId()))
						{
							submenus.add(subMenuDetails2);
						}
						
					}
				}
					finResult.put(menutemp, submenus);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return finResult;
	}
	private List<Menus> findChildren(List<MenuDetails> menuDetails,Integer parentId) {
		List<Menus> submenuList=new ArrayList<Menus>();
		
		for (MenuDetails menu : menuDetails) {
			if(menu.getParentId().equals(parentId))
			{
				Menus submenu=new Menus();
				submenu.setMenuId(menu.getMenuId());
				submenu.setParentId(menu.getParentId());
				submenu.setUrl(menu.getMenuUrl());
				submenu.setMenuName(menu.getMenuName());
				submenuList.add(submenu);
				/*Map<String,String> det=new LinkedHashMap<>();
				det.put("url",menu.getMenuUrl());
				det.put("parentId", menu.getParentId().toString());
				map.put(menu.getMenuName(), det);*/
			}
		}
		return submenuList;
	}
	private List<String> findParents(List<MenuDetails> menuDetails,Integer parentId) {
		List<String> list=new ArrayList<String>();
		for (MenuDetails menu : menuDetails) {
			if(menu.getMenuId().equals(parentId))
			{
				list.add(menu.getMenuName());
				if(menu.getParentId().equals(0))
				{
					return list;
				}else{
					parentId=menu.getParentId();
				}
				
			}
		}
		return list;
	}


}
