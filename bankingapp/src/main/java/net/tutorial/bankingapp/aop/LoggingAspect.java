package net.tutorial.bankingapp.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect

public class LoggingAspect {

	@Before("execution(* net.tutorial.bankingapp.service.AccountServiceImpl.getAccountById(..))")
	public void log() {
		System.out.println("Aspect Log called");
	}
}
