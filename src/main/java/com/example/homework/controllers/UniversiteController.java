package com.example.homework.controllers;

import com.example.homework.entities.Foyer;
import com.example.homework.entities.Universite;
import com.example.homework.services.IUniversiteService;
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
@RequestMapping("universite")
public class UniversiteController {
    @Autowired
    IUniversiteService iUniversiteService;

    @PostMapping("/addUniversite")
    public Universite addUniversite(@RequestBody Universite r){
        return iUniversiteService.addUniversite(r);
    }

    @GetMapping("/getUniversites")
    public Iterable<Universite> getUniversites(){
        return iUniversiteService.getUniversites();
    }

    @GetMapping("/getUniversiteById/{id}")
    public Universite geUniversiteById(@PathVariable long id){
        return iUniversiteService.getUniversiteById(id);
    }

    @DeleteMapping("/deleteUniversiteById/{id}")
    public void deleteUniversiteById(@PathVariable long id){
        iUniversiteService.deleteUniversite(id);
    }

    @PutMapping("/updateUniversite")
    public Universite updateUniversite(@RequestBody Universite r) {
        return iUniversiteService.updateUniversite(r);
    }



}
