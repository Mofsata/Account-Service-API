package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Transaction;
import com.example.demo.repository.TransactionRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransactionServices {
	private final TransactionRepo repo;

	public List<Transaction> findAll() {
		return repo.findAll();
	}
	public Transaction findById(int id) {
		Optional<Transaction> result = repo.findById(id);
		return result.isPresent() ? result.get() : null;
	}

}
