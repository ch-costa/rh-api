package com.ibyte.rhapi.controllers;

import com.ibyte.rhapi.models.Employer;
import com.ibyte.rhapi.services.EmployerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping({"/employer"})
public class EmployerController {

    @Autowired
    private EmployerService employerService;


    @GetMapping
    @ApiOperation(value = "Retorna Lista de empregados")
    public List<Employer> listAllEmployer() {
        return employerService.getAllEmployees();
    }

    @GetMapping(path = {"/{id}"})
    @ApiOperation(value = "Retorna um empregado através do Id")
    public ResponseEntity<Employer> listOneEmployer(@PathVariable(value = "id") long employerId) {
        return employerService.getEmployerById(employerId);
    }

    @PostMapping
    @ApiOperation(value = "Cria um novo empregado")
    public ResponseEntity<Employer> createEmployer(@Valid @RequestBody Employer employer) {
        return ResponseEntity.ok().body(employerService.createEmployer(employer));
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Atualiza um empregado existente através do Id")
    public ResponseEntity<Employer> UpdateEmployer(@Valid @PathVariable("id") long employerId,
                                                   @RequestBody Employer employer) {
        employer.setId(employerId);
        return employerService.updateEmployer(employer);
    }

    @DeleteMapping(path = {"/{id}"})
    @ApiOperation(value = "Deleta um empregado através do Id")
    public ResponseEntity<?> deleteEmployer(@PathVariable("id") long employerId) {
        return employerService.deleteEmployer(employerId);
    }
}
