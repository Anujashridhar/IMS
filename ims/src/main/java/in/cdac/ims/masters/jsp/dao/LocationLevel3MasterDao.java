package in.cdac.ims.masters.jsp.dao;

import java.util.ArrayList;
import java.util.List;

import in.cdac.db.masters.entity.MstLocationLevel3;
import in.cdac.ims.util.entity.MapObject;
import in.cdac.ims.util.entity.ResultDataMap;

public interface LocationLevel3MasterDao {

	
	public ResultDataMap saveNewLocLevel3(MstLocationLevel3 ms);
	public List<MapObject> getLocationLevel2List(Integer countryId, Integer locLevel1Id, Integer locLevel2Id);
	public ArrayList<String> getLocation3Details(Integer usr);

}
