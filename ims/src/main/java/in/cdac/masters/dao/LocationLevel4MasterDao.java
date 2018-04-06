package in.cdac.masters.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.cdac.db.masters.entity.MstLocationLevel4;
import in.cdac.ims.util.entity.ResultDataMap;
@Repository
@Transactional
public class LocationLevel4MasterDao {

	@Autowired
	SessionFactory sessionFactory;
	public ResultDataMap saveNewLocLevel4(MstLocationLevel4 ms) {
		Session session=null;
			ResultDataMap rdm= new ResultDataMap();
		try
		{
			session=sessionFactory.getCurrentSession();
			ms.setActiveFlag('Y');
			ms.setEntryDate(new Date());
			ms.setModifyDate(new Date());
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
	
public ArrayList<String> getLocation4Details(Integer usr) {
		
		ArrayList<String> name = new ArrayList<String>();
		String loc1=null;
		String loc2=null;
		String loc3=null;
		String loc4=null;
		Session session=null;
		Transaction tx=null;
		try
		{
			session=sessionFactory.getCurrentSession();
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


		}
		return name;
		
	}
}
