package in.cdac.ims.campus.site.dao;

import org.springframework.stereotype.Repository;

import in.cdac.db.campus.entity.SiteData;
import in.cdac.ims.campus.entity.Site;
import in.cdac.ims.util.entity.ResultDataMap;
@Repository
public interface SiteDao {
	public Site getSiteByAdminId(Integer adminId);
	public Integer getSiteIdByAdminId(Integer adminId);
	public ResultDataMap saveSiteTemplateSetup(Site site, Integer adminId) ;
	public ResultDataMap saveSiteData(SiteData site);
}
