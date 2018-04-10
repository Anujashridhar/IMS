package in.cdac.ims.program.dao;


import in.cdac.db.program.entity.ProgramMaster;
import in.cdac.db.program.entity.SubBranchMaster;
import in.cdac.ims.util.entity.MapObject;
import in.cdac.ims.util.entity.ResultDataMap;
import java.util.List;

public interface ProgramMasterDao {
	
	public ResultDataMap saveProgramDetails(ProgramMaster prgm);
}

/*package in.cdac.ims.program.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.cdac.ims.config.hibernate.HibernateUtil;
import in.cdac.ims.program.beans.db.ProgramMaster;
import in.cdac.ims.program.beans.db.SubBranchMaster;
import in.cdac.ims.util.beans.MapObject;
import in.cdac.ims.util.beans.ResultDataMap;

public class ProgramMasterDao {


public ResultDataMap saveProgramDetails(ProgramMaster prgm) {
	Session session=null;
	Transaction tx=null;
	ResultDataMap rdm= new ResultDataMap();
	try
	{
		session=HibernateUtil.openSession();
		tx=session.beginTransaction();
		prgm.setActiveFlag('Y');
		prgm.setEntryDate(new Date());
		prgm.setModifyDate(new Date());
		session.save(prgm);
		tx.commit();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
	 session.close();
	 session=null;
	}
	return rdm;
}
	
}
*/