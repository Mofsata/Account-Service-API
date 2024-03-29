package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Transaction;
import com.example.demo.service.TransferService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class TransferController {
	private final TransferService tranService;

	@PostMapping("/transfer")
	public Transaction transfer(@RequestBody Transaction trans) {
		return tranService.transfer(trans);
	}

}
