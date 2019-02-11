package com.ihatebrooms.shared.dto.account;

import java.io.Serializable;

import com.ihatebrooms.ih8b.model.schema.Account;

import lombok.Data;

@Data
public class AccountDTO implements Serializable {

	private static final long serialVersionUID = 5020788740963727307L;
	protected String userName;
	protected String email_enc;

	public AccountDTO() {

	}

	public AccountDTO(Account account) {
		if (account == null) {
			return;
		}

		this.userName = account.getUserName();
		this.email_enc = account.getEmailEnc();
	}
}
