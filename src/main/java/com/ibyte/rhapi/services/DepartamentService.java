package com.ibyte.rhapi.services;

import com.ibyte.rhapi.models.Departament;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DepartamentService {

    Departament createDepartament( Departament departament);
    ResponseEntity<Departament> updateDepartament(Departament departament);
    List<Departament> getAllDepartaments();
    ResponseEntity<Departament> getDepartamentById(long departamentId);
    ResponseEntity<?> deleteDepartament(long departamentId);
}
