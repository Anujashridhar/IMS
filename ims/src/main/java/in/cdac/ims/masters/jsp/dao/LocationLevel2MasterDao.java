package in.cdac.ims.masters.jsp.dao;

import java.util.ArrayList;
import java.util.List;

import in.cdac.db.masters.entity.MstLocationLevel1;
import in.cdac.db.masters.entity.MstLocationLevel2;
import in.cdac.ims.util.entity.MapObject;
import in.cdac.ims.util.entity.ResultDataMap;

public interface LocationLevel2MasterDao 

{
	
	public ResultDataMap saveNewLocLevel2(MstLocationLevel2 ms);
	public List<MapObject> getLocationLevel2List(Integer countryId, Integer locLevel1Id);
	public ArrayList<String> getLocation2Details(Integer usr);

	
}
