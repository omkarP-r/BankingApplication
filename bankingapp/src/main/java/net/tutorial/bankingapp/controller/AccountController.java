package net.tutorial.bankingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.tutorial.bankingapp.dto.AccountDto;
import net.tutorial.bankingapp.service.AccountServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/account")
public class AccountController {

	@Autowired
	AccountServiceImpl accountService;
	
	

	@PostMapping
	public ResponseEntity <AccountDto> addAccount(@RequestBody AccountDto accountDto){
		return new ResponseEntity<>(accountService.addAccount(accountDto), HttpStatus.CREATED);
	}
}
