package com.ibyte.rhapi.controllers;


import com.ibyte.rhapi.models.Departament;
import com.ibyte.rhapi.services.DepartamentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping({"/departament"})
public class DeparatamentController {

    @Autowired
    private DepartamentService departamentService;


    @GetMapping
    @ApiOperation(value = "Retorna Lista de departamentos")
    public List<Departament> listAllDepartament() {

        return departamentService.getAllDepartaments();
    }

    @GetMapping(path = {"/{id}"})
    @ApiOperation(value = "Retorna um departamento através do Id")
    public ResponseEntity<Departament> listOneDepartament(@PathVariable(value = "id") long departamentId) {
        return departamentService.getDepartamentById(departamentId);
    }

    @PostMapping
    @ApiOperation(value = "Cria um novo departamento")
    public ResponseEntity<Departament>  createDepartament(@Valid @RequestBody Departament departament) {
        return ResponseEntity.ok().body(departamentService.createDepartament(departament));
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Atualiza um departamento existente através do Id")
    public ResponseEntity<Departament> updateDepartament(@Valid @PathVariable("id") long departamentId,
                                                         @RequestBody Departament departament) {
        departament.setId(departamentId);
        return departamentService.updateDepartament(departament);
    }

    @DeleteMapping(path = {"/{id}"})
    @ApiOperation(value = "Deleta um departamento através do Id")
    public ResponseEntity<?> deleteDepartament(@PathVariable("id") long departamentId) {
        return departamentService.deleteDepartament(departamentId);
    }
}