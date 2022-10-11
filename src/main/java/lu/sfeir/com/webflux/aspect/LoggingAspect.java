package lu.sfeir.com.webflux.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggingAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ObjectMapper mapper;
	
	@Pointcut(value="execution(* lu.sfeir.com.webflux.controller.*.*(..))")
	public void loggingControllerPointCut() {
		
	}
	
	@Pointcut(value="execution(* lu.sfeir.com.webflux.model.*.*(..))")
	public void loggingModelPointCut() {
		
	}
	@Around(value = "loggingControllerPointCut()")
	public Object loggingControllerAdvice(ProceedingJoinPoint pjp ) throws Throwable {
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().toString();

		Object[] array = pjp.getArgs();
		logger.info("Inside "+className +"."+
				 methodName+" method, with request "+mapper.writeValueAsString(array));
		Object response = pjp.proceed();
		
		logger.info("Inside "+className +"."+
				 methodName+" method, with response "+mapper.writeValueAsString(response));
	
		return response;
	}
    
    
    @Around(value = "loggingModelPointCut()")
    public Object loggingModelAdvice(ProceedingJoinPoint pjp ) throws Throwable {
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().toString();
		long t1=System.currentTimeMillis();
		Object response = pjp.proceed();
		long t2=System.currentTimeMillis();

		logger.info("Inside "+className +"."+
				 methodName+" method, time="+(t2-t1));
		
		return response;
	}
    
    public void afterReturn(Object returnValue) throws Throwable {
        logger.info("value return was {}",  returnValue);
    }
}
