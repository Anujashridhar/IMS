/*package in.cdac.ims.masters.jsp.dao.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.cdac.ims.masters.db.beans.MstState;
import in.cdac.ims.config.hibernate.HibernateUtil;
import in.cdac.ims.util.beans.ResultDataMap;

public class StateMasterDao {

	
	
	public ResultDataMap saveNewState(MstState ms) {
		Session session=null;
		Transaction tx=null;
		ResultDataMap rdm= new ResultDataMap();
		try
		{
			session=HibernateUtil.openSession();
			tx=session.beginTransaction();
			ms.setActiveFlag('Y');
			ms.setEntryDate(new Date());
			session.save(ms);
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