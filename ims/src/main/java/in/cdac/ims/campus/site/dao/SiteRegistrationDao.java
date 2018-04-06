package in.cdac.ims.campus.site.dao;

import org.springframework.stereotype.Repository;

import in.cdac.db.campus.entity.SiteRegistrationDetail;
import in.cdac.ims.util.entity.ResultDataMap;
@Repository
public interface SiteRegistrationDao {
	public ResultDataMap saveSiteDetails(SiteRegistrationDetail site);
	public boolean siteExist(SiteRegistrationDetail site) ;
}
