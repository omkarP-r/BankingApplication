package net.tutorial.bankingapp.service;

import java.util.List;

import net.tutorial.bankingapp.dto.AccountDto;


public interface AccountService {

	
	AccountDto addAccount(AccountDto acc);
	AccountDto getAccountById(Integer id);
	AccountDto depositBalance( Integer id, Double amount);
	AccountDto withdrawAmount (Integer id, Double amount);
	List<AccountDto> getAllAccounts();
	void deleteAccountById(Integer id);
}
