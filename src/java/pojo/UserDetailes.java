/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

// POGO class jenerlly used to define some clear rule for declare a class like : variable must be private, must having default constructor, must having getter and setter method
// all rules define above is just for binding our softwear to rules and regulation

public class UserDetailes {
    private String username;
    private String address;
    private int age;
    private String gender;
    
    public UserDetailes() {
    }

    public UserDetailes(String username, String address, int age, String gender) {
        this.username = username;
        this.address = address;
        this.age = age;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
