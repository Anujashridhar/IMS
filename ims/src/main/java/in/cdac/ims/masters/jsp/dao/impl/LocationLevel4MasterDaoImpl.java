package in.cdac.ims.masters.jsp.dao.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.cdac.db.masters.entity.MstLocationLevel4;
import in.cdac.ims.masters.jsp.dao.LocationLevel4MasterDao;
import in.cdac.ims.util.entity.ResultDataMap;



@Repository

public class LocationLevel4MasterDaoImpl implements LocationLevel4MasterDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public ResultDataMap saveNewLocLevel4(MstLocationLevel4 ms) {
		Transaction tx=null;
		ResultDataMap rdm= new ResultDataMap();
		try
		{
			Session session=sessionFactory.getCurrentSession();
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
		
		ArrayList<String> name = new ArrayList<>();
		String loc1=null;
		String loc2=null;
		String loc3=null;
		String loc4=null;
		Transaction tx=null;
		try
		{
			String sql="SELECT locLevel1, locLevel2, locLevel3, locLevel4 FROM SiteData where activeFlag='Y' and enteredBy= ? ";
			Session session=sessionFactory.getCurrentSession();
	         Query query = session.createQuery(sql);
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
