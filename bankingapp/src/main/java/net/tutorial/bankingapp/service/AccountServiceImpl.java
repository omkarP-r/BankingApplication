package net.tutorial.bankingapp.service;

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

}
