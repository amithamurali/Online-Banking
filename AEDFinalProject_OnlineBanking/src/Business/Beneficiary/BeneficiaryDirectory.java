/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Beneficiary;
import java.util.ArrayList;

/**
 *
 * @author amitha.murali
 */
public class BeneficiaryDirectory {
    
    ArrayList<Beneficiary> beneficiaryList;
    
    public BeneficiaryDirectory()
    {
        beneficiaryList = new ArrayList<>();
    }
    
     public Beneficiary createBeneficiary(){
        Beneficiary beneficiary = new Beneficiary();        
        beneficiaryList.add(beneficiary);        
       return beneficiary;
    }

    public ArrayList<Beneficiary> getBeneficiaryList() {
        return beneficiaryList;
    }

    public void setBeneficiaryList(ArrayList<Beneficiary> beneficiaryList) {
        this.beneficiaryList = beneficiaryList;
    }
    
     public void removeBeneficiary(Beneficiary be){
        beneficiaryList.remove(be);
    }
}
