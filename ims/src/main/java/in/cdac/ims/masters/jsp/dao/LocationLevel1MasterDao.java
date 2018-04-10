package in.cdac.ims.masters.jsp.dao;

import java.util.List;

import in.cdac.db.masters.entity.MstLocationLevel1;
import in.cdac.ims.util.entity.MapObject;
import in.cdac.ims.util.entity.ResultDataMap;

public interface LocationLevel1MasterDao {

	public ResultDataMap saveNewLocLevel1(MstLocationLevel1 ms);
	public List<MapObject> getLocationLevel1List(Integer countryId);
	public String getLocation1Details(Integer usr);

}
