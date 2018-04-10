package in.cdac.ims.masters.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdac.db.masters.entity.MstLocationLevel3;
import in.cdac.ims.masters.jsp.dao.LocationLevel3MasterDao;
import in.cdac.ims.masters.service.LocationLevel3MasterService;
import in.cdac.ims.util.entity.MapObject;
import in.cdac.ims.util.entity.ResultDataMap;

@Service
@Transactional

public class LocationLevel3MasterServiceImpl implements LocationLevel3MasterService{

	@Autowired
	LocationLevel3MasterDao locationLevel3MasterDao;
	
	
	public ResultDataMap saveNewLocLevel3(MstLocationLevel3 ms) {
		
		return locationLevel3MasterDao.saveNewLocLevel3(ms);
	}


	public List<MapObject> getLocationLevel2List(Integer countryId, Integer locLevel1Id, Integer locLevel2Id) {
		
		return locationLevel3MasterDao.getLocationLevel2List(countryId, locLevel1Id, locLevel2Id);
	}

	
	public ArrayList<String> getLocation3Details(Integer usr) {
		
		return locationLevel3MasterDao.getLocation3Details(usr);
	}

}
