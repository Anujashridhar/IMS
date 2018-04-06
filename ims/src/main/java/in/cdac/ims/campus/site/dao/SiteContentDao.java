package in.cdac.ims.campus.site.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import in.cdac.db.campus.entity.DivDetails;
import in.cdac.ims.campus.entity.ImageForm;
import in.cdac.ims.util.entity.ResultDataMap;

public interface SiteContentDao {
	public ResultDataMap saveContentDetails(DivDetails divDtl, Integer userid);
	public Integer getNoOfDivs(Integer userid);
	public ArrayList<Integer> countDivs(Integer userid);
	public List<DivDetails> getContentData(Integer siteId);
	public ResultDataMap updateContentDetails(DivDetails divDtl, Integer siteId, Integer divId);
	public ResultDataMap saveLogo(MultipartFile logoFile, Integer userId, Integer siteIdByAdminId);
	public ResultDataMap saveImages(ImageForm imageForm, Integer userId);
}
