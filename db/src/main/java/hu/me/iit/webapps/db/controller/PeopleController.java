package hu.me.iit.webapps.db.controller;


import hu.me.iit.webapps.db.service.People;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import hu.me.iit.webapps.db.service.PeopleService;

import javax.validation.Valid;

@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    public Iterable<PeopleDto> getallPeople(){
        List<PeopleDto>peopleDtoList=new ArrayList<>();
        for (People people : peopleService.getAllPeople())
        {
            peopleDtoList.add(new PeopleDto(people));
        }
        return peopleDtoList;
    }

    @PostMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public PeopleDto save(@RequestBody @Valid PeopleCreateDto peopleCreateDto){
        return new PeopleDto(peopleService.create(peopleCreateDto.toPeople()));
    }


}
