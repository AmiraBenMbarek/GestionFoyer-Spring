package com.example.homework.controllers;

import com.example.homework.entities.Etudiant;
import com.example.homework.services.IEtudiantService;
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
@RequestMapping("/etudiant")
public class EtudiantController {
    @Autowired
    IEtudiantService iEtudiantService;

    @PostMapping("/addEtudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        return iEtudiantService.addEtudiant(e);
    }

    @GetMapping("/getEtudiantById/{id}")
    public Etudiant getEtudiantById(@PathVariable long id) {
        return iEtudiantService.getEtudiantById(id);
    }

    @GetMapping("/getEtudiants")
    public Iterable<Etudiant> getEtudiants() {
        return iEtudiantService.getEtudiants();
    }

    @DeleteMapping("/deleteEtudiantById/{id}")
    public void deleteEtudiantById(@PathVariable long id) {
        iEtudiantService.deleteEtudiant(id);
    }

    @PutMapping("/updateEtudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {
        return iEtudiantService.updateEtudiant(e);
    }
}
