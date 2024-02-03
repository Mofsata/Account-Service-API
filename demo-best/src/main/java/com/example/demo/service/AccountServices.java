package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepo;
import com.example.demo.service.exception.ResourceNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountServices {
	private final AccountRepo repo;

	public List<Account> findAll() {
		return repo.findAll();
	}

	public Account findById(int id) {
		Optional<Account> result = repo.findById(id);
//		return result.isPresent() ? result.get() : null;
		result.orElseThrow(() -> new ResourceNotFoundException("Account with id = "+id +" Not Found"));
		return result.get();
	}

	public List<Account> findByIdbetween(Integer f, Integer l) {
		List<Account> result = repo.findByIdBetween(f, l);
		return result;
	}

	public List<Account> findByFName(String name) {
		List<Account> result = repo.findByFnameIgnoreCase(name);
		return result;
	}

	public List<Account> findByLName(String name) {
		List<Account> result = repo.findByLnameStartsWithIgnoreCase(name);
		return result;
	}

	public List<Account> paginate(Integer page, Integer size) {
		List<Account> result = repo.findAll().stream().skip(page * size).limit(size).toList();
		return result;
	}

	public Account addStudent(Account account) {
		return repo.save(account);
	}

	public void removeStudent(int id) {
		Account account = findById(id);
		repo.delete(account);
	}

	public Account updateStudent(Account rep) {
		return repo.save(rep);
	}

	public Account editStudent(Account newS, Integer id) {
		Account currS = findById(id);
		if (newS.getFname() != null) {
			currS.setFname(newS.getFname());
		}
		if (newS.getLname() != null) {
			currS.setLname(newS.getLname());
		}
		if (newS.getBalance() != 0) {
			currS.setBalance(newS.getBalance());
		}

		return repo.save(currS);
	}
}
