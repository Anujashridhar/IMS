package in.cdac.ims.program.daoimpl;

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

import in.cdac.db.program.entity.SubBranchMaster;
import in.cdac.ims.program.dao.SubBranchMasterDao;
import in.cdac.ims.util.entity.MapObject;
import in.cdac.ims.util.entity.ResultDataMap;


@Repository 

public class SubBranchDaoImpl implements SubBranchMasterDao {

	@Autowired
	SessionFactory sessionFactory;
		
	
	public List<MapObject> getSubBranchList(Integer branchId) {
		List<MapObject> datalist=new ArrayList<>();
		LinkedHashMap<String, String> hs=new LinkedHashMap<>();
		hs.put("0", "");
	     Transaction tx = null;
	      try{
	    	  Session session = sessionFactory.getCurrentSession();
	      
	         String sql="SELECT subBranchId,subBranchName FROM SubBranchMaster where activeFlag='Y' and branchId=? ";
	          
	         Query query = session.createQuery(sql);
	          query.setParameter(0, branchId);
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


public ResultDataMap saveSubBranch(SubBranchMaster subm) {
	Transaction tx=null;
	ResultDataMap rdm= new ResultDataMap();
	try
	{
		Session session = sessionFactory.getCurrentSession();
		subm.setActiveFlag('Y');
		subm.setEntryDate(new Date());
		subm.setModifyDate(new Date());
		session.save(subm);
	
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


/*public String getLocationHierarchy(Integer usr) {

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
*/


}
