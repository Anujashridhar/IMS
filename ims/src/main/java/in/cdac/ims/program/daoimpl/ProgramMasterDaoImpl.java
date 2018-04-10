package in.cdac.ims.program.daoimpl;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.cdac.db.program.entity.ProgramMaster;
import in.cdac.ims.program.dao.ProgramMasterDao;
import in.cdac.ims.util.entity.ResultDataMap;
import in.cdac.ims.util.entity.Strings;

@Repository
public class ProgramMasterDaoImpl implements ProgramMasterDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	public ResultDataMap saveProgramDetails(ProgramMaster prgm) {
		Transaction tx=null;
		ResultDataMap rdm= new ResultDataMap();
		try
		{
			 Session session=sessionFactory.getCurrentSession();
			prgm.setActiveFlag('Y');
			prgm.setEntryDate(new Date());
			prgm.setModifyDate(new Date());
			session.save(prgm);
			rdm.setMessage(Strings.savedSuccessfully);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
		 
		}
		return rdm;
	}

}
