/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Beneficiary.Beneficiary;

/**
 *
 * @author amitha.murali
 */
public class BeneficiaryWorkRequest extends WorkRequest{
    
   
    private Beneficiary beneficiary;

    
    public BeneficiaryWorkRequest(Beneficiary beneficiary)
    {
       this.beneficiary = beneficiary; 
    }
    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }
            
}

