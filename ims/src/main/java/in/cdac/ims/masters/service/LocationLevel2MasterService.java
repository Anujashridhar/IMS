package in.cdac.ims.masters.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import in.cdac.db.masters.entity.MstLocationLevel2;
import in.cdac.ims.util.entity.MapObject;
import in.cdac.ims.util.entity.ResultDataMap;


public interface LocationLevel2MasterService {
	
	
	public ResultDataMap saveNewLocLevel2(MstLocationLevel2 ms);
	public List<MapObject> getLocationLevel2List(Integer countryId, Integer locLevel1Id);
	public ArrayList<String> getLocation2Details(Integer usr);

}
