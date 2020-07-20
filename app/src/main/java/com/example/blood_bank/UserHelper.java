package com.example.blood_bank;

public class UserHelper {

    String name,age,bloodgroup;

    public UserHelper(){


    }

    public UserHelper(String name, String age, String bloodgroup) {
        this.name = name;
        this.age = age;
        this.bloodgroup = bloodgroup;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }
}
