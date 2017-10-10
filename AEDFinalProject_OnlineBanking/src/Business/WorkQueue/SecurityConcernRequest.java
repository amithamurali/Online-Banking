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
public class SecurityConcernRequest extends WorkRequest{
    
    private Type securitySeverity; 
    private String action;
    
    public static final String OPEN = "Open";
    public static final String PENDING = "Pending";
    public static final String RESOLVED = "Resolved";
    public static final String DEFERRED = "DEFERRED";
    
    public SecurityConcernRequest(Type securitySeverity)
    {
       this.securitySeverity = securitySeverity;
    }

    public Type getSecuritySeverity() {
        return securitySeverity;
    }

    public void setSecuritySeverity(Type securitySeverity) {
        this.securitySeverity = securitySeverity;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
    
     public enum Type{
        High("High"), Medium("Medium"),Low("Low");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    
}
