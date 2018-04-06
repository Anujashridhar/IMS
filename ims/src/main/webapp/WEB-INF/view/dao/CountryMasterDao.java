package in.cdac.ims.masters.jsp.dao;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.cdac.ims.masters.db.beans.MstCountry;
import in.cdac.ims.config.hibernate.HibernateUtil;
import in.cdac.ims.util.beans.ResultDataMap;

public class CountryMasterDao {

	
	public LinkedHashMap<Integer, String> getCountryList() {
		LinkedHashMap<Integer, String> hs=new LinkedHashMap<>();
		hs.put(0, "");
	     Session session=HibernateUtil.openSession();
		 Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	       
	         String sql="SELECT countryId,countryName FROM MstCountry where activeFlag='Y' ";
	          
	          SQLQuery query = session.createSQLQuery(sql);
	         
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
	    	  session.close();
		         session=null;
	      }
	      return hs;
	}
	

	public ResultDataMap saveNewCountry(MstCountry mc) {
		Session session=null;
		Transaction tx=null;
		ResultDataMap rdm= new ResultDataMap();
		try
		{
			session=HibernateUtil.openSession();
			tx=session.beginTransaction();
			mc.setActiveFlag('Y');
			mc.setEntryDate(new Date());
			session.save(mc);
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
