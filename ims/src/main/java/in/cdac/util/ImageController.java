package in.cdac.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import in.cdac.util.UtilObjects;

@Controller
@SessionAttributes({"userid","accessmap","login","accessviewmap"})

public class ImageController {

	
	
	
	@RequestMapping("/image")
	@ResponseBody
	public HttpEntity<byte[]> getPhoto(@RequestParam String path) {
	    byte[] image=null;
		try {
			String abpath=UtilObjects.usrhome  + path;
			System.out.println("absolute path"+abpath);
			image = org.apache.commons.io.FileUtils.readFileToByteArray(new File(abpath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.IMAGE_PNG); 
	    headers.setContentLength(image.length);
	    return new HttpEntity<byte[]>(image, headers);
	}

}
