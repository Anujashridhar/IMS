package in.cdac.ims.program.serviceimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdac.db.program.entity.ProgramMaster;
import in.cdac.ims.program.dao.ProgramMasterDao;
import in.cdac.ims.program.service.ProgramService;
import in.cdac.ims.util.entity.ResultDataMap;


@Service
@Transactional
public class ProgramServiceImpl implements ProgramService{

	@Autowired
	ProgramMasterDao programDao;
	
	public ResultDataMap saveProgramDetails(ProgramMaster prgm) {
		
		return programDao.saveProgramDetails(prgm);
	}

}
