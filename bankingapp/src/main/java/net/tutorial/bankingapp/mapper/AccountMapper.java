package net.tutorial.bankingapp.mapper;

import net.tutorial.bankingapp.dto.AccountDto;
import net.tutorial.bankingapp.entity.Account;

public class AccountMapper {

	
	public static Account mapToAccount(AccountDto accountDto) {
		
		Account account = new Account(accountDto.getId(),accountDto.getAccountHolderName(),accountDto.getBalance(),
				accountDto.getPhoneNumber());
		
		return account;
	}
	
	
	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto = new AccountDto (account.getId(),account.getAccountHolderName(),
				account.getBalance(),account.getPhoneNumber());
		
		return accountDto;
	}
}
