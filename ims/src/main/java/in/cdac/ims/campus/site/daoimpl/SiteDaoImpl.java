package in.cdac.ims.campus.site.daoimpl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.cdac.db.campus.entity.MenuDetails;
import in.cdac.db.campus.entity.SiteData;
import in.cdac.db.campus.entity.SiteRegistrationDetail;
import in.cdac.db.campus.entity.SubMenuDetails;
import in.cdac.ims.campus.entity.Site;
import in.cdac.ims.campus.site.dao.SiteDao;
import in.cdac.ims.util.entity.ResultDataMap;
import in.cdac.ims.util.entity.Strings;
@Repository
public class SiteDaoImpl implements SiteDao{

	
	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public Site getSiteByAdminId(Integer adminId) {
		System.out.println("adminId" + adminId);
		Site site = new Site();
		SiteRegistrationDetail siteRegistraionDetail = null;
		Integer siteId = 0;
		try {
			Session session =sessionFactory.getCurrentSession();
			siteRegistraionDetail = (SiteRegistrationDetail) session
					.createQuery("from SiteRegistrationDetail where adminId=?").setParameter(0, adminId).uniqueResult();
			site.setSiteRegistraionDetail(siteRegistraionDetail);
			siteId = siteRegistraionDetail.getSiteId();
			site.setSiteId(siteId);
			site.setSiteData(session.get(SiteData.class, siteId));
			site.setMenuDetails(session.createQuery("from MenuDetails where siteId=:siteId and activeFlag='Y'")
					.setParameter("siteId", siteId).list());
			site.setSubmenu(session.createQuery("from SubMenuDetails where siteId=:siteId and activeFlag='Y'")
					.setParameter("siteId", siteId).list());
			site.setImageList(session.createQuery("from ImageDetails where siteId=:siteId and activeFlag='Y'")
					.setParameter("siteId", siteId).list());
			site.setDivDetails(session.createQuery("from DivDetails where siteId=:siteId and activeFlag='Y'")
					.setParameter("siteId", siteId).list());
			// site.setTemplateDetails(session.createQuery("from TemplateDetails
			// where siteId=?").setParameter(0, siteId).list());
			System.out.println("site fetched " + site);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return site;
	}

	public Integer getSiteIdByAdminId(Integer adminId) {
		System.out.println("adminId" + adminId);

		Integer siteId = 0;
		try {
			Session session = sessionFactory.getCurrentSession();
			siteId = (Integer) session.createQuery("select s.siteId from SiteRegistrationDetail s where s.adminId=:adminId")
					.setParameter("adminId", adminId).uniqueResult();

			System.out.println("site fetched " + siteId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return siteId;
	}

	public ResultDataMap saveSiteTemplateSetup(Site site, Integer adminId) {
		Integer siteId = getSiteIdByAdminId(adminId);
		ResultDataMap result = new ResultDataMap();
		result.setStatus(false);
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			session.createQuery("delete from MenuDetails where siteId=:siteId").setParameter("siteId", siteId).executeUpdate();
			session.createQuery("delete from SubMenuDetails where siteId=:siteId").setParameter("siteId", siteId).executeUpdate();
			for (MenuDetails menu : site.getMenuDetails()) {
				if (menu != null && menu.getMenuName() != null && !menu.getMenuName().trim().equals("")) {
					Integer menuId = menu.getMenuId();
					menu.setActiveFlag('Y');
					menu.setDateOfEntry(new Date());
					menu.setDateOfModification(new Date());
					menu.setParentId(0);
					menu.setSiteId(siteId);
					session.save(menu);
					if (site.getSubmenu() != null && !site.getSubmenu().isEmpty()) {

						for (SubMenuDetails submenu : site.getSubmenu()) {
							if (submenu != null && submenu.getParentId() != null && submenu.getSubMenuName() != null
									&& !submenu.getSubMenuName().trim().equals("")
									&& submenu.getParentId().equals(menuId)) {
								SubMenuDetails csubmenu = new SubMenuDetails();

								csubmenu.setParentId(menu.getMenuId());
								csubmenu.setActiveFlag('Y');
								csubmenu.setDateOfEntry(new Date());
								csubmenu.setDateOfModification(new Date());
								csubmenu.setSiteId(siteId);
								csubmenu.setSubMenuName(submenu.getSubMenuName());
								session.save(csubmenu);
							}
						}
					}
				}
			}
			site.getSiteData().setSiteId(siteId);
			  
			  SiteData siteData=session.get(SiteData.class,
			  site.getSiteData().getSiteId()); siteData.setDateOfModification(new
			  Date()); siteData.setLocLevel1(site.getSiteData().getLocLevel1());
			  siteData.setLocLevel2(site.getSiteData().getLocLevel2());
			  siteData.setLocLevel3(site.getSiteData().getLocLevel3());
			  siteData.setLocLevel4(site.getSiteData().getLocLevel4());
			  siteData.setName(site.getSiteData().getName());
			  siteData.setUrlName(site.getSiteData().getUrlName());
			  siteData.setNoOfDivs(site.getSiteData().getNoOfDivs());
			  siteData.setNoOfHierarchyLevels(site.getSiteData().getNoOfHierarchyLevels());
			  
			 session.update(siteData);
			  
			result.setStatus(true);
			result.setMessage(Strings.savedSuccessfully);
			System.out.println("saved " + site);
		} catch (Exception e) {
			e.printStackTrace();
		} 

		return result;

	}

	/*
	 * public ResultDataMap saveSiteTemplateSetup(Site site, Integer adminId) {
	 * 
	 * Integer siteId=getSiteIdByAdminId(adminId); ResultDataMap result=new
	 * ResultDataMap(); result.setStatus(false); try{ Session
	 * session=HibernateUtil.openSession(); session.getTransaction().begin();
	 * 
	 * List<MenuDetails> list=site.getMenuDetails(); MenuDetails
	 * lastMenuDetails=null;
	 * 
	 * for (MenuDetails menuDetails : list) {
	 * if(!menuDetails.getMenuName().trim().equals("")) {
	 * menuDetails.setDateOfModification(new Date());
	 * menuDetails.setSiteId(siteId);
	 * if(menuDetails.getMenuName().contains("==>>")){ continue; }
	 * if(menuDetails.getMenuId()!=null && menuDetails.getMenuId()>0 ) {
	 * MenuDetails dbMenuDetails=session.get(MenuDetails.class,
	 * menuDetails.getMenuId()); dbMenuDetails.setDateOfModification(new
	 * Date()); dbMenuDetails.setMenuName(menuDetails.getMenuName());
	 * 
	 * session.merge(dbMenuDetails); lastMenuDetails=menuDetails;
	 * 
	 * }else if(menuDetails.getMenuId()!=null && menuDetails.getMenuId()<0 &&
	 * menuDetails.getParentId().equals(0)){ Integer
	 * oldParentId=menuDetails.getMenuId(); menuDetails.setMenuId(null);
	 * menuDetails.setActiveFlag('Y'); menuDetails.setDateOfEntry(new Date());
	 * session.save(menuDetails);
	 * setParentIds(list,oldParentId,menuDetails.getMenuId());
	 * lastMenuDetails=menuDetails; }else if(lastMenuDetails!=null ) {
	 * menuDetails.setActiveFlag('Y');
	 * //menuDetails.setParentId(lastMenuDetails.getMenuId());
	 * session.save(menuDetails); }else{ throw new Exception("invalid submenu");
	 * }
	 * 
	 * } } site.getSiteData().setSiteId(siteId);
	 * 
	 * SiteData siteData=session.get(SiteData.class,
	 * site.getSiteData().getSiteId()); siteData.setDateOfModification(new
	 * Date()); siteData.setLocLevel1(site.getSiteData().getLocLevel1());
	 * siteData.setLocLevel2(site.getSiteData().getLocLevel2());
	 * siteData.setLocLevel3(site.getSiteData().getLocLevel3());
	 * siteData.setLocLevel4(site.getSiteData().getLocLevel4());
	 * siteData.setName(site.getSiteData().getName());
	 * siteData.setUrlName(site.getSiteData().getUrlName());
	 * siteData.setNoOfDivs(site.getSiteData().getNoOfDivs());
	 * siteData.setNoOfHierarchyLevels(site.getSiteData().getNoOfHierarchyLevels
	 * ());
	 * 
	 * session.update(siteData);
	 * 
	 * 
	 * session.getTransaction().commit(); result.setStatus(true);
	 * result.setMessage(Strings.savedSuccessfully); }catch(Exception e) {
	 * result.setMessage(e.getMessage()); e.printStackTrace(); }finally{
	 * 
	 * } return result; }
	 * 
	 * 
	 */

	private void setParentIds(List<MenuDetails> list, Integer oldParentId, Integer newParentId) {
		for (MenuDetails menuDetails : list) {
			if (menuDetails.getParentId().equals(oldParentId)) {
				menuDetails.setParentId(newParentId);
			}
		}
	}

	public ResultDataMap saveSiteData(SiteData site) {
		Session session = null;
		Transaction tx = null;
		ResultDataMap rdm = new ResultDataMap();
		try {
			session = sessionFactory.getCurrentSession();
			session.update(site);
			rdm.setStatus(true);
			rdm.setMessage(Strings.savedSuccessfully);
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return rdm;

	}

}
