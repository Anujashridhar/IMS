package in.cdac.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


// replacment of web.xml ( check pom.xml as well for changes)
public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] {MvcDispatcher.class};
	}

	@Override
	protected String[] getServletMappings() {
		
		return new String[] {"/"};
	}
	 @Override
	    public void onStartup(ServletContext servletContext) throws ServletException {
	        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
	        appContext.register(MvcDispatcher.class);

	        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("MvcDispatcher",
	                new DispatcherServlet(appContext));
	        dispatcher.setLoadOnStartup(1);
	        dispatcher.addMapping("/");



	        ContextLoaderListener contextLoaderListener = new ContextLoaderListener(appContext);

	        servletContext.addListener(contextLoaderListener);


	        // Filter.
	        FilterRegistration.Dynamic fr = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);

	        fr.setInitParameter("encoding", "UTF-8");
	        fr.setInitParameter("forceEncoding", "true");
	        fr.addMappingForUrlPatterns(null, true, "/*");
	    }
}