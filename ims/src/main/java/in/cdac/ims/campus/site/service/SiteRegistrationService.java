package in.cdac.ims.campus.site.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import in.cdac.db.campus.entity.SiteRegistrationDetail;
import in.cdac.ims.util.entity.ResultDataMap;
@Service
@Transactional
public interface SiteRegistrationService {
	public ResultDataMap saveSiteDetails(SiteRegistrationDetail site) ;
	public boolean siteExist(SiteRegistrationDetail site) ;
}
