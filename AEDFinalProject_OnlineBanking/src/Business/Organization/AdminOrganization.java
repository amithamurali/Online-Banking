/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.BankManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author amitha.murali
 */
public class AdminOrganization extends Organization{

    public AdminOrganization() {
        super(Type.Admin.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new BankManagerRole());
        return roles;
    }
     
}
