package in.cdac.ims.masters.service;

import java.util.LinkedHashMap;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import in.cdac.db.masters.entity.MstCountry;
import in.cdac.ims.util.entity.ResultDataMap;

@Service
@Transactional
public interface CountryMasterService {

	public LinkedHashMap<Integer, String> getCountryList() ;
	public ResultDataMap saveNewCountry(MstCountry mc);
}
