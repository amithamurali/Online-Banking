/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author amitha.murali
 */
public class BankEnterprise extends Enterprise{

    public BankEnterprise(String name,int branchRoutingNumber,String location) {
        super(name, EnterpriseType.Bank,branchRoutingNumber, location);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
