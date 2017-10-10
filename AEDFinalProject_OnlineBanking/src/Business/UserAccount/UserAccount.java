/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;


import Business.Person.Person;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author amitha.murali
 */
public class UserAccount {
    
    private BigInteger encryptedPassword;
    private String username;
   // private String password;
    private Person person;
    private Role role;
    private String securityQuestion;
    private String securityAnswer;
    private ArrayList<String> whiteListIPs;

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public BigInteger getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(BigInteger encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }
    private WorkQueue workQueue;

    public UserAccount() {
        workQueue = new WorkQueue();
         whiteListIPs = new ArrayList<String>();
    }

    public ArrayList<String> getWhiteListIPs() {
        return whiteListIPs;
    }

    public void setWhiteListIPs(ArrayList<String> whiteListIPs) {
        this.whiteListIPs = whiteListIPs;
    }
    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

  //  public String getPassword() {
    //    return password;
    //}

    //public void setPassword(String password) {
      //  this.password = password;
    //}

    public Role getRole() {
        return role;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Person getPerson() {
        return person;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    
    
    @Override
    public String toString() {
        return username;
    }
    
    
    
}