package com.example.homework.controllers;

import com.example.homework.entities.Bloc;
import com.example.homework.services.IBlocService;
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
@RequestMapping("bloc")
public class BlocController {
    @Autowired
    IBlocService iBlocService;

    @PostMapping("/addBloc")
    public Bloc addBloc(@RequestBody Bloc c){
        return iBlocService.addBloc(c);
    }

    @GetMapping("/getBlocById/{id}")
    public Bloc getBlocById(@PathVariable long id){
        return iBlocService.getBlocById(id);
    }

    @GetMapping("/GetBlocs")
    public List<Bloc> getBlocs(){
        return iBlocService.getBlocs();
    }

    @DeleteMapping("/deleteBlocById/{id}")
    public void deleteBlocById(@PathVariable long id){
        iBlocService.deleteBloc(id);
    }
    @PutMapping("/updateBloc")
    public Bloc updateBloc(@RequestBody Bloc c){
        return iBlocService.updateBloc(c);
    }
}
