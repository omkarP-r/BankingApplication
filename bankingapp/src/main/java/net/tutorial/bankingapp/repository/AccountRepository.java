package net.tutorial.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.tutorial.bankingapp.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

}
