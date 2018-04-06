package in.cdac.ims.campus.site.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import in.cdac.db.campus.entity.MenuDetails;
import in.cdac.db.campus.entity.SiteData;
import in.cdac.db.campus.entity.SubMenuDetails;
import in.cdac.ims.campus.entity.Site;
import in.cdac.ims.util.entity.ResultDataMap;

/*@Service
@Transactional*/
public interface SiteService {
	public Site getSiteByAdminId(Integer adminId);
	public Integer getSiteIdByAdminId(Integer adminId);
	public ResultDataMap saveSiteTemplateSetup(Site site, Integer adminId) ;
	public ResultDataMap saveSiteData(SiteData site);
	public Map<MenuDetails, List<SubMenuDetails>> convertMenusToMap(List<MenuDetails> menuDetails,
			List<SubMenuDetails> submenu);
}
