package com.ecourier.service;
import com.ecourier.entity.Transaction;

public interface TransactionService {
    public Transaction payBill(Transaction transaction);
    public  Transaction viewBill(long transactionId);
   public  String cancelPayment(long transactionId);
}