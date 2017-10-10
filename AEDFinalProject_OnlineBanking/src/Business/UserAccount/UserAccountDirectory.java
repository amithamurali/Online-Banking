/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Person.Person;
import Business.Role.Role;
import Business.Utilities.RSAEncryptionDecryption;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author amitha.murali
 */
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountList;
    RSAEncryptionDecryption rsa = new RSAEncryptionDecryption(1024); 
    
    public UserAccountDirectory() {
        userAccountList = new ArrayList<>();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public UserAccount authenticateUser(String username, String password){
                  
        for (UserAccount ua : userAccountList)
            if (ua.getUsername().equals(username))
            {                  
             
                if(ua.getEncryptedPassword() != null)
                {
               System.out.println("Decryptedtext: " + ua.getEncryptedPassword());
                BigInteger plaintext =  rsa.decrypt(ua.getEncryptedPassword());
                System.out.println("Plaintext: " + plaintext);
                String text2 = new String(plaintext.toByteArray());
                System.out.println("Plaintext.toByteArray: " + text2);
                  if(text2.equals(password))
                    {
                        return ua;
                    }
                }
                              
            }
        return null;
    }
    
    public UserAccount createUserAccount(String username, String password, Person person, Role role){
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
             
        
      System.out.println("password: " + password);
        BigInteger passwordText = new BigInteger(password.getBytes());
        System.out.println("passwordText: " + passwordText);
        BigInteger ciphertext = rsa.encrypt(passwordText);
       System.out.println("Ciphertext: " + ciphertext);
        userAccount.setEncryptedPassword(ciphertext);
        
        userAccount.setPerson(person);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    }
    
    public UserAccount createUserAccount(String username, String password, Person person, Role role, String securityQuestion, String securityAnswer){
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
                        
        BigInteger passwordText = new BigInteger(password.getBytes());
        System.out.println("PlainText: " + passwordText); 
        BigInteger ciphertext = rsa.encrypt(passwordText);
        System.out.println("Ciphertext: " + ciphertext);
        userAccount.setEncryptedPassword(ciphertext);
    
    
        userAccount.setPerson(person);
        userAccount.setRole(role);
        userAccount.setSecurityQuestion(securityQuestion);
        userAccount.setSecurityAnswer(securityAnswer);
        userAccountList.add(userAccount);
        return userAccount;
    }
    
    public boolean checkIfUsernameIsUnique(String username){
        for (UserAccount ua : userAccountList){
            if (ua.getUsername().equals(username))
                return false;
        }
        return true;
    }
    
     public void removeUserAccount(UserAccount userAccount){
        userAccountList.remove(userAccount);
    }
     
      public UserAccount searchUserAccountBasedOnPerson(Person person){
        for (UserAccount userAccount : userAccountList) {
            if(userAccount.getPerson() == person){
                return userAccount;
            }
        }
        return null;
    }
}
