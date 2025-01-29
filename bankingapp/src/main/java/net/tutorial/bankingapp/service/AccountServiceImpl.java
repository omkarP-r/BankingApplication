package net.tutorial.bankingapp.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.tutorial.bankingapp.dto.AccountDto;
import net.tutorial.bankingapp.entity.Account;
import net.tutorial.bankingapp.mapper.AccountMapper;
import net.tutorial.bankingapp.repository.AccountRepository;


@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository accountRepo;

	@Override
	public AccountDto addAccount(AccountDto acc) {
		// TODO Auto-generated method stub
		Account account = AccountMapper.mapToAccount(acc);
		Account savedAccount = accountRepo.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto getAccountById(Integer id) {
		// TODO Auto-generated method stub
		Account account = accountRepo
		.findById(id)
		.orElseThrow(() -> new RuntimeException("No Account found with given id"));
		
		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto depositBalance(Integer id, Double amount) {
		// TODO Auto-generated method stub
		Account account = accountRepo
		.findById(id)
		.orElseThrow(() -> new RuntimeException("No Account found with given id"));
		
		Double total = account.getBalance() + amount;
		account.setBalance(total);
		Account savedAccount = accountRepo.save(account);
		
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto withdrawAmount(Integer id, Double amount) {
		// TODO Auto-generated method stub
		
		Account account = accountRepo
		.findById(id)
		.orElseThrow(() -> new RuntimeException("No Account found with given id"));
		
		if(account.getBalance()<amount)
			throw new RuntimeException("Account does not have sufficient balance");
		
		Double total = account.getBalance() - amount;
		account.setBalance(total);
		Account savedAccount = accountRepo.save(account);
		
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public List<AccountDto> getAllAccounts() {
		// TODO Auto-generated method stub
		
		List<Account> accounts = accountRepo.findAll();
		
		return accounts.stream()
				.map((account) -> AccountMapper.mapToAccountDto(account))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteAccountById(Integer id) {
		// TODO Auto-generated method stub
		Account account = accountRepo
				.findById(id)
				.orElseThrow(() -> new RuntimeException("No Account found with given id"));
		accountRepo.deleteById(id);
		
	}

}
