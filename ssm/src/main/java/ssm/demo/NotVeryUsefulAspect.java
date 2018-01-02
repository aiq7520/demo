package ssm.demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NotVeryUsefulAspect {
	//«∞÷√
	@Pointcut("execution(* ssm.service.*.*(..))")
	public void serviceMethod(){}
	
	@Before("serviceMethod()")
	public void before(){
		System.out.println("≤‚ ‘ aspect «∞÷√");
	}
}
