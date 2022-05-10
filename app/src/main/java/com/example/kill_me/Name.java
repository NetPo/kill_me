package com.example.kill_me;

public class Name {
    private String naming;
    private String age;

    public Name(){

    }
    public Name(String naming, String age){
        this.naming = naming;
        this.age = age;
    }

    public String getNaming() {
        return naming;

    }

    public String getAge() {
        return age;

    }

    public void setNaming(String naming) {
        this.naming = naming;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
