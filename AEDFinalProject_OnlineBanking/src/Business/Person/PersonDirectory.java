/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;
import java.util.ArrayList;

/**
 *
 * @author amitha.murali
 */
public class PersonDirectory {
    
    private ArrayList<Person> personList;

    public PersonDirectory() {
        personList = new ArrayList<>();
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }
    
    public Person createPerson(Person.Type type, String name){
        Person person = null;
        if (type.getValue().equals(Person.Type.Employee.getValue())){
           person = new Employee(name);
            personList.add(person);
        }
        else if (type.getValue().equals(Person.Type.Customer.getValue())){
           person = new Customer(name);
            personList.add(person);
        }
        return person;
    }
    
       
    
    public void removeCustomer(Customer customer){
        personList.remove(customer);
    }
    
     public void removeEmployee(Employee employee){
        personList.remove(employee);
    }
    
    public Person searchPerson(String keyword,String personType){
        for (Person person : personList) {
            if(person.getPersonName().equals(keyword) && person.getPersonType().toString().equals(personType)){
                return person;
            }
        }
        return null;
    }
    
    
   }