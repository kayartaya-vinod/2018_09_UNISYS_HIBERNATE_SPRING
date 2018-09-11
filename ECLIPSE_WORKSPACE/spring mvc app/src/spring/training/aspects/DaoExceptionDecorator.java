package spring.training.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import spring.training.dao.DaoException;

@Aspect
@Component
public class DaoExceptionDecorator {

	@Pointcut("execution(* spring..*Dao.*(..))")
	public void pc1() {
	}

	@AfterThrowing(pointcut = "pc1()", throwing = "ex")
	public void convertToDaoException(JoinPoint jp, Exception ex) throws DaoException {
		throw new DaoException(ex);
	}
}
