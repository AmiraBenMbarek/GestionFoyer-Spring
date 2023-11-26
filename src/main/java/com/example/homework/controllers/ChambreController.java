package com.example.homework.controllers;

import com.example.homework.entities.Chambre;
import com.example.homework.entities.typeChambre;
import com.example.homework.services.IChambreService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("chambre")
public class ChambreController {
    @Autowired
    IChambreService iChambreService;

    @PostMapping("/addChambre")
    public Chambre addChambre(@RequestBody Chambre c){
        return iChambreService.addChambre(c);
    }

    @GetMapping("/getChambreById/{id}")
    public Chambre getChambreById(@PathVariable long id){
        return iChambreService.getChambreById(id);
    }

    @GetMapping("/getChambres")
    public Iterable<Chambre> getChambres(){
        return iChambreService.getChambres();
    }

    @DeleteMapping("/deleteChambreById/{id}")
    public void deleteChambreById(@PathVariable long id){
        iChambreService.deleteChambre(id);
    }

    @PutMapping("/updateChambre")
    public Chambre updateChambre(@RequestBody Chambre c){
        return iChambreService.updateChambre(c);
    }

    @GetMapping("/findByNumCh")
    public Chambre findByNumCh(@RequestBody Chambre c) {
        return iChambreService.findByNumCh(c);
    }}
