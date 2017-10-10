/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import Business.BankAccount.BankAccount;
import Business.BankAccount.BankAccountDirectory;
import Business.Beneficiary.BeneficiaryDirectory;
import java.util.ArrayList;

/**
 *
 * @author amitha.murali
 */
public class Customer extends Person{
    
    private BeneficiaryDirectory beneficiaryDirectory;
    private BankAccountDirectory bankAccountDirectory ;
     
     

    public Customer(String name) {
        
           super(name, Person.Type.Customer);
           bankAccountDirectory = new BankAccountDirectory();
           beneficiaryDirectory = new BeneficiaryDirectory();
          
    } 

    public BeneficiaryDirectory getBeneficiaryDirectory() {
        return beneficiaryDirectory;
    }

    public void setBeneficiaryDirectory(BeneficiaryDirectory beneficiaryDirectory) {
        this.beneficiaryDirectory = beneficiaryDirectory;
    }

    public BankAccountDirectory getBankAccountDirectory() {
        return bankAccountDirectory;
    }

    public void setBankAccountDirectory(BankAccountDirectory bankAccountDirectory) {
        this.bankAccountDirectory = bankAccountDirectory;
    }
}
