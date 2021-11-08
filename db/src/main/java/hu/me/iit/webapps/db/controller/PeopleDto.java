package hu.me.iit.webapps.db.controller;



import hu.me.iit.webapps.db.service.People;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class PeopleDto {
    private long id;
    @NotEmpty
    private String name;
    @Size(min=18)
    private int age;

    public PeopleDto() {
    }

    public PeopleDto(People people){
        this.id=people.getId();
        this.age=people.getAge();
        this.name=people.getName();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
