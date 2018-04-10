package in.cdac.ims.masters.service;

import java.util.ArrayList;

import in.cdac.db.masters.entity.MstLocationLevel4;
import in.cdac.ims.util.entity.ResultDataMap;

public interface LocationLevel4MasterService {

	public ResultDataMap saveNewLocLevel4(MstLocationLevel4 ms);
	public ArrayList<String> getLocation4Details(Integer usr);
	
}
