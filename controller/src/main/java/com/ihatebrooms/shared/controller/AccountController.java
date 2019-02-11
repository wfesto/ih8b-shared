package com.ihatebrooms.shared.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ihatebrooms.shared.dto.account.AccountDTO;
import com.ihatebrooms.shared.service.AccountServiceIfc;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountServiceIfc accountService;

	@RequestMapping("/login")
	@ResponseBody
	public AccountDTO login(@RequestBody AccountDTO user) {
		return accountService.getAccount(user.getUserName());
	}

	@RequestMapping("/getAllAccounts")
	@ResponseBody
	public List<AccountDTO> getAllAccounts() {
		return accountService.getAllAccounts();
	}
}
