package com.ibyte.rhapi.services;

import com.ibyte.rhapi.models.Employer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployerService {

    Employer createEmployer(Employer employer);
    ResponseEntity<Employer> updateEmployer(Employer employer);
    List<Employer> getAllEmployees();
    ResponseEntity<Employer> getEmployerById(long employerId);
    ResponseEntity<?> deleteEmployer(long employerId);

}
