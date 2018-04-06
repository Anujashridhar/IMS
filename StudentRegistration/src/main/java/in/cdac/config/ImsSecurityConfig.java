package in.cdac.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class ImsSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private ImsAuthenticationProvider authenticationProvider;
	
	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(authenticationProvider);
		
	
	/*	//use jdbc authentication
		// auth.jdbcAuthentication().dataSource(securityDataSource);
		 auth.jdbcAuthentication().dataSource(securityDataSource)
		    .usersByUsernameQuery(
		    "select username,password, enabled from users_test where username=?")
		    	//	"select userId username,password,activeFlag enabled from user where userId=(select findUser(?) from  dual)")
		    //"SELECT userEmail username,password,activeFlag enabled FROM ims.user where userEmail=?")
		    		.authoritiesByUsernameQuery(
		   //  "select userId username,usercol role from ims.user where userEmail=?");
		   //"select username,authority from ims.authorities where username=?");
		 "SELECT u.userId username,am.authority authority FROM ims.UserRole u,authoritiesMaster am,RoleAuthorities ra"
		    				+" where u.roleId=ra.roleId"
		    				+" and ra.authoritiesId=am.authorityId"
		    				+ " and u.userId=?");*/
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			//.antMatchers("/dashboard/**").hasAnyAuthority("ROLE_EMPLOYEE","2")
			.antMatchers("/dashboard/**").hasAnyRole("DASHBOARD","SUPER_ADMIN")
			
			.antMatchers("/student/**").hasAnyRole("STUDENT","SUPER_ADMIN")
			.antMatchers("/student/admin/**").hasAnyRole("STUDENT_ADMINISTRATION","SUPER_ADMIN")
			.antMatchers("/student/faculty/**").hasAnyRole("STUDENT_FACULTY","SUPER_ADMIN")
			
			.antMatchers("/programme/**").hasAnyRole("PROGRAMME_ADMINSTRAION","SUPER_ADMIN")
				.and()
			.formLogin()
				.loginPage("/loginForm")
				.permitAll()
				.and()
				.formLogin()
				.defaultSuccessUrl("/dashboard")
				.and()
				.logout()
				.permitAll()
				.and()
				.exceptionHandling().accessDeniedPage("/access-denied");
	}

	/*protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			//.antMatchers("/dashboard/**").hasAnyAuthority("ROLE_EMPLOYEE","2")
			.antMatchers("/dashboard/**").hasAnyRole("EMPLOYEE","2")
			.antMatchers("/site/admin/**").hasAnyRole("SITE_ADMIN","SUPER_ADMIN")
			.antMatchers("/site/content/**").hasAnyRole("SITE_ADMIN","SUPER_ADMIN")
			.antMatchers("/site/**").hasAnyRole("SUPER_ADMIN")
			
			.antMatchers("/student/**").hasAnyRole("ACADAMIC_ADMIN","2")
			.antMatchers("/hr/**").hasAnyRole("HR_ADMIN","2")
			.antMatchers("/programme/**").hasAnyRole("PROGRAMME_ADMIN","2")
			.antMatchers("/file/**").hasAnyRole("FTS_ADMIN","2")
			.antMatchers("/lib/**").hasAnyRole("LIB_ADMIN","2")
			.antMatchers("/inventory/**").hasAnyRole("INVENTORY_ADMIN","2")
			.antMatchers("/hostel/**").hasAnyRole("HOSTEL_ADMIN","2")
			.antMatchers("/auth/**").hasAnyRole("SUPER_ADMIN")
			.and()
			.formLogin()
				.loginPage("/loginForm")
				.permitAll()
				.and()
				.formLogin()
				.defaultSuccessUrl("/dashboard")
				.and()
				.logout()
				.permitAll()
				.and()
				.exceptionHandling().accessDeniedPage("/access-denied");
	}*/

	
}
