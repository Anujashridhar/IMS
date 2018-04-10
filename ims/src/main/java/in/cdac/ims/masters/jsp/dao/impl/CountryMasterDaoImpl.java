package in.cdac.ims.masters.jsp.dao.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.cdac.db.masters.entity.MstCountry;
import in.cdac.ims.masters.jsp.dao.CountryMasterDao;
import in.cdac.ims.util.entity.ResultDataMap;
@Repository
public class CountryMasterDaoImpl implements CountryMasterDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public LinkedHashMap<Integer, String> getCountryList() {
		LinkedHashMap<Integer, String> hs=new LinkedHashMap<Integer, String>();
		hs.put(0, "");
	     Session session=sessionFactory.getCurrentSession();
		 Transaction tx = null;
	      try{
	        String sql="SELECT countryId,countryName FROM MstCountry where activeFlag='Y' ";
	          
	          Query query= session.createQuery(sql);
	         
	           @SuppressWarnings("unchecked")
			  List<Object[]> rows = query.list();
			  Iterator<Object[]> itr=rows.iterator();
			  while (itr.hasNext()) {
				Object[] obj =  itr.next();
				hs.put(Integer.valueOf(obj[0].toString()),obj[1].toString());
			}
			  
	      }
	      catch(Exception e)
	      {
	    	  System.out.println(e);
	      }
	      finally {
	    	 
	      }
	      return hs;
	}
	

	public ResultDataMap saveNewCountry(MstCountry mc) {
		Session session=null;
		Transaction tx=null;
		ResultDataMap rdm= new ResultDataMap();
		try
		{
			 session=sessionFactory.getCurrentSession();
			mc.setActiveFlag('Y');
			mc.setEntryDate(new Date());
			session.save(mc);
	
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
