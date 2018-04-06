package in.cdac.ims.util.entity;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;

import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Logger;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;

import in.cdac.util.UtilObjects;


public class Mail {
	
	@Autowired
	Logger Log;
	
	private static String hostName;
	private static String port;
	private static String FromEmailId;
	private static String password;
	
	private static String FROMLepmpaServer;
	private static String ToFeedBackAdmin;
	
	 
	//private String subject=Strings.emailSubject;
	
	

	static
	{
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(UtilObjects.configHome+"/mailConfig.properties");
			
			// load a properties file
			prop.load(input);
			hostName=prop.getProperty("hostName");
			port=prop.getProperty("port");
			FromEmailId=prop.getProperty("FromEmailId");
			password=prop.getProperty("password");
			setFROMLepmpaServer(prop.getProperty("FROMLepmpaServer"));
			   setToFeedBackAdmin(prop.getProperty("ToFeedBackAdmin"));
			} catch (IOException ex) {
				ex.printStackTrace();
			}  finally {
				if (input != null) {
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		}
	
	
	
	public HashMap<String, String> sendSimpleMail(String To,String message,String subject) throws Exception 
	{
		
		HashMap<String, String> result=new HashMap<String, String>();
    	
		Email email = new SimpleEmail();
		try {
			email.setHostName(hostName);
			Integer Iport=Integer.parseInt(port);
			email.setSmtpPort(Iport.intValue());
			email.setAuthenticator(new DefaultAuthenticator(FromEmailId,password));
			email.setSSL(true);
			email.setFrom(FromEmailId);
			email.setSubject(subject);
			email.setMsg(message);
			System.out.println("sendign mail to "+To);
			email.addTo(To);
			email.send();
		} catch (EmailException ex) {
			Log.info("MAil.Java Exception "+ex.getMessage());
        	Log.info("mail exception  "+ ex);
        	ex.printStackTrace();
            System.out.println("The email was not sent.");
            Log.info("The email was not sent.");
            message=message+"The email was not sent.";
            System.out.println("Error message: " + ex.getMessage());
            message=message+"Error message: " + ex.toString();
            result.put("mailStatus", "N");
            result.put("mailMessage", Strings.Mailfailed+"message :: "+ex.getMessage());
            
			ex.printStackTrace();
			throw new Exception("failed to send Email");
		} finally
        {
           
        }
		return result;
	}



	public static String getFROMLepmpaServer() {
		return FROMLepmpaServer;
	}



	public static void setFROMLepmpaServer(String fROMLepmpaServer) {
		FROMLepmpaServer = fROMLepmpaServer;
	}



	public static String getToFeedBackAdmin() {
		return ToFeedBackAdmin;
	}



	public static void setToFeedBackAdmin(String toFeedBackAdmin) {
		ToFeedBackAdmin = toFeedBackAdmin;
	}
	
	
	
}
