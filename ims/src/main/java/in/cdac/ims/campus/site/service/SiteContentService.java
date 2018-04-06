package in.cdac.ims.campus.site.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import in.cdac.db.campus.entity.DivDetails;
import in.cdac.ims.campus.entity.ImageForm;
import in.cdac.ims.util.entity.ResultDataMap;


public interface SiteContentService {

	public ResultDataMap saveContentDetails(DivDetails divDtl, Integer userid);
	public Integer getNoOfDivs(Integer userid);
	public ArrayList<Integer> countDivs(Integer userid);
	public List<DivDetails> getContentData(Integer siteId);
	public ResultDataMap updateContentDetails(DivDetails divDtl, Integer siteId, Integer divId);
	public ResultDataMap saveLogo(MultipartFile logoFile, Integer userId);
	public ResultDataMap saveImages(ImageForm imageForm, Integer userId);
	
}
