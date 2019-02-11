package com.ihatebrooms.shared.service;

import java.util.List;

import com.ihatebrooms.shared.dto.account.AccountDTO;

public interface AccountServiceIfc {

	public AccountDTO getAccount(String userName);

	public List<AccountDTO> getAllAccounts();
}
