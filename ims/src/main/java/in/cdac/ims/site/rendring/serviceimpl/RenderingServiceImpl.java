package in.cdac.ims.site.rendring.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdac.ims.site.rendring.dao.RenderDataDao;
import in.cdac.ims.site.rendring.service.RendringService;
import in.cdac.ims.util.entity.ResultDataMap;
@Service
public class RenderingServiceImpl implements RendringService {
	@Autowired
	RenderDataDao renderDataDao; 
	public ResultDataMap getRenderingData(String siteName) {
		return renderDataDao.getindexRendringData(siteName);
	//	return new RenderDataDao().getindexRendringData(siteName);
		
	}
}
