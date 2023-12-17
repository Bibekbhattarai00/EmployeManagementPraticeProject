package com.example.praticeprojectemployee.Service;

import com.example.praticeprojectemployee.Dto.EmployeDto;
import com.example.praticeprojectemployee.Entity.EmployeEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeService {
    public  EmployeEntity insertEmploye(EmployeDto employeDto);
    public EmployeEntity updateEmploye(EmployeDto employeDto);
    public List<EmployeEntity> getAllEmploye();
    public List<EmployeEntity> getEmployeByName(String name);
    public EmployeEntity getEmployeById(Long id);
    public String deleteEmploye(Long id);


}
