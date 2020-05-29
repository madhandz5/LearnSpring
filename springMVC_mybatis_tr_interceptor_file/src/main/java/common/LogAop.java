package common;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogAop {
//	메소드가 실행되기전에 실행됨	
	public void before(JoinPoint join) {
		Logger logger =  LoggerFactory.getLogger(join.getTarget()+"");

		logger.info("------LogAop Start------");
		
//		매개변수들을 가져올수 있다.
		Object[] args = join.getArgs();
		
		if(args != null) {
			logger.info("method : " + join.getSignature().getName());
			for(int i = 0; i < args.length; i++) {
				logger.info(i+"번째 : " + args[i]);
			}
		}
		
	}
	
//	메소드가 실행된 후에 실행됨
	public void after(JoinPoint join) {
		Logger logger = LoggerFactory.getLogger(join.getTarget()+"");
		logger.info("------LogAop End--------");
	}
	
//	에러 발생 시
	public void afterThrowing(JoinPoint join) {
		Logger logger = LoggerFactory.getLogger(join.getTarget()+"");
		logger.info("--------err log---------");
		logger.info("ERROR : " + join.getArgs());
		logger.info("ERROR : " + join.toString());
	}
	
	
}
