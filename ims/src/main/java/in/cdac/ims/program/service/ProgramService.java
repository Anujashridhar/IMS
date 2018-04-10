package in.cdac.ims.program.service;

import in.cdac.db.program.entity.ProgramMaster;
import in.cdac.ims.util.entity.ResultDataMap;

public interface ProgramService {

	public ResultDataMap saveProgramDetails(ProgramMaster prgm);
}
