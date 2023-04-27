package com.ecourier.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecourier.service.TransactionService;
import com.ecourier.entity.Transaction;
import com.ecourier.exception.InvalidInputException;
import com.ecourier.repo.TransactionRepository;
@Service
public class TransactionServiceImpl implements TransactionService{
    @Autowired
    private TransactionRepository paymentRepository;
    public TransactionServiceImpl(TransactionRepository paymentRepository ) {
        this.paymentRepository=paymentRepository;
    }
    @Override
    public Transaction payBill(Transaction transaction) throws InvalidInputException {
        if(transaction.getCustomerId() ==0||transaction.getAmount() ==0) {
        	throw new InvalidInputException("Invalid input");
        }
            Transaction payment =new Transaction();
            payment.setTransactionId(transaction.getTransactionId());
            payment.setAmount(transaction.getAmount());
            payment.setCustomerId(transaction.getCustomerId());
            payment.setTrackingNumber(transaction.getTrackingNumber());
            payment.setMethod(transaction.getMethod());
            Transaction save = this.paymentRepository.save(transaction);
            return save;
        }

    
    @Override
    public String cancelPayment(long transactionId)throws InvalidInputException {
        Transaction transaction = this.paymentRepository.findById(transactionId).orElse(null);
        if(transaction == null) {
        	throw new InvalidInputException("Invalid");
        }
        paymentRepository.delete(transaction);
        return "cancelled";
    }
    @Override
    public Transaction viewBill(long transactionId) {
        Transaction transaction = this.paymentRepository.findById(transactionId).orElse(null);
        if(transaction == null) {
        	throw new InvalidInputException("Invalid");
        }
       // long transactionList=transaction.getTransactionId();
    return transaction;
}
}