package com.dariocuevas.restServer.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.log4j.NDC;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint.StaticPart;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TraceAspect {
	
	@Pointcut("execution(* com.dariocuevas.restServer.dao..*.*(..))")
	public void daoOp() {};
	
	@Pointcut("execution(* com.dariocuevas.restServer.controller..*.*(..))")
	public void controllerOp() {};
	
	@Pointcut("execution(* com.dariocuevas.restServer.service..*.*(..))")
	public void serviceOp() {};
	
	@Before("(daoOp() || controllerOp() || serviceOp()) && target(object)")
	public void traceIn(final Object object, final StaticPart staticPart, final JoinPoint thisJoinPoint) {
		final Signature sig = staticPart.getSignature();
		getLog(object).info("++ IN ++ [" + sig.toShortString() + "]" + createParameterMessage(thisJoinPoint));
		NDC.push("   ");
	}
	
	@After("(daoOp() || controllerOp() || serviceOp()) && target(object)")
	public void traceOut(final Object object, final StaticPart staticPart) {
		NDC.pop();
		final Signature sig = staticPart.getSignature();
		getLog(object).info("-- OUT -- [" + sig.toShortString() + "]");
	}
	
	private Logger getLog(final Object object) {
		return LoggerFactory.getLogger(object.getClass());
	}
	
	private String createParameterMessage(final JoinPoint joinPoint) {
		final StringBuffer paramBuffer = new StringBuffer(" [Args: (");
		
		final Object[] arguments = joinPoint.getArgs();
		for (int length = arguments.length, i = 0; i < length; ++i) {
			Object argument = arguments[i];
			paramBuffer.append(argument);
			if (i != length -1) {
				paramBuffer.append(",");
			}	
		}
		paramBuffer.append(")]");
		
		return paramBuffer.toString();
	}
	
}
