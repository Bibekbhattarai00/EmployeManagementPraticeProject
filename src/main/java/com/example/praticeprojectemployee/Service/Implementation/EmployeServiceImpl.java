package com.example.praticeprojectemployee.Service.Implementation;

import com.example.praticeprojectemployee.Dto.EmployeDto;
import com.example.praticeprojectemployee.Entity.EmployeEntity;
import com.example.praticeprojectemployee.Exceptions.NotFound;
import com.example.praticeprojectemployee.Repo.EmployeRepo;
import com.example.praticeprojectemployee.Service.EmployeService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeServiceImpl implements EmployeService {
    private final EmployeRepo employeRepo;

    @Autowired
    public EmployeServiceImpl(EmployeRepo employeRepo) {
        this.employeRepo = employeRepo;
    }

    @Override
    public EmployeEntity insertEmploye(EmployeDto employeDto) {
        EmployeEntity employeEntity=new EmployeEntity();
        employeEntity.setId(employeDto.getId());
        employeEntity.setName(employeDto.getName());
        employeEntity.setAddress(employeDto.getAddress());
        employeEntity.setEmail(employeDto.getEmail());
         return employeRepo.save(employeEntity);

    }

    @Override
    public EmployeEntity updateEmploye(EmployeDto employeDto) {
        EmployeEntity employe=employeRepo.findById(employeDto.getId()).orElseThrow(()->new NotFound("Not Found"));
        EmployeEntity employeEntity=new EmployeEntity();
//        employe.setId(employeEntity.getId());
        employe.setName(employeEntity.getName());
        employe.setAddress(employeEntity.getAddress());
        employe.setEmail(employeEntity.getEmail());
        return employeRepo.save(employeEntity);
    }

    @Override
    public List<EmployeEntity> getAllEmploye() {
        return employeRepo.findAll();
    }

    @Override
    public List<EmployeEntity> getEmployeByName(String name) {
        return employeRepo.findByName(name);
    }

    @Override
    public EmployeEntity getEmployeById(Long id) {
        return employeRepo.findById(id).orElseThrow(()->new NotFound("Employee Not Found"));
    }

    @Override
    public String deleteEmploye(Long id) {
        EmployeEntity employee=employeRepo.findById(id).orElseThrow(()-> new NotFound("Employe not found"));
        employeRepo.delete(employee);
        return "deleted";
    }
}
