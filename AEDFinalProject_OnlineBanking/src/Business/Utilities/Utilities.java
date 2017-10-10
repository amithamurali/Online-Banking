/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Utilities;
import java.util.Random;

/**
 *
 * @author amitha.murali
 */
public class Utilities {
    
    public static int RandomInteger(){
  
  
    //Generating 10 random integers in range 0..99.
    int randomInt = 0;
    //note a single Random object is reused here
    Random randomGenerator = new Random();
    //Generate 8 digit numbers from 10000000 to 99999999
   // for (int idx = 1; idx <= 10; ++idx){
      randomInt = 10000000 + randomGenerator.nextInt(899999999);     
   // }
   return  randomInt;
}
// ?=.*[0-9]) a digit must occur at least once
//(?=.*[a-z]) a lower case letter must occur at least once
//(?=.*[A-Z]) an upper case letter must occur at least once
//(?=.*[@#$%^&+=]) a special character must occur at least once
//(?=\\S+$) no whitespace allowed in the entire string
//.{8,} at least 8 characters
    public static boolean passwordvalidation(String password){  
    boolean isValid = false;
    String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{5,10}";
    if(password.matches(pattern))
    {
        isValid = true;
    }
  
return isValid;
}
}
