/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.BankAccount;
import Business.Utilities.Utilities;
import java.util.ArrayList;

/**
 *
 * @author amitha.murali
 */
public class BankAccountDirectory {
     private ArrayList<BankAccount> bankAccountList;

    public ArrayList<BankAccount> getBankAccountList() {
        return bankAccountList;
    }

    public void setBankAccountList(ArrayList<BankAccount> bankAccountList) {
        this.bankAccountList = bankAccountList;
    }

    public BankAccountDirectory() {
        bankAccountList = new ArrayList<>();
    }
    
    public BankAccount createBankAccount(BankAccount.Type type, int accountNumber, int routingNumber){             
        
        BankAccount bankAccount = new BankAccount(accountNumber,routingNumber);
        bankAccount.setBankAccountType(type); 
        bankAccountList.add(bankAccount);
        
       return bankAccount;
    }
    
     public void removeBankAccount(BankAccount ba){
        bankAccountList.remove(ba);
    }
    
    public BankAccount searchBankAccount(int accountNumber,int routingNumber){
        for (BankAccount ba : bankAccountList) {
            if(ba.getAccountNumber()==accountNumber && ba.getRoutingNumber() == routingNumber){
                return ba;
            }
        }
        return null;
    }
    
       
}
