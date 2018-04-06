package in.cdac.ims.student.admission.daoimpl;


import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.cdac.db.auth.entity.Tocken;
import in.cdac.db.auth.entity.User;
import in.cdac.db.student.entity.StudentPersonalDetails;
import in.cdac.ims.student.admission.dao.StudentAdmisionDao;
import in.cdac.ims.util.entity.ResultDataMap;
import in.cdac.ims.util.entity.Strings;
@Repository
public class StudentAdmissionDaoImpl implements StudentAdmisionDao {
   @Autowired
	SessionFactory sessionfactory; 
   	ResultDataMap result;
	
	public ResultDataMap verifyEmailAddress(String tocken) {
		ResultDataMap rdm=new ResultDataMap();
		Session session=sessionfactory.getCurrentSession();
		List<Tocken> list=session.createQuery("from Tocken where tocken=:tocken order by generatedDate desc",Tocken.class).setParameter("tocken", tocken).list();
		if(list!=null && !list.isEmpty())
			{
			for (Tocken tocken2 : list) {
				if(tocken2.getStatus() == Strings.NewTocken && tocken2.getTypeOfTocken().equals(Strings.emailVerificationTocken))
				{
					tocken2.setStatus(Strings.VerifiedTocken);
					User user=session.get(User.class, tocken2.getUserId());
					user.setActiveFlag('1');
					user.setEmailVerifiedFlag('Y');
					session.update(user);
					session.update(tocken2);
					rdm.setStatus(true);
					rdm.setMessage(Strings.EmailVerifiedSuccess);
				}else if(tocken2.getStatus() == Strings.VerifiedTocken)
				{
					rdm.setStatus(false);
					rdm.setMessage(Strings.EmailAlreadyVerified);
				}else if(tocken2.getStatus() == Strings.ExpiredTocken){
					rdm.setStatus(false);
					rdm.setMessage(Strings.ExpiredTockenMessage);
				}else {
					rdm.setStatus(false);
					rdm.setMessage(Strings.InvalidTocken);
				}
				
			}
			
		}else {
			rdm.setStatus(false);
			rdm.setMessage(Strings.InvalidTocken);
		}
		return rdm;
	}
	public ResultDataMap getNewTocken(String emailId) {
		String tockenNo=null;
		ResultDataMap rdm=new ResultDataMap();
		Session session=sessionfactory.getCurrentSession();
		User user=session.createQuery("from User where userEmail like upper(:email) ",User.class)
				.setParameter("email", emailId)
				.uniqueResult();
		//find tockens for given email id ,for email verification , order by recent first
		if(user!=null)
		{
				List<Tocken> list=session.createQuery(" FROM Tocken where userId=:userId  " + 
																" and typeOfTocken=:typeOfTocken order by generatedDate desc ",Tocken.class)
															.setParameter("userId", user.getUserId())
															.setParameter("typeOfTocken", Strings.emailVerificationTocken)
															
															.list();
				boolean newTockenFound=false;
				boolean verifiedTockenFound=false;
			/*	//check if some tockens are found
				if(list!=null && !list.isEmpty())
					{*/
					//iterate through all tockens
						for (Tocken tocken : list) 
						{
							//check the status of tocken
							switch (tocken.getStatus())
							{
								//check ofr new tocken N=new Tockem
								case 'N':
									newTockenFound=true;
									//return already saved tocken
									tockenNo=tocken.getTocken();
									rdm.setMessage(Strings.OldTockenExistToVerify);
									user.setTocken(tockenNo);
									rdm.setDataObject(user);
									rdm.setStatus(true);
									break;
									
								//check for verified tocken V=verified Tocekn	
								case 'V':
									verifiedTockenFound=true;
									rdm.setMessage(Strings.EmailAlreadyVerified);
									rdm.setStatus(false);
									break;
								default:
									
									break;
							}
							// break the loop if any of two found
							if(newTockenFound || verifiedTockenFound)
							{
								return rdm;
								
							}
						}
						
						
						if( !newTockenFound && !verifiedTockenFound)
						{
							
							
							//generate new Tocken
							tockenNo=RandomStringUtils.randomAlphanumeric(30);
							//save new Tocken
							Tocken newTocken=new Tocken();
							newTocken.setGeneratedDate(new Date());
							newTocken.setStatus(Strings.NewTocken);
							newTocken.setTocken(tockenNo);
							newTocken.setTypeOfTocken(Strings.emailVerificationTocken);
							newTocken.setUserId(user.getUserId());
							newTocken.setValidFlag('1');
							session.save(newTocken);
							
							user.setTocken(tockenNo);
							rdm.setDataObject(user);
							rdm.setStatus(true);
							rdm.setMessage(Strings.NewTockenGenerated);
							return rdm;
							
						}else {
							rdm.setStatus(false);
							rdm.setMessage(Strings.error);
							return rdm;
						}
					
						/*}else {
						rdm.setStatus(false);
						rdm.setMessage(Strings.EmailNotRegistered);
						return rdm;
					}*/
		}else {
			rdm.setStatus(false);
			rdm.setMessage(Strings.EmailNotRegistered);
			return rdm;
		}
	}
	
	
	public Boolean ifFormSubmitted(Integer userId) {
		Session session=sessionfactory.getCurrentSession();
		System.out.println(userId);
		Character resut=(Character) session.createQuery("select formSubmitted from StudentPersonalDetails where studentId=:userId ").setParameter("userId", userId).uniqueResult();
		
		System.out.println(resut);
		if(resut.equals('Y'))
		{
			return true;
		}else{
			return false;
		}
	
	}
	public ResultDataMap saveStudentPersonalDetails(StudentPersonalDetails studentPersonalDetails) {
		sessionfactory.getCurrentSession().save(studentPersonalDetails);
		return new ResultDataMap().setStatus(true).setMessage(Strings.savedSuccessfully);
	}

}
