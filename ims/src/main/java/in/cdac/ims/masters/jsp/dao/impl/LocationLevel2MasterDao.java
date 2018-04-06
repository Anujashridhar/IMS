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
import in.cdac.ims.masters.db.beans.MstLocationLevel2;
import in.cdac.ims.masters.db.beans.MstState;
import in.cdac.ims.util.beans.MapObject;
import in.cdac.ims.util.beans.ResultDataMap;

public class LocationLevel2MasterDao {

	public ResultDataMap saveNewLocLevel2(MstLocationLevel2 ms) {
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
	

	public List<MapObject> getLocationLevel2List(Integer countryId, Integer locLevel1Id) {
		List<MapObject> datalist=new ArrayList<>();
		LinkedHashMap<String, String> hs=new LinkedHashMap<>();
		hs.put("0", "");
	     Session session=HibernateUtil.openSession();
		 Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	       
	         String sql="SELECT locLevel2Id,locLevel2Name FROM MstLocationLevel2 where activeFlag='Y' and countryId=? and locLevel1Id= ? ";
	          
	          SQLQuery query = session.createSQLQuery(sql);
	          query.setParameter(0, countryId);
	          query.setParameter(1, locLevel1Id);
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


	public ArrayList<String> getLocation2Details(Integer usr) {
		
		ArrayList<String> name = new ArrayList<>();
		String loc1=null;
		String loc2=null;
		Session session=null;
		Transaction tx=null;
		ResultDataMap rdm= new ResultDataMap();
		try
		{
			session=HibernateUtil.openSession();
			tx=session.beginTransaction();
			 String sql="SELECT locLevel1, locLevel2 FROM SiteData where activeFlag='Y' and enteredBy= ? ";
	          
	          SQLQuery query = session.createSQLQuery(sql);
	          query.setParameter(0, usr);
	           @SuppressWarnings("unchecked")
			  List<Object[]> rows = query.list();
			  Iterator<Object[]> itr=rows.iterator();
			  while (itr.hasNext()) {
				  Object[] obj =  itr.next();
						loc1=obj[0].toString();
						loc2=obj[1].toString();
						name.add(loc1);
						name.add(loc2);
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
*/