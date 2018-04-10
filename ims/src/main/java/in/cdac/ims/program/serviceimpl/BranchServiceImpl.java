package in.cdac.ims.program.serviceimpl;

import java.util.HashMap;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdac.db.program.entity.BranchMaster;
import in.cdac.ims.program.dao.BranchMasterDao;
import in.cdac.ims.program.service.BranchService;
import in.cdac.ims.util.entity.ResultDataMap;



@Service
@Transactional
public class BranchServiceImpl implements BranchService

{
 
	@Autowired
	BranchMasterDao branchDao;
	
	public ResultDataMap saveNewBranch(BranchMaster bm) {
		
		return branchDao.saveNewBranch(bm);
	}
	
	public HashMap<Integer, String> getBranchList() {
		
		return branchDao.getBranchList();
	}
}
