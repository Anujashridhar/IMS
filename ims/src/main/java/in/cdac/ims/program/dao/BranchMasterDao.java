package in.cdac.ims.program.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import in.cdac.ims.program.beans.db.BranchMaster;
import in.cdac.ims.util.entity.ResultDataMap;

public class BranchMasterDao {

@Autowired
SessionFactory sessionFactory;
	
	
	public ResultDataMap saveNewBranch(BranchMaster bm) {
		Session session=null;
		Transaction tx=null;
		ResultDataMap rdm= new ResultDataMap();
		try
		{
			session=sessionFactory.getCurrentSession();
				bm.setActiveFlag('Y');
			bm.setEntryDate(new Date());
			bm.setModifyDate(new Date());
			session.save(bm);
			
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

	public HashMap<Integer, String> getBranchList() {
		LinkedHashMap<Integer, String> hs=new LinkedHashMap<Integer, String>();
		hs.put(0, "");
	     Session session=sessionFactory.getCurrentSession();
			
		 Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	       
	         String sql="SELECT branchId,branchName FROM BranchMaster where activeFlag='Y' ";
	          
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
	
	
	
}
