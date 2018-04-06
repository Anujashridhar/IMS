package in.cdac.ims.masters.jsp.dao;

import java.util.LinkedHashMap;

import org.springframework.stereotype.Repository;

import in.cdac.db.masters.entity.MstCountry;
import in.cdac.ims.util.entity.ResultDataMap;


@Repository
public interface CountryMasterDao {
	public LinkedHashMap<Integer, String> getCountryList() ;
	public ResultDataMap saveNewCountry(MstCountry mc);
}
