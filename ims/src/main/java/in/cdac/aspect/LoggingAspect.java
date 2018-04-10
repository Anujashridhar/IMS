package in.cdac.aspect;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import in.cdac.ims.campus.entity.Site;
import in.cdac.ims.util.entity.ResultDataMap;

@Aspect
@Component
public class LoggingAspect {

	
	//Logger
	
	Logger logger=Logger.getLogger(getClass().getName());
	
	
	
/*	//pointcut
	@Pointcut("execution(* in.cdac..controller..*(..))")
	public void allControllers() {}
	*/
	//advice
	
	/*@Before("execution(* in.cdac.auth.login.serviceimpl.LoginServiceImpl.getUserByIdOrEmailOrMobile(..))")
	public void beforeAllControllers(JoinPoint joinPoint)
	{
		logger.info("Anuj'a Logs =====>>>> running method"+joinPoint.getSignature());
	}*/
	//execution(* com.abc.xyz..controller..*(..))
	
	
	@Before("execution(* in.cdac..controller..*(..))")
	public void before11AllControllers(JoinPoint joinPoint)
	{
		
		logger.info("Anuj'a Logs =====>>>> running method \n"+joinPoint.getSignature());
		for (Object obj : joinPoint.getArgs()) {
			logger.info("Anuj'a Logs =====>>>> arguments passed are :\n"+obj);
		}
		
	}
	@Before("execution(* in.cdac..dao..*(..))")
	public void before11AllDao(JoinPoint joinPoint)
	{
		logger.info("Anuj'a Logs =====>>>> running method \n"+joinPoint.getSignature());
		for (Object obj : joinPoint.getArgs()) {
			logger.info("Anuj'a Logs =====>>>> arguments passed are :\n"+obj);
		}
	}
	@Before("execution(* in.cdac..service..*(..))")
	public void before11AllServices(JoinPoint joinPoint)
	{
		logger.info("Anuj'a Logs =====>>>> running method \n"+joinPoint.getSignature());
		for (Object obj : joinPoint.getArgs()) {
			logger.info("Anuj'a Logs =====>>>> arguments passed are :\n"+obj);
		}
	}
	/*@After("execution(* in.cdac..controller..*(..))")
	public void afterAllControllers(JoinPoint joinPoint)
	{
		
		logger.info("Anuj'a Logs =====>>>> running method \n"+joinPoint.getSignature());
		for (Object obj : joinPoint.getArgs()) {
			
			logger.info("Anuj'a Logs =====>>>> arguments passed are :\n"+obj);
		}
		
	}
	@After("execution(* in.cdac..dao..*(..))")
	public void after11AllDao(JoinPoint joinPoint)
	{
		logger.info("Anuj'a Logs =====>>>> running method \n"+joinPoint.getSignature());
		for (Object obj : joinPoint.getArgs()) {
			logger.info("Anuj'a Logs =====>>>> arguments passed are :\n"+obj);
		}
	}
	@After("execution(* in.cdac..service..*(..))")
	public void after11AllServices(JoinPoint joinPoint)
	{
		logger.info("Anuj'a Logs =====>>>> running method \n"+joinPoint.getSignature());
		for (Object obj : joinPoint.getArgs()) {
			logger.info("Anuj'a Logs =====>>>> arguments passed are :\n"+obj);
		}
	}
	*/
	@AfterReturning(pointcut="execution(* in.cdac..controller..*(..))",returning="result")
	public void afterReturningControllerAdvice(JoinPoint joinPoint,Object result)
	{
		logger.info("Anuj'a Logs =====>>>> After Returning Advice \n"+joinPoint.getSignature());
		logger.info("Anuj'a Logs =====>>>> returning Values \n"+result);
		
	}
	
	@AfterReturning(pointcut="execution(* in.cdac..service..*(..))",returning="result")
	public void afterReturningServiceAdvice(JoinPoint joinPoint,Object result)
	{
		
		
		//(result.getClass())
		logger.info("Anuj'a Logs =====>>>> After Returning Advice \n"+joinPoint.getSignature());
		logger.info("Anuj'a Logs =====>>>> returning Values \n"+result);
		
	}
	
	@AfterReturning(pointcut="execution(* in.cdac..dao..*(..))",returning="result")
	public void afterReturningDaoAdvice(JoinPoint joinPoint,Object result)
	{
		logger.info("Anuj'a Logs =====>>>> After Returning Advice \n"+joinPoint.getSignature());
		logger.info("Anuj'a Logs =====>>>> returning Values \n"+result);
		
	}
	
	
	
/*	@AfterThrowing("allControllers()")
	public void test()
	{
		logger.info("anuja ====>>> exception");
	}*/
}
