/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Transaction;

import Business.Beneficiary.Beneficiary;

/**
 *
 * @author amitha.murali
 */
public class Transaction {
 
    private static int counter;
    private int transactionId;
    private int transactionNumber;
    private Beneficiary associatedBeneficiary;
    private String transactionDate;
    private String Description;
    private int amount;
    private Type transactionType;
    private String senderOrPayee;

      public enum Type{
        Debit("Debit"), credit("Credit");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public String getSenderOrPayee() {
        return senderOrPayee;
    }

    public void setSenderOrPayee(String senderOrPayee) {
        this.senderOrPayee = senderOrPayee;
    }

    public Type getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Type transactionType) {
        this.transactionType = transactionType;
    }
      
    public int getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionNumber(int transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public Beneficiary getAssociatedBeneficiary() {
        return associatedBeneficiary;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setAssociatedBeneficiary(Beneficiary associatedBeneficiary) {
        this.associatedBeneficiary = associatedBeneficiary;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public Transaction()
    {        
        transactionId = 100 + counter++;
        transactionNumber = transactionId;
    }
    
      public Transaction(int transactionNumber)
    {    
        transactionId = 100 + counter++;
       this.transactionNumber = transactionNumber;
    }
    
}
