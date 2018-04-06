/*package in.cdac.ims.masters.jsp.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.cdac.ims.config.hibernate.HibernateUtil;
import in.cdac.ims.masters.db.beans.MstLocationLevel1;
import in.cdac.ims.masters.db.beans.MstState;
import in.cdac.ims.util.beans.MapObject;
import in.cdac.ims.util.beans.ResultDataMap;

public class LocationLevel1MasterDao {

	public ResultDataMap saveNewLocLevel1(MstLocationLevel1 ms) {
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
	

	public List<MapObject> getLocationLevel1List(Integer countryId) {
		List<MapObject> datalist=new ArrayList<>();
		LinkedHashMap<String, String> hs=new LinkedHashMap<>();
		hs.put("0", "");
	     Session session=HibernateUtil.openSession();
		 Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	       
	         String sql="SELECT locLevel1Id,locLevel1Name FROM MstLocationLevel1 where activeFlag='Y' and countryId=? ";
	          
	          SQLQuery query = session.createSQLQuery(sql);
	          query.setParameter(0, countryId);
	           @SuppressWarnings("unchecked")
			  List<Object[]> rows = query.list();
			  Iterator<Object[]> itr=rows.iterator();
			  while (itr.hasNext()) {
				  Object[] obj =  itr.next();
				  MapObject map=new MapObject();
				  map.setIntegerKey((Integer)obj[0]);
				  map.setValue(obj[1].toString());
				  datalist.add(map);
				  //hs.put(obj[0].toString(),obj[1].toString());
			}
			  
	      }
	      catch(Exception e)
	      {
	    	  System.out.println(e);
	    	  e.printStackTrace();
	      }
	      finally {
	    	  session.close();
		         session=null;
	      }
	      return datalist;
	}


	public String getLocation1Details(Integer usr) {
		
		Session session=null;
		Transaction tx=null;
		String name=null;
		ResultDataMap rdm= new ResultDataMap();
		try
		{
			session=HibernateUtil.openSession();
			tx=session.beginTransaction();
			 String sql="SELECT locLevel1, 1 FROM SiteData where activeFlag='Y' and enteredBy= ? ";
	          
	          SQLQuery query = session.createSQLQuery(sql);
	          query.setParameter(0, usr);
	           @SuppressWarnings("unchecked")
			  List<Object[]> rows = query.list();
			  Iterator<Object[]> itr=rows.iterator();
			  while (itr.hasNext()) {
				  Object[] obj =  itr.next();
				name=obj[0].toString();				
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
	
public String getLocationHierarchy(Integer usr) {
		
		Session session=null;
		Transaction tx=null;
		String levels=null;
		ResultDataMap rdm= new ResultDataMap();
		try
		{
			session=HibernateUtil.openSession();
			tx=session.beginTransaction();
			 String sql="SELECT noOfHierarchyLevels, 1 FROM SiteData where activeFlag='Y' and enteredBy= ? ";
	          
	          SQLQuery query = session.createSQLQuery(sql);
	          query.setParameter(0, usr);
	           @SuppressWarnings("unchecked")
			  List<Object[]> rows = query.list();
			  Iterator<Object[]> itr=rows.iterator();
			  while (itr.hasNext()) {
				  Object[] obj =  itr.next();
				levels=obj[0].toString();				
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
		return levels;
	}
	
}
*/