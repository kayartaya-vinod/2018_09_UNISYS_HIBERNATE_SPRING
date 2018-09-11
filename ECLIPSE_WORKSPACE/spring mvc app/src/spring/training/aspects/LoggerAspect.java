package spring.training.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
//import org.springframework.stereotype.Component;

@Aspect
// @Component
public class LoggerAspect {

	public LoggerAspect() {
		System.out.println(">>>> LoggerAspect instantiated!");
	}

	// by annotating a function with @Before, @After, @Around, @AfterThrowing
	// the function is now treated as an advice by AspectJ. The argument to the
	// annotation is a string expression called pointcut-expression, which is a
	// predicate for intercepting method calls
	@Before("execution(* spring..ProductDao.*(..))")
	public void printInfo(JoinPoint jp) {
		System.out.println("Intercepting the function " + jp.getSignature().getName() + " from "
				+ jp.getSignature().getDeclaringTypeName() + " with arguments " + Arrays.toString(jp.getArgs()));
	}
}
