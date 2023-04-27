package com.ecourier.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecourier.service.impl.TransactionServiceImpl;
import com.ecourier.entity.Transaction;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/transaction")
public class TransactionController {
	@Autowired
	private TransactionServiceImpl transactionServiceImpl;
	@PostMapping("/addPayment")
	public Transaction payBill(@RequestBody Transaction transaction) {
	    Transaction payment=transactionServiceImpl.payBill(transaction);
	    return payment;
	}
	@DeleteMapping("/cancelPayment/{id}")
	public String cancelPayment(@PathVariable ("id")long transactionid) {
	    String message = transactionServiceImpl.cancelPayment(transactionid);
	    return message;
	}
	@GetMapping("/transactionById/{id}")
	public Transaction viewBill(@PathVariable ("id")long transactionid){
	Transaction list=transactionServiceImpl.viewBill(transactionid);
	    return list;
	}
	
}
