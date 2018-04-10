package in.cdac.ims.program.service;

import in.cdac.ims.util.entity.ResultDataMap;
import java.util.List;

import in.cdac.db.program.entity.SubBranchMaster;
import in.cdac.ims.util.entity.MapObject;

public interface SubBranchService {
	
	public ResultDataMap saveSubBranch(SubBranchMaster subm);
	public List<MapObject> getSubBranchList(Integer branchId);
}
