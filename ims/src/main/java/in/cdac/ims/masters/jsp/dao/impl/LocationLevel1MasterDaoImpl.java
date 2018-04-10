package in.cdac.ims.masters.jsp.dao.impl;

import java.util.ArrayList;
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

import in.cdac.db.masters.entity.MstLocationLevel1;
import in.cdac.ims.masters.jsp.dao.LocationLevel1MasterDao;
import in.cdac.ims.util.entity.MapObject;
import in.cdac.ims.util.entity.ResultDataMap;

@Repository
public class LocationLevel1MasterDaoImpl implements LocationLevel1MasterDao{

	@Autowired
	SessionFactory sessionFactory; 
	
	public ResultDataMap saveNewLocLevel1(MstLocationLevel1 ms) {
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
	

	public List<MapObject> getLocationLevel1List(Integer countryId) {
		List<MapObject> datalist=new ArrayList<>();
		LinkedHashMap<String, String> hs=new LinkedHashMap<>();
		hs.put("0", "");
		Session session=sessionFactory.getCurrentSession();
		 Transaction tx = null;
	      try{
	         String sql="SELECT locLevel1Id,locLevel1Name FROM MstLocationLevel1 where activeFlag='Y' and countryId=? ";
	          
	          Query query = session.createQuery(sql);
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
	    
	      }
	      return datalist;
	}


	public String getLocation1Details(Integer usr) {
		
		Transaction tx=null;
		String name=null;
		ResultDataMap rdm= new ResultDataMap();
		try
		{
			Session session=sessionFactory.getCurrentSession();
			String sql="SELECT locLevel1, 1 FROM SiteData where activeFlag='Y' and enteredBy= ? ";
	          
	         Query query = session.createQuery(sql);
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
		
		}
		return name;
	}
	
public String getLocationHierarchy(Integer usr) {
		
		Transaction tx=null;
		String levels=null;
		ResultDataMap rdm= new ResultDataMap();
		try
		{
			Session session=sessionFactory.getCurrentSession();
			tx=session.beginTransaction();
			 String sql="SELECT noOfHierarchyLevels, 1 FROM SiteData where activeFlag='Y' and enteredBy= ? ";
	          
	          Query query = session.createQuery(sql);
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
		 
		}
		return levels;
	}
	
}
