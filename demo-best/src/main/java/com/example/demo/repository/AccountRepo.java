package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Account;

public interface AccountRepo extends JpaRepository<Account, Integer> {
	public List<Account> findByFnameIgnoreCase(String name);

	public List<Account> findByLnameStartsWithIgnoreCase(String lname);

	public List<Account> findByIdBetween(Integer f, Integer l);

}
