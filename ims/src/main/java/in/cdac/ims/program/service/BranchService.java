package in.cdac.ims.program.service;

import java.util.HashMap;

import in.cdac.db.program.entity.BranchMaster;
import in.cdac.ims.util.entity.ResultDataMap;

public interface BranchService {

	public ResultDataMap saveNewBranch(BranchMaster bm);
	public HashMap<Integer, String> getBranchList();
}
