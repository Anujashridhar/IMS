package in.cdac.ims.site.rendring.daoimpl;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.cdac.db.campus.entity.SiteData;
import in.cdac.ims.campus.entity.Site;
import in.cdac.ims.site.rendring.dao.RenderDataDao;
import in.cdac.ims.util.entity.ResultDataMap;
@Repository
public class RenderDataDaoImpl implements RenderDataDao {

	@Autowired
	 SessionFactory sessionFactory;

	public ResultDataMap getindexRendringData(String siteName) {
		 ResultDataMap result=new ResultDataMap();
		Session session=null;
		ResultDataMap rdm= new ResultDataMap();
		try{
		session=sessionFactory.getCurrentSession();
		Site site=new Site();
		Integer siteId=(Integer)getSiteIdByUrlName(siteName,session);
		
		site.setSiteData(session.get(SiteData.class,siteId ));
		site.setMenuDetails(session.createQuery("from MenuDetails where siteId=? and activeFlag='Y'").setParameter(0, siteId).list());
		site.setSubmenu(session.createQuery("from SubMenuDetails where siteId=? and activeFlag='Y'").setParameter(0, siteId).list());
		site.setImageList(session.createQuery("from ImageDetails where siteId=? and activeFlag='Y'").setParameter(0, siteId).list());
		site.setDivDetails(session.createQuery("from DivDetails where siteId=? and activeFlag='Y' order by divId" ).setParameter(0, siteId).list());
			
		
		result.setStatus(true);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("site", site);
		result.setData(map);
		}catch(Exception e)
		{  
		result.setStatus(false);
		result.setMessage(e.getMessage());
		e.printStackTrace();
	}finally{
		
	}
		return result;
	}

	public Object getSiteIdByUrlName(String siteName,Session session) throws Exception{
		return session.createQuery("Select siteId from SiteData where urlName=? and activeFlag='Y'")
				.setParameter(0, siteName)
				.uniqueResult();
		
	}

}
