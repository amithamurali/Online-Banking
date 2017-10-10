/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Transaction;

import Business.BankAccount.BankAccount;
import java.util.ArrayList;

/**
 *
 * @author amitha.murali
 */
public class TransactionHistory {
    
     private ArrayList<Transaction> transactionHistory;

    public ArrayList<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(ArrayList<Transaction> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public TransactionHistory() {
        transactionHistory = new ArrayList<>();
    }
    
    public Transaction createTransaction(){
        Transaction transaction = new Transaction();       
        transactionHistory.add(transaction);        
       return transaction;
    }
    
     public Transaction createTransaction(int transactionNumber){
        Transaction transaction = new Transaction(transactionNumber);       
        transactionHistory.add(transaction);        
       return transaction;
    }
    
     public void removeTransaction(Transaction transaction){
        transactionHistory.remove(transaction);
    }
    
    public Transaction searchTransaction(int transactionNumber){
        for (Transaction transaction : transactionHistory) {
            if(transaction.getTransactionNumber()==transactionNumber){
                return transaction;
            }
        }
        return null;
    }
}
