package in.cdac.ims.program.serviceimpl;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdac.db.program.entity.SubBranchMaster;
import in.cdac.ims.program.dao.SubBranchMasterDao;
import in.cdac.ims.program.service.SubBranchService;
import in.cdac.ims.util.entity.MapObject;
import in.cdac.ims.util.entity.ResultDataMap;

@Service
@Transactional
public  class SubBranchServiceImpl implements SubBranchService {
	
	@Autowired
	SubBranchMasterDao branchDao;

	public ResultDataMap saveSubBranch(SubBranchMaster subm) {
		return branchDao.saveSubBranch(subm);
	}

	
	public List<MapObject> getSubBranchList(Integer branchId) {
		return branchDao.getSubBranchList(branchId);
	}
	

}
