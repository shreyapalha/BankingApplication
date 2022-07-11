package com.xoriant.bankingapplication.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.xoriant.bankingapplication.controller.ManagerController;

@Aspect
public class MyAspects {
	private static final Logger logger = Logger.getLogger(ManagerController.class);
	@Before("execution(* com.xoriant.bankingapplication.service.ManagerServiceImpl.deposit(..))")
	public void printBefore() {
		logger.info("Starting the Payment");
	}
	@After("execution(* com.xoriant.bankingapplication.service.ManagerServiceImpl.deposit(..))")
	public void printAfter() {
		logger.info("Done the payment");
	}
}
