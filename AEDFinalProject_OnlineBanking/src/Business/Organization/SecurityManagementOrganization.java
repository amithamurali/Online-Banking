/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.SecurityOfficier;
import java.util.ArrayList;

/**
 *
 * @author amitha.murali
 */
public class SecurityManagementOrganization extends Organization{

    public SecurityManagementOrganization() {
        super(Organization.Type.SecurityManagement.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new SecurityOfficier());
        return roles;
    }
    
}
