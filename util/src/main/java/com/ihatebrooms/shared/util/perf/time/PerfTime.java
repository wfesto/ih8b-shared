package com.ihatebrooms.shared.util.perf.time;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerfTime {

	private final Logger logger = LoggerFactory.getLogger(PerfTime.class);
	protected Map<String, Long> timeTracker = new HashMap<String, Long>();

	@Before("execution(* com.ihatebrooms.*.controller.*.*(..))")
	public void start(JoinPoint joinPoint) {
		timeTracker.put(getObjId(joinPoint), System.currentTimeMillis());
	}

	@After("execution(* com.ihatebrooms.*.controller.*.*(..))")
	public void finish(JoinPoint joinPoint) {
		long time = System.currentTimeMillis() - timeTracker.get(getObjId(joinPoint));
		StringBuilder sb = new StringBuilder();
		sb.append("Method: ");
		sb.append(joinPoint.getThis().getClass().getSimpleName());
		sb.append('.');
		sb.append(joinPoint.getSignature().getName());
		sb.append(" took ");
		sb.append(time);
		sb.append(" ms");
		logger.debug(sb.toString());
	}

	protected String getObjId(JoinPoint joinPoint) {
		return joinPoint.getSignature().getName() + joinPoint.getThis().hashCode();
	}

}
