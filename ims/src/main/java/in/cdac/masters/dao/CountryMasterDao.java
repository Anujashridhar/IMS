package in.cdac.masters.dao;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.cdac.db.masters.entity.MstCountry;
import in.cdac.ims.util.entity.ResultDataMap;
@Repository
@Transactional
public class CountryMasterDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public LinkedHashMap<Integer, String> getCountryList() {
		LinkedHashMap<Integer, String> hs=new LinkedHashMap<Integer, String>();
		hs.put(0, "");
	     Session session=sessionFactory.getCurrentSession();
	     try{
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
	    	  
	      }
	      return hs;
	}
	

	public ResultDataMap saveNewCountry(MstCountry mc) {
		ResultDataMap rdm= new ResultDataMap();
		try
		{
			 Session session=sessionFactory.getCurrentSession();
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
