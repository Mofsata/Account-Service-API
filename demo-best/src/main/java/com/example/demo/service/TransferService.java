package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.entity.Transaction;
import com.example.demo.repository.TransactionRepo;
import com.example.demo.service.exception.InsufficientBalanceException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransferService {
	private final TransactionRepo transRepo;
//	private final AccountRepo accountRepo;
	private final AccountServices accService;

	public Transaction transfer(Transaction transaction) {
		Account src = accService.findById(transaction.getSender());
		Account dist = accService.findById(transaction.getReceiver());
		if (src.getBalance() < transaction.getAmount()) {
			throw new InsufficientBalanceException("Current balance: " + src.getBalance() + " is insufficient.");
		}

		src.setBalance(src.getBalance() - transaction.getAmount());
		dist.setBalance(dist.getBalance() + transaction.getAmount());

		accService.updateStudent(src);
		accService.updateStudent(dist);
		return transRepo.save(transaction);
	}

}
