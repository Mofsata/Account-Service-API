package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountServices;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/accounts")
public class AccountController {
	private final AccountServices studentService;

	@GetMapping
	public ResponseEntity<List<Account>> getAllStudents() {
//		return studentService.findAll();
		return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Account> getAnAccount(@PathVariable int id) {
//		return studentService.findById(id);
		return ResponseEntity.ofNullable(studentService.findById(id));

	}

	@GetMapping("/search/fname")
	public List<Account> getAccountsByFname(@RequestParam(value = "q") String name) {
		return studentService.findByFName(name);
	}

	@GetMapping("/search/lname")
	public List<Account> getAccountsLname(@RequestParam(value = "q") String name) {
		return studentService.findByLName(name);
	}

	@GetMapping("/search/idsbetween")
	public List<Account> getAccountswithids(@RequestParam(value = "f") Integer f,
			@RequestParam(value = "l") Integer l) {
		return studentService.findByIdbetween(f, l);
	}

	@GetMapping("/search/paginate")
	public List<Account> getAccounts(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(value = "size", required = false, defaultValue = "2") Integer size) {
		return studentService.paginate(page, size);
	}

	@PostMapping
	public Account addAccount(@RequestBody Account account) {
		return studentService.addStudent(account);
	}

	@DeleteMapping("/{id}")
	public void delAccount(@PathVariable int id) {
		studentService.removeStudent(id);
	}

	@PutMapping
	public Account updateAccount(@RequestBody Account account) {
		return studentService.updateStudent(account);
	}

	@PatchMapping("/{id}")
	public Account patchAccount(@RequestBody Account account, @PathVariable int id) {
		return studentService.editStudent(account, id);
	}

//	@ExceptionHandler({ResourceNotFoundException.class })
//	public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
//		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//	}
}
