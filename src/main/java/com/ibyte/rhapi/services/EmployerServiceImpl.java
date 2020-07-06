package com.ibyte.rhapi.services;

import com.ibyte.rhapi.models.Employer;
import com.ibyte.rhapi.repositories.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployerServiceImpl  implements EmployerService{

    @Autowired
    private EmployerRepository employerRepository;

    @Override
    public Employer createEmployer(Employer employer) {
        return employerRepository.save(employer);
    }

    @Override
    public ResponseEntity<Employer> updateEmployer(Employer employer) {
        return employerRepository.findById(employer.getId())
                .map(record -> {
                    record.setFirstName(employer.getFirstName());
                    record.setLastName(employer.getLastName());
                    record.setCareer(employer.getCareer());
                    record.setDepartament(employer.getDepartament());
                    Employer empUpdated = employerRepository.save(record);
                    return ResponseEntity.ok().body(empUpdated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public List<Employer> getAllEmployees() {
        return employerRepository.findAll();
    }

    @Override
    public ResponseEntity<Employer> getEmployerById(long employerId) {
        return employerRepository.findById(employerId)
                .map(employer -> ResponseEntity.ok().body(employer))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<?> deleteEmployer(long employerId) {
        return employerRepository.findById(employerId)
                .map(employer -> {
                    employerRepository.deleteById(employerId);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
