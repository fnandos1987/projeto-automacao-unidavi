/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author fernando.schwambach
 */
public class Person {
    
    private String name;
    private String address;
    private String hobbies;

    public Person() {
    }    

    public Person(String name, String address, String hobbies) {
        this.name = name;
        this.address = address;
        this.hobbies = hobbies;
    }  

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }
    
}
