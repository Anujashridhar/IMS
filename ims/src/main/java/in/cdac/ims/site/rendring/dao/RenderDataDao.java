package in.cdac.ims.site.rendring.dao;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import in.cdac.db.campus.entity.SiteData;
import in.cdac.ims.campus.entity.Site;
import in.cdac.ims.util.entity.ResultDataMap;
@Component
@Repository
public interface RenderDataDao {
	public ResultDataMap getindexRendringData(String siteName);
	public Object getSiteIdByUrlName(String siteName, Session session) throws Exception ;
}