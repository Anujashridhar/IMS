package in.cdac.ims.campus.site.daoimpl;

import java.math.BigInteger;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import in.cdac.db.auth.entity.User;
import in.cdac.db.auth.entity.UserRole;
import in.cdac.db.campus.entity.SiteData;
import in.cdac.db.campus.entity.SiteRegistrationDetail;
import in.cdac.ims.campus.site.dao.SiteRegistrationDao;
import in.cdac.ims.util.entity.Mail;
import in.cdac.ims.util.entity.ResultDataMap;
import in.cdac.ims.util.entity.Strings;
@Repository
public class SiteRegistrationDaoImpl implements SiteRegistrationDao{

	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public ResultDataMap saveSiteDetails(SiteRegistrationDetail site) {
		Session session=null;
		ResultDataMap rdm= new ResultDataMap();
		try{
		session=sessionFactory.getCurrentSession();
	
		session.save(site);
		User user=new User();
		user.setActiveFlag('Y');
		user.setDateofEntry(new Date());
		user.setDateOfModification(new Date());
		String password=RandomStringUtils.randomAlphanumeric(8);
		
		user.setPassword(passwordEncoder.encode(password));
		user.setUserEmail(site.getContactEmail());
		user.setUserContactNo(site.getContactNumber());
		user.setUserName(site.getName());
		user.setAddress(site.getAddress());
		user.setSiteId(site.getSiteId());
		user.setUserType(2);
		session.save(user);
		UserRole userRole=new UserRole();
		userRole.setUserId(user.getUserId());
		userRole.setRoleId(2);
		
		session.save(userRole);
		
		//save userID in admin Id
		site.setAdminId(user.getUserId());
		
		//save Site Data 
		SiteData siteData=new SiteData();
		siteData.setSiteId(site.getSiteId());
		siteData.setEnteredBy(user.getUserId());
		siteData.setActiveFlag('Y');
		site.setDateOfEntry(new Date());
		session.save(siteData);
		if(site.getSiteId()!=null)
		{
			rdm.setStatus(true);
			rdm.setMessage("Site Registered Successfully !!");
			new Mail().sendSimpleMail(user.getUserEmail(), " Site registered successfully your password is :"+password, "site Registered");
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rdm;

	}

	public boolean siteExist(SiteRegistrationDetail site) {
		BigInteger result=new BigInteger("0");
		Session session=null;
		try {
			session=sessionFactory.getCurrentSession();
			String query="SELECT count(*) FROM SiteRegistrationDetail where contactEmail=? or contactNumber=? or siteId=?";
			result=(BigInteger)session.createQuery(query)
					.setParameter(1, site.getContactEmail())
					.setParameter(2, site.getContactNumber())
					.setParameter(3, site.getSiteId())
					.uniqueResult();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(result.intValue()>0){return true;}else{return false;}
		
	}
	

}
