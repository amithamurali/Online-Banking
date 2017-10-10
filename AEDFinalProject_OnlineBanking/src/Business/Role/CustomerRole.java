/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Beneficiary.BeneficiaryDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.CustomerRole.CustomerAuthenticationJPanel;
import javax.swing.JPanel;

/**
 *
 * @author amitha.murali
 */
public class CustomerRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new CustomerAuthenticationJPanel(userProcessContainer, enterprise,account);
        
    }    
//    private BeneficiaryDirectory beneficiaryDirectory;
//    
//    public CustomerRole()
//    {
//        beneficiaryDirectory = new BeneficiaryDirectory();
//    }
}
