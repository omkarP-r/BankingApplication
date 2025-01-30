package net.tutorial.bnkingapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class BankingappExceptionHandler {

	@ExceptionHandler(value = {BankingappNotFoundException.class})
	public ResponseEntity<Object> handleBankingappNotFoundException
	(BankingappNotFoundException bankingappexception){
	
		BankingappException banfe = new BankingappException(
				bankingappexception.getMessage(),bankingappexception.getCause(),HttpStatus.NOT_FOUND);
		
		
		return new ResponseEntity<Object>(banfe, HttpStatus.NOT_FOUND);
		
				
	}
}
