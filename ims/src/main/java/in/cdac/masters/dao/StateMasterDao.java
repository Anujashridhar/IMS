package in.cdac.masters.dao;

import java.util.Date;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.cdac.db.masters.entity.MstState;
import in.cdac.ims.util.entity.ResultDataMap;
@Repository
@Transactional
public class StateMasterDao {

	@Autowired
	SessionFactory sessionFactory;
	
	
	public ResultDataMap saveNewState(MstState ms) {
		Session session=null;
		Transaction tx=null;
		ResultDataMap rdm= new ResultDataMap();
		try
		{
			session=sessionFactory.getCurrentSession();
			ms.setActiveFlag('Y');
			ms.setEntryDate(new Date());
			session.save(ms);
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
