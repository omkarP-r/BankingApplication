package net.tutorial.bankingapp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.tutorial.bankingapp.dto.AccountDto;
import net.tutorial.bankingapp.service.AccountServiceImpl;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/account")
public class AccountController {

	@Autowired
	AccountServiceImpl accountService;
	
	

	// Add Account Rest Api
	@PostMapping
	public ResponseEntity <AccountDto> addAccount(@RequestBody AccountDto accountDto){
		return new ResponseEntity<>(accountService.addAccount(accountDto), HttpStatus.CREATED);
	}
	
	// Get Account By Id Api
	@GetMapping("/getaccount/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Integer id){
		return new ResponseEntity<AccountDto>(accountService.getAccountById(id), HttpStatus.OK);
	}
	
	
	// Deposit Amount api
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> depositBalance(@PathVariable Integer id, @RequestBody Map<String,Double> request){
		Double amount = request.get("amount");
		return new ResponseEntity<AccountDto>(accountService.depositBalance(id, amount), HttpStatus.OK);
	
	
}
	
	// Withdraw Amount Api
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto> withdrawAmount(@PathVariable Integer id, @RequestBody Map<String,Double> request){
		Double amount = request.get("amount");
		return new ResponseEntity<AccountDto>(accountService.withdrawAmount(id, amount), HttpStatus.OK);
	
	
}
	@GetMapping("/all")
	public ResponseEntity<List<AccountDto>> getAllAccounts(){
		return new ResponseEntity<List<AccountDto>>(accountService.getAllAccounts(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}/delete")
	public ResponseEntity<String> deleteAccountById(Integer id){
		accountService.deleteAccountById(id);
		return new ResponseEntity<String>("Account deleted by given id",HttpStatus.OK);
		
	}
}
