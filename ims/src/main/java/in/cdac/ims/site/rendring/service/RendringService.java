package in.cdac.ims.site.rendring.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import in.cdac.ims.util.entity.ResultDataMap;
@Service
@Transactional
public interface RendringService {

	public ResultDataMap getRenderingData(String siteName);

}