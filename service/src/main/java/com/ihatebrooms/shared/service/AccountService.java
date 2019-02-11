package com.ihatebrooms.shared.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihatebrooms.ih8b.model.schema.Account;
import com.ihatebrooms.shared.dto.account.AccountDTO;
import com.ihatebrooms.shared.jpa.repository.AccountRepository;

@Service
public class AccountService implements AccountServiceIfc {

	@Autowired
	AccountRepository accountRepository;

	public AccountDTO getAccount(String userName) {
		System.out.println(userName);
		Account account = accountRepository.findByUserName(userName);
		return new AccountDTO(account);
	}

	public List<AccountDTO> getAllAccounts() {
		Iterable<Account> allAccounts = accountRepository.findAll();
		List<AccountDTO> accountList = new LinkedList<AccountDTO>();
		for (Account account : allAccounts) {
			accountList.add(new AccountDTO(account));
		}

		return accountList;
	}
}
