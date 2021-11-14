package hu.me.iit.webapps.db.controller;

import hu.me.iit.webapps.db.service.People;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class PeopleCreateDto {
    @NotEmpty
    private String name;
    @Size(min=18)
    private int age;

    public PeopleCreateDto() {
    }

    public PeopleCreateDto(People people){
        this.age=people.getAge();
        this.name=people.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public People toPeople(){
        return new People(null,age,name);
    }
}
