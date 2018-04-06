package in.cdac.ims.campus.site.serviceimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdac.db.campus.entity.SiteRegistrationDetail;
import in.cdac.ims.campus.site.dao.SiteRegistrationDao;
import in.cdac.ims.campus.site.daoimpl.SiteRegistrationDaoImpl;
import in.cdac.ims.campus.site.service.SiteRegistrationService;
import in.cdac.ims.util.entity.ResultDataMap;
@Service
@Transactional
public class SiteRegistrationServiceImpl implements SiteRegistrationService{

	
	@Autowired
	SiteRegistrationDao siteRegistrationDao;
	
	public ResultDataMap saveSiteDetails(SiteRegistrationDetail site) {
		return siteRegistrationDao.saveSiteDetails(site);
	}

	public boolean siteExist(SiteRegistrationDetail site) {
		
		return siteRegistrationDao.siteExist(site);
		
	}
}
