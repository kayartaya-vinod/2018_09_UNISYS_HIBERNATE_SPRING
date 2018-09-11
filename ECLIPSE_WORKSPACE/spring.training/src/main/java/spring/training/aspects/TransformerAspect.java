package spring.training.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransformerAspect {

	// ProceedingJoinPoint is only supported for around advice
	@Around("execution( * spring..ProductDao.*(Double, Double))")
	public Object swapArgs(ProceedingJoinPoint jp) throws Throwable {
		Object[] args = jp.getArgs(); // always an array of 2 Double; ref pointcut expression
		Double min = (Double) args[0]; // no need to check; ref pointcut expression
		Double max = (Double) args[1]; // no need to check; ref pointcut expression

		if (min > max) {
			args = new Object[] { max, min }; // swapping
		}

		return jp.proceed(args); // invoking the actual target function with new arguments
	}
}
