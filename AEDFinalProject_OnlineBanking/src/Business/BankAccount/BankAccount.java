/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.BankAccount;

import Business.Transaction.TransactionHistory;

/**
 *
 * @author amitha.murali
 */
public class BankAccount {
    
    
    private int availableBalance;
    private static int counter = 0;
    private int accountNumber;
    private int routingNumber;
    private Type bankAccountType;
    private String accountHolderName;
    private TransactionHistory transactionHistory;
    private String bankBranch;
   
    
    public BankAccount(int accountNumber, int routingNumber) {
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
       transactionHistory = new TransactionHistory();
      }

    public int getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(int routingNumber) {
        this.routingNumber = routingNumber;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public int getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(int availableBalance) {
        this.availableBalance = availableBalance;
    }

    public TransactionHistory getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(TransactionHistory transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public Type getBankAccountType() {
        return bankAccountType;
    }

    public void setBankAccountType(Type bankAccountType) {
        this.bankAccountType = bankAccountType;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
      this.accountNumber = accountNumber;
  }

       
     public enum Type{
        Savings("Savings"), Checking("Checking");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
      @Override
    public String toString() {
        return bankBranch;
    }
    
    
      
    
}
