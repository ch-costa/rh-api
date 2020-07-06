package com.ibyte.rhapi.services;

import com.ibyte.rhapi.models.Departament;
import com.ibyte.rhapi.repositories.DepartamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DepartamentServiceImpl implements DepartamentService {

    @Autowired
    private DepartamentRepository departamentRepository;


    @Override
    public Departament createDepartament(Departament departament) {
        return departamentRepository.save(departament);
    }

    @Override
    public ResponseEntity<Departament> updateDepartament(Departament departament) {
        return departamentRepository.findById(departament.getId())
                .map(record ->{
                    record.setDescDepartament(departament.getDescDepartament());
                    Departament depUpdated = departamentRepository.save(record);
                    return ResponseEntity.ok().body(depUpdated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public List<Departament> getAllDepartaments() {
        return departamentRepository.findAll();
    }

    @Override
    public ResponseEntity<Departament> getDepartamentById(long departamentId) {
        return departamentRepository.findById(departamentId)
                .map(departament -> ResponseEntity.ok().body(departament))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<?> deleteDepartament(long departamentId) {
        return departamentRepository.findById(departamentId)
                .map(departament -> {
                    departamentRepository.deleteById(departamentId);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
