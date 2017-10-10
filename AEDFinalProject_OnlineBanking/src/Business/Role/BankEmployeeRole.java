/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.PersonalBankingOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.BankEmployeeRole.BankEmployeeWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author amitha.murali
 */
public class BankEmployeeRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
       return new BankEmployeeWorkAreaJPanel(userProcessContainer, account, (PersonalBankingOrganization)organization, enterprise);
       
    }
    
}
