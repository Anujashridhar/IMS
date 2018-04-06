package in.cdac.ims.campus.site.daoimpl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import in.cdac.db.campus.entity.DivDetails;
import in.cdac.db.campus.entity.ImageDetails;
import in.cdac.db.campus.entity.SiteData;
import in.cdac.ims.campus.entity.ImageForm;
import in.cdac.ims.campus.site.dao.SiteContentDao;
import in.cdac.ims.campus.site.dao.SiteDao;
import in.cdac.ims.util.entity.ResultDataMap;
import in.cdac.ims.util.entity.Strings;
import in.cdac.util.UtilObjects;
@Repository
public class SiteContentDaoImpl implements SiteContentDao{

	@Autowired
	SiteDao siteDao;
	
	@Autowired
	SessionFactory sessionFactory;
	
	public ResultDataMap saveContentDetails(DivDetails divDtl, Integer userid) {
		Session session=null;
		String siteid=null;
		ResultDataMap rdm= new ResultDataMap();
	      try{
	    	  session=sessionFactory.getCurrentSession();
				
	         
	         String sql="SELECT siteId,1 FROM SiteData where activeFlag='Y' and enteredBy= ? ";
	          
	         @SuppressWarnings("unchecked")
			List<Object[]> rows = (List<Object[]>)session.createNativeQuery(sql).setParameter(1, userid).list();
	         
	          
			  Iterator<Object[]> itr=rows.iterator();
			  while (itr.hasNext()) {
				  Object[] obj =  itr.next();
				  siteid=obj[0].toString();
			  }
			  
			  divDtl.setSiteId(Integer.parseInt(siteid));
			  session.save(divDtl);
			 
	      }
	      catch(Exception e)
	      {
	    	  System.out.println(e);
	      }
	      
	      return rdm;
	}

	public Integer getNoOfDivs(Integer userid) {
		
		Session session=null;
		String noOdDIv=null;
		Integer i=0;
		ResultDataMap rdm= new ResultDataMap();
	      try{
	    	  session=sessionFactory.getCurrentSession();
				
	         
	         String sql="SELECT noOfDivs,1 FROM SiteData where activeFlag='Y' and enteredBy= ? ";
	          
	         @SuppressWarnings("unchecked")
			List<Object[]> rows = session.createNativeQuery(sql)
	        		 						.setParameter(1, userid)
	        		 						.list();
	         
	         
			  Iterator<Object[]> itr=rows.iterator();
			  while (itr.hasNext()) {
				  Object[] obj =  itr.next();
				  noOdDIv=obj[0].toString();
			  }
			  i=(Integer.parseInt(noOdDIv));
	      }
	      catch(Exception e)
	      {
	    	  System.out.println(e);
	      }
	      
	      return i;
	}

	
public ArrayList<Integer> countDivs(Integer userid) {
		
		ArrayList<Integer> ids = new ArrayList<Integer>();
		Session session=null;
			String count=null;
		String siteid=null;
		Integer i=0;
		ResultDataMap rdm= new ResultDataMap();
	      try{
	    	  session=sessionFactory.getCurrentSession();
				
	        
	         String sql="SELECT siteId,1 FROM SiteData where activeFlag='Y' and enteredBy= ? ";
	          
	         @SuppressWarnings("unchecked")
			List<Object[]> rows = session.createNativeQuery(sql)
						.setParameter(1, userid)
						.list();
	         		Iterator<Object[]> itr=rows.iterator();
			  while (itr.hasNext()) {
				  Object[] obj =  itr.next();
				  siteid=obj[0].toString();
			  }
	         
	         String sql1="SELECT count(*),1 FROM DivDetails where activeFlag='Y' and siteId= ? ";
	          
	         @SuppressWarnings("unchecked")
			List<Object[]> rows1 = session.createNativeQuery(sql1)
	         									.setParameter(1, Integer.parseInt(siteid))
	         									.list();
	  
			  Iterator<Object[]> itr1=rows1.iterator();
			  while (itr1.hasNext()) {
				  Object[] obj =  itr1.next();
				  count=obj[0].toString();
			  }
			  i=(Integer.parseInt(count));
			  ids.add(Integer.parseInt(siteid));
			  ids.add(Integer.parseInt(count));
	      }
	      catch(Exception e)
	      {
	    	  System.out.println(e);
	      }
	     
	      return ids;
	}

@SuppressWarnings("null")
public List<DivDetails> getContentData(Integer siteId) {
	
	Session session=null;
	Transaction tx=null;
	List<DivDetails> divList = new ArrayList<DivDetails>();
	try{
    	  session=sessionFactory.getCurrentSession();
			
          String sql1="SELECT divName,divContent,divId FROM DivDetails where activeFlag='Y' and siteId= ? ";
         
         @SuppressWarnings("unchecked")
		List<Object[]> rows1 = session.createNativeQuery(sql1)
					.setParameter(1, siteId)
					.list();
         	Iterator<Object[]> itr1=rows1.iterator();
		  while (itr1.hasNext()) {
			  Object[] obj =  itr1.next();
			  DivDetails dtl= new DivDetails();
			  dtl.setDivName(obj[0].toString());
			  dtl.setDivContent(obj[1].toString());
			  dtl.setDivId(Integer.parseInt(obj[2].toString()));
			  divList.add(dtl);
			}
    } 
     catch(Exception e)
     {
   	  System.out.println(e);
     }
     
    return divList;
}

public ResultDataMap updateContentDetails(DivDetails divDtl, Integer siteId, Integer divId) {
	Session session=null;
	Transaction tx=null;
	ResultDataMap rdm= new ResultDataMap();
      try{
    	  session=sessionFactory.getCurrentSession();
			
         
          String sql="update DivDetails set divName=:divName, divContent=:divContent, dateOfModification=:dom where activeFlag='Y' and siteId= :siteId and divId=:divId";
          
          		session.createNativeQuery(sql)
					          .setParameter("divName", divDtl.getDivName())
					          .setParameter("divContent", divDtl.getDivContent())
					          .setParameter("dom", new Date())
					          .setParameter("siteId", siteId)
					          .setParameter("divId",divId)
					          .executeUpdate();
							  
	  }
      catch(Exception e)
      {
    	  System.out.println(e);
      }
      
      return rdm;
}
public ResultDataMap saveImages(ImageDetails imageDetail) throws Exception {

	ResultDataMap result = new ResultDataMap();
	result.setStatus(false);
	Session session = null;
	try {
		session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		session.save(imageDetail);
		session.getTransaction().commit();
		result.setStatus(true);
		result.setMessage(Strings.savedSuccessfully);
	} catch (Exception e) {
		result.setStatus(false);
		result.setMessage(e.getMessage());
		e.printStackTrace();
	} finally {
		if (session != null) {
			session.close();
		}
	}
	return result;
}

public ResultDataMap saveImages(ImageForm imageForm, Integer userId) {
	ResultDataMap resultDataMap = new ResultDataMap();
	Session session = null;
	try {

		List<ImageDetails> imageList = imageForm.getImageList();
		if (imageList != null && !imageList.isEmpty()) {
			session = sessionFactory.getCurrentSession();
			Integer siteId = siteDao.getSiteByAdminId(userId).getSiteId();
			
			@SuppressWarnings("unchecked")
			List<ImageDetails> oldList= (List<ImageDetails>)session.createQuery("from ImageDetails where siteId=:siteId and activeFlag='Y'").setParameter("siteId", siteId).list();
			for (ImageDetails oldImageDetails : oldList) {
				if(!imageForm.getImageList().contains(oldImageDetails))
					{
						session.delete(oldImageDetails);
					}
				//session.evict(oldImageDetails);
			}
			
			for (ImageDetails imageDetails : imageList) {

				if (imageDetails == null) {
					continue;
				}else if(  imageDetails.getImageSequence()==null )
				{
					continue;
				}else if (imageDetails.getFile() == null 
																// || imageDetails.getImageId() == null 
																|| imageDetails.getFile().isEmpty()
																|| imageDetails.getFile().getSize()==0) {
					
					continue;
					
				} else if (imageDetails.getImageId() == null && imageDetails.getFile() != null
																	&& !imageDetails.getFile().isEmpty()
																	&& imageDetails.getFile().getSize()!=0) {
					
					String path = UtilObjects.usrhome + "/" + userId + "/" + siteId + "/slidingImage"
							+ imageDetails.getImageSequence() + ".jpg";
					File f = new File(path);
					f.getParentFile().mkdirs();

					imageDetails.getFile().transferTo(f);

					String dbpath = "image?path=%2F" + userId + "%2F" + siteId + "%2FslidingImage"
							+ imageDetails.getImageSequence() + ".jpg";
					System.out.println(dbpath);
					imageDetails.setImageUrl(dbpath);
					imageDetails.setActiveFlag('Y');
					imageDetails.setSiteId(siteId);
					imageDetails.setDateOfEntry(new Date());
					session.save(imageDetails);
					
				}else if (imageDetails.getImageId() != null && (imageDetails.getFile() == null 
															|| imageDetails.getFile().getSize()==0
															|| imageDetails.getFile().isEmpty())) {
					ImageDetails imageDetailsDB=session.get(ImageDetails.class, imageDetails.getImageId());
					imageDetailsDB.setImageSequence(imageDetails.getImageSequence());
					session.update(imageDetailsDB);
				
					
				}else if (imageDetails.getImageId() != null && (imageDetails.getFile() != null
																 && imageDetails.getFile().getSize()!=0
																&& !imageDetails.getFile().isEmpty())) {
					ImageDetails imageDetailsDB=session.get(ImageDetails.class, imageDetails.getImageId());
					String path = UtilObjects.usrhome + "/" + userId + "/" + siteId + "/slidingImage"
							+ imageDetails.getImageSequence() + ".jpg";
					File f = new File(path);
					f.getParentFile().mkdirs();

					imageDetails.getFile().transferTo(f);

					String dbpath = "image?path=%2F" + userId + "%2F" + siteId + "%2FslidingImage"
							+ imageDetails.getImageSequence() + ".jpg";
					System.out.println(dbpath);
					imageDetailsDB.setImageUrl(dbpath);
					imageDetailsDB.setActiveFlag('Y');
					imageDetailsDB.setSiteId(siteId);
					imageDetailsDB.setDateOfEntry(new Date());
					imageDetailsDB.setImageSequence(imageDetails.getImageSequence());
					session.update(imageDetailsDB);
					
				}
				
				
				
				
			}
			resultDataMap.setStatus(true);
			resultDataMap.setMessage(Strings.savedSuccessfully);
		} else {
			resultDataMap.setStatus(false);
			resultDataMap.setMessage(Strings.NothingToSave);
		}
	} catch (Exception e) {
		resultDataMap.setStatus(false);
		resultDataMap.setMessage(e.getMessage());
		e.printStackTrace();
	
	}
	return resultDataMap;
}

public ResultDataMap saveLogo(MultipartFile logoFile, Integer userId,Integer siteId) {
	ResultDataMap result = new ResultDataMap();
	Session session = null;
	try {
		//Integer siteId = new SiteService().getSiteIdByAdminId(userId);
		String path = UtilObjects.usrhome + "/" + userId + "/" + siteId + "/logo.jpg";
		File f = new File(path);
		f.getParentFile().mkdirs();

		logoFile.transferTo(f);

		String dbpath = "image?path=%2F" + userId + "%2F" + siteId + "%2Flogo.jpg";
		System.out.println(dbpath);

		session = sessionFactory.getCurrentSession();
		SiteData siteData = session.get(SiteData.class, siteId);
		siteData.setLogo(dbpath);
		session.merge(siteData);
		result.setStatus(true);
		result.setMessage(Strings.savedSuccessfully);
	} catch (Exception e) {
		result.setStatus(false);
		result.setMessage(e.getMessage());
		e.printStackTrace();
	
	}
	return result;
}
	
}