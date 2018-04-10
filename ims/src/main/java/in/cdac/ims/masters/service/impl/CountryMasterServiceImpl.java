package in.cdac.ims.masters.service.impl;

import java.util.LinkedHashMap;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import in.cdac.db.masters.entity.MstCountry;
import in.cdac.ims.masters.jsp.dao.CountryMasterDao;
import in.cdac.ims.masters.service.CountryMasterService;
import in.cdac.ims.util.entity.ResultDataMap;

@Service
@Transactional
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
