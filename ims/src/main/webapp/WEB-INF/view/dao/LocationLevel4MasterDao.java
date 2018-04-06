package in.cdac.ims.masters.jsp.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.cdac.ims.config.hibernate.HibernateUtil;
import in.cdac.ims.masters.db.beans.MstLocationLevel4;
import in.cdac.ims.util.beans.ResultDataMap;

public class LocationLevel4MasterDao {

	public ResultDataMap saveNewLocLevel4(MstLocationLevel4 ms) {
		Session session=null;
		Transaction tx=null;
		ResultDataMap rdm= new ResultDataMap();
		try
		{
			session=HibernateUtil.openSession();
			tx=session.beginTransaction();
			ms.setActiveFlag('Y');
			ms.setEntryDate(new Date());
			ms.setModifyDate(new Date());
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
	
public ArrayList<String> getLocation4Details(Integer usr) {
		
		ArrayList<String> name = new ArrayList<>();
		String loc1=null;
		String loc2=null;
		String loc3=null;
		String loc4=null;
		Session session=null;
		Transaction tx=null;
		try
		{
			session=HibernateUtil.openSession();
			tx=session.beginTransaction();
			 String sql="SELECT locLevel1, locLevel2, locLevel3, locLevel4 FROM SiteData where activeFlag='Y' and enteredBy= ? ";
	          
	          SQLQuery query = session.createSQLQuery(sql);
	          query.setParameter(0, usr);
	           @SuppressWarnings("unchecked")
			  List<Object[]> rows = query.list();
			  Iterator<Object[]> itr=rows.iterator();
			  while (itr.hasNext()) {
				  Object[] obj =  itr.next();
						loc1=obj[0].toString();
						loc2=obj[1].toString();
						loc3=obj[2].toString();
						loc4=obj[3].toString();
						name.add(loc1);
						name.add(loc2);
						name.add(loc3);
						name.add(loc4);
			}
		
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
		return name;
		
	}
}
