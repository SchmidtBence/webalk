package hu.me.iit.gyak.gyak.controller;

import hu.me.iit.gyak.gyak.service.LicitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class LicitController {

    private final LicitService licitService;

    public LicitController(LicitService licitService) {
        this.licitService = licitService;
    }

    @GetMapping("/licit/highest")
    public int getHighest() {
        return licitService.getHighest();
    }

    @GetMapping("/licit/highest/{userId}")
    public int getHighestForUser(@PathVariable int userId){
        return licitService.getHighestForUser(userId);
    }

    @PostMapping
    public void saveLicit(@Valid @RequestBody saveNewLicitDto saveNewLicitDto){
        licitService.saveNewLicit(saveNewLicitDto.getLicit(), saveNewLicitDto.getUserId());
    }
}
