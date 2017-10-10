/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Beneficiary;

import Business.BankAccount.BankAccount;

/**
 *
 * @author amitha.murali
 */
public class Beneficiary {
    
    private String beneficiaryName;
    private String status;
    private BankAccount bankAccount;
    private String addedDate;
    
    public static final String UNDERREVIEW_STATUS = "UnderReview";
    public static final String PENDING_STATUS = "Pending";
    public static final String BENEFICIARY_APPROVED = "BeneficiaryApproved";
    public static final String BENEFICIARY_DECLINED = "BeneficiaryDeclined";
    
    
    public Beneficiary()
    {
      //  bankAccount = new BankAccount();
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {        
        this.beneficiaryName = beneficiaryName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }
    
     @Override
    public String toString() {
        return beneficiaryName;
    }
}
