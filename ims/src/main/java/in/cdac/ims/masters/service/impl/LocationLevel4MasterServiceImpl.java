package in.cdac.ims.masters.service.impl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdac.db.masters.entity.MstLocationLevel4;
import in.cdac.ims.masters.jsp.dao.LocationLevel4MasterDao;
import in.cdac.ims.masters.service.LocationLevel4MasterService;
import in.cdac.ims.util.entity.ResultDataMap;

@Service
@Transactional

public class LocationLevel4MasterServiceImpl implements LocationLevel4MasterService{

	@Autowired
	LocationLevel4MasterDao locationLevel4MasterDao;

	public ResultDataMap saveNewLocLevel4(MstLocationLevel4 ms) {
		return locationLevel4MasterDao.saveNewLocLevel4(ms);
	}

	public ArrayList<String> getLocation4Details(Integer usr) {
		return locationLevel4MasterDao.getLocation4Details(usr);
	}
	
	
	

}
