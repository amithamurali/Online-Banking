/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;


/**
 *
 * @author amitha.murali
 */
public abstract class Person {
    
     private int personID;
    private static int counter;
    private String personName;
    private Type personType;
    private String personAddress;
    private int personAge;

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public Type getPersonType() {
        return personType;
    }

    public void setPersonType(Type personType) {
        this.personType = personType;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getPersonID() {
        return personID;
    }

    public String getPersonName() {
        return personName;
    }
    
     public Person(String name, Type type) {
        this.personName = name;   
        this.personType = type;
        ++counter;
        personID = counter;
        
    }
    
     public enum Type{
        Employee("Employee"), Customer("Customer");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
     
      @Override
    public String toString() {
        return personName;
    }
    
}
