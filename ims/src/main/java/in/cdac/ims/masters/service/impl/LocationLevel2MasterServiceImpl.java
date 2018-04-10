package in.cdac.ims.masters.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdac.db.masters.entity.MstLocationLevel2;
import in.cdac.ims.masters.jsp.dao.LocationLevel2MasterDao;
import in.cdac.ims.masters.service.LocationLevel2MasterService;
import in.cdac.ims.util.entity.MapObject;
import in.cdac.ims.util.entity.ResultDataMap;

@Service
@Transactional
public class LocationLevel2MasterServiceImpl implements LocationLevel2MasterService {
	
	@Autowired
	LocationLevel2MasterDao locationLevel2MasterDao;
	
	public ResultDataMap saveNewLocLevel2(MstLocationLevel2 ms) {
		
		return locationLevel2MasterDao.saveNewLocLevel2(ms) ;
	}

	
	public List<MapObject> getLocationLevel2List(Integer countryId, Integer locLevel1Id) {
		
		return locationLevel2MasterDao.getLocationLevel2List(countryId,locLevel1Id);
	}

	
	public ArrayList<String> getLocation2Details(Integer usr) {
	
		return locationLevel2MasterDao.getLocation2Details(usr) ;
	}

}
