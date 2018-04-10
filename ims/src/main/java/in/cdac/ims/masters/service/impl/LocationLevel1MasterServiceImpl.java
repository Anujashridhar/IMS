package in.cdac.ims.masters.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdac.db.masters.entity.MstLocationLevel1;
import in.cdac.ims.masters.jsp.dao.LocationLevel1MasterDao;
import in.cdac.ims.masters.service.LocationLevel1MasterService;
import in.cdac.ims.util.entity.MapObject;
import in.cdac.ims.util.entity.ResultDataMap;

@Service
@Transactional
public class LocationLevel1MasterServiceImpl implements LocationLevel1MasterService
{
	
	@Autowired
	LocationLevel1MasterDao locationLevel1MasterDao;
	
	public ResultDataMap saveNewLocLevel1(MstLocationLevel1 ms) {
		
		return locationLevel1MasterDao.saveNewLocLevel1(ms);
	}

	
	public List<MapObject> getLocationLevel1List(Integer countryId) {
	
		return locationLevel1MasterDao.getLocationLevel1List(countryId);
	}

	public String getLocation1Details(Integer usr) {
		
		return locationLevel1MasterDao.getLocation1Details(usr);
	}
	
	
}
