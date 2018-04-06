package in.cdac.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

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
		logger.info("Anuj'a Logs =====>>>> arguments passed are :\n"+joinPoint.getArgs());
	}
	@Before("execution(* in.cdac..dao..*(..))")
	public void before11AllDao(JoinPoint joinPoint)
	{
		logger.info("Anuj'a Logs =====>>>> running method \n"+joinPoint.getSignature());
		logger.info("Anuj'a Logs =====>>>> arguments passed are :\n"+joinPoint.getArgs());
	}
	@Before("execution(* in.cdac..service..*(..))")
	public void before11AllServices(JoinPoint joinPoint)
	{
		logger.info("Anuj'a Logs =====>>>> running method \n"+joinPoint.getSignature());
		logger.info("Anuj'a Logs =====>>>> arguments passed are :\n"+joinPoint.getArgs());
	}
	
	
/*	@AfterThrowing("allControllers()")
	public void test()
	{
		logger.info("anuja ====>>> exception");
	}*/
}
