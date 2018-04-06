package in.cdac.ims.masters.service.impl;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.cdac.db.masters.entity.MstCountry;
import in.cdac.ims.masters.jsp.dao.CountryMasterDao;
import in.cdac.ims.masters.service.CountryMasterService;
import in.cdac.ims.util.entity.ResultDataMap;
@Repository
public class CountryMasterServiceImpl implements CountryMasterService {
	@Autowired 
	CountryMasterDao countryMatserDao;

	public LinkedHashMap<Integer, String> getCountryList() {
		
		return countryMatserDao.getCountryList();
	}

	public ResultDataMap saveNewCountry(MstCountry mc) {
		
		return countryMatserDao.saveNewCountry(mc);
	}
	
}
