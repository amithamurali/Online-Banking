/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import java.util.ArrayList;

/**
 *
 * @author amitha.murali
 */
public abstract class Enterprise extends Organization{

    private EnterpriseType enterpriseType;
    private int branchRoutingNumber;
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    private ArrayList<String> securityQuestion;

    public ArrayList<String> getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(ArrayList<String> securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public int getBranchRoutingNumber() {
        return branchRoutingNumber;
    }

    public void setBranchRoutingNumber(int branchRoutingNumber) {
        this.branchRoutingNumber = branchRoutingNumber;
    }
    private OrganizationDirectory organizationDirectory;
    
    public Enterprise(String name, EnterpriseType type,int branchRoutingNumber,String location) {
        super(name);
        this.enterpriseType = type;
        this.branchRoutingNumber = branchRoutingNumber;
        this.location = location;
        organizationDirectory = new OrganizationDirectory();
        securityQuestion = new ArrayList<>();
        securityQuestion.add("What is your mother's maiden name?");
        securityQuestion.add("Which city were you born in?");
        securityQuestion.add("What was your first pet's name?");
        securityQuestion.add("who is your childhood superhero?");
    }
    
    public enum EnterpriseType{
        Bank("Bank");
        
        private String value;

        private EnterpriseType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

}
