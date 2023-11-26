package com.example.homework.controllers;

import com.example.homework.entities.Foyer;
import com.example.homework.services.IFoyerService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("foyer")
public class FoyerController {
    @Autowired
    IFoyerService iFoyerService;

    @PostMapping("/addFoyer")
    public Foyer addFoyer(@RequestBody Foyer f){
        return iFoyerService.addFoyer(f);
    }

    @GetMapping("/getFoyers")
    public Iterable<Foyer> getFoyers(){
        return iFoyerService.getFoyers();
    }

    @GetMapping("/getFoyerById/{id}")
    public Foyer getFoyerById(@PathVariable long id){
        return iFoyerService.getFoyerById(id);
    }

    @DeleteMapping("/deleteFoyerById/{id}")
    public void deleteFoyerById(@PathVariable long id){
        iFoyerService.deleteFoyer(id);
    }

    @PutMapping("/updateFoyer")
    public Foyer updateFoyer(@RequestBody Foyer f) {
        return iFoyerService.updateFoyer(f);
    }

}
