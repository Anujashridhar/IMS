package in.cdac.ims.program.daoimpl;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.cdac.db.program.entity.BranchMaster;
import in.cdac.ims.program.dao.BranchMasterDao;
import in.cdac.ims.util.entity.ResultDataMap;

@Repository

public class BranchMasterDaoImpl implements BranchMasterDao {

	@Autowired
	SessionFactory sessionFactory;
		
		
		public ResultDataMap saveNewBranch(BranchMaster bm) {
			
			Transaction tx=null;
			ResultDataMap rdm= new ResultDataMap();
			try
			{
				Session session = sessionFactory.getCurrentSession();
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
		     
				
			 Transaction tx = null;
		      try{
		    	  Session session=sessionFactory.getCurrentSession();
		        
		         String sql="SELECT branchId,branchName FROM BranchMaster where activeFlag='Y' ";
		          
		         Query query = session.createQuery(sql);
		         
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
}
