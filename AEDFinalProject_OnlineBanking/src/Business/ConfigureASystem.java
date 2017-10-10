package Business;

import Business.Person.Person;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author amitha.murali
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        
        Person personRecord = system.getPersonDirectory().createPerson(Person.Type.Employee, "SystemAdmin");
        
        UserAccount userAccount = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", personRecord, new SystemAdminRole());
        
        return system;
    }
    
}
