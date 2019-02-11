package com.ihatebrooms.shared.jpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ihatebrooms.ih8b.model.schema.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {

	@Query("Select x from Account x where x.userName = :incUserName")
	public Account findByUserName(@Param("incUserName") String incUserName);
}
