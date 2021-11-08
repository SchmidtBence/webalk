package hu.me.iit.webapps.db.service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class People {

    private Long id;

    private int age;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public People() {
    }


    public People(hu.me.iit.webapps.db.repository.People people){
        this.age=people.getAge();
        this.name=people.getName();
        this.id=people.getId();
    }

    public People(Long id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public hu.me.iit.webapps.db.repository.People people(){

    }
}
