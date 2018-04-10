package in.cdac.ims.masters.jsp.dao.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.cdac.db.masters.entity.MstLocationLevel3;
import in.cdac.ims.masters.jsp.dao.LocationLevel3MasterDao;
import in.cdac.ims.util.entity.MapObject;
import in.cdac.ims.util.entity.RequestDataMap;
import in.cdac.ims.util.entity.ResultDataMap;

@Repository
public class LocationLevel3MasterDaoImpl implements LocationLevel3MasterDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public ResultDataMap saveNewLocLevel3(MstLocationLevel3 ms) {
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
	

	public List<MapObject> getLocationLevel2List(Integer countryId, Integer locLevel1Id, Integer locLevel2Id) {
		List<MapObject> datalist=new ArrayList<>();
		LinkedHashMap<String, String> hs=new LinkedHashMap<>();
		hs.put("0", "");
	     Transaction tx = null;
	      try{
	    	  Session session=sessionFactory.getCurrentSession();
	         String sql="SELECT locLevel3Id,locLevel3Name FROM MstLocationLevel3 where activeFlag='Y' and countryId= ? and locLevel1Id= ? and locLevel2Id= ? ";
	          
	          Query query = session.createQuery(sql);
	          query.setParameter(0, countryId);
	          query.setParameter(1, locLevel1Id);
	          query.setParameter(2, locLevel2Id);
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


	public ArrayList<String> getLocation3Details(Integer usr) {
		
		ArrayList<String> name = new ArrayList<>();
		String loc1=null;
		String loc2=null;
		String loc3=null;
		Transaction tx=null;
		RequestDataMap rdm= new RequestDataMap();
		try
		{
			String sql="SELECT locLevel1, locLevel2, locLevel3 FROM SiteData where activeFlag='Y' and enteredBy= ? ";
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
						name.add(loc1);
						name.add(loc2);
						name.add(loc3);
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