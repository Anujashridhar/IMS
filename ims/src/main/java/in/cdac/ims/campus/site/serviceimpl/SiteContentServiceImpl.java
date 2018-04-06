package in.cdac.ims.campus.site.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import in.cdac.db.campus.entity.DivDetails;
import in.cdac.ims.campus.entity.ImageForm;
import in.cdac.ims.campus.site.dao.SiteContentDao;
import in.cdac.ims.campus.site.daoimpl.SiteContentDaoImpl;
import in.cdac.ims.campus.site.service.SiteContentService;
import in.cdac.ims.campus.site.service.SiteService;
import in.cdac.ims.util.entity.ResultDataMap;
@Service
@Transactional
public class SiteContentServiceImpl implements SiteContentService {

	@Autowired
	SiteContentDao siteContentDao;
	
	@Autowired
	SiteService siteService;
	
	public ResultDataMap saveContentDetails(DivDetails divDtl, Integer userid) {
		
		return siteContentDao.saveContentDetails(divDtl, userid);
	}

	public Integer getNoOfDivs(Integer userid) {
		
		return siteContentDao.getNoOfDivs(userid);
	}

	public ArrayList<Integer> countDivs(Integer userid) {
		
		return siteContentDao.countDivs(userid);
	}

	public List<DivDetails> getContentData(Integer siteId) {
		
		return siteContentDao.getContentData(siteId);
	}

	public ResultDataMap updateContentDetails(DivDetails divDtl, Integer siteId, Integer divId) {
		
		return siteContentDao.updateContentDetails(divDtl, siteId, divId);
	}

	public ResultDataMap saveLogo(MultipartFile logoFile, Integer userId) {
		
		return siteContentDao.saveLogo(logoFile, userId, siteService.getSiteIdByAdminId(userId));
	}

	public ResultDataMap saveImages(ImageForm imageForm, Integer userId) {
		
		return siteContentDao.saveImages(imageForm, userId);
	}

}
