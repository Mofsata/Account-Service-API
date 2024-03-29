package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Transaction;
import com.example.demo.service.TransactionServices;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/transactions")
public class TransactionController {
	private final TransactionServices transService;

	@GetMapping
	public ResponseEntity<List<Transaction>> getAllTransactions() {
		return new ResponseEntity<>(transService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public Transaction getMethodName(@PathVariable int id) {
		return transService.findById(id);
	}
	
}
