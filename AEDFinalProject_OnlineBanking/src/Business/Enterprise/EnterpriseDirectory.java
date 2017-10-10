/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Person.Person;
import java.util.ArrayList;

/**
 *
 * @author amitha.murali
 */
public class EnterpriseDirectory {
    
    private ArrayList<Enterprise> enterpriseDirectory;

    public EnterpriseDirectory() {
        enterpriseDirectory = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseDirectory;
    }
    
    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type,int routingNumber,String location){
        Enterprise enterprise = null;
        if (type == Enterprise.EnterpriseType.Bank){
           enterprise = new BankEnterprise(name,routingNumber,location);
            enterpriseDirectory.add(enterprise);
        }
        return enterprise;
    }
     public Enterprise searchEnterpriseList(String customerName){
        for (Enterprise e : enterpriseDirectory) {
          Person person =  e.getPersonDirectory().searchPerson(customerName,Person.Type.Customer.getValue());
          if(person != null)
                return e;            
           }
        
        return null;
    }
    
    }
