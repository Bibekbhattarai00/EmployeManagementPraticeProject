package com.example.praticeprojectemployee.Controller;

import com.example.praticeprojectemployee.Dto.EmployeDto;
import com.example.praticeprojectemployee.Entity.EmployeEntity;
import com.example.praticeprojectemployee.Service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeController {

    private final EmployeService employeService;

    @Autowired
    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @PostMapping("/insert")
    public EmployeEntity addEmploye(@RequestBody EmployeDto employeDto){
        return employeService.insertEmploye(employeDto);

    }

    @GetMapping("/allEmploye")
    public List<EmployeEntity> allEmployee(){
        return employeService.getAllEmploye();
    }

    @GetMapping("/allEmployeByName")
    public List<EmployeEntity> allEmployeByName(@RequestParam String name){
        return employeService.getEmployeByName(name);
    }

    @GetMapping("/allEmployeById")
    public EmployeEntity allEmployeById(@RequestParam Long id){
        return employeService.getEmployeById(id);

    }

    @DeleteMapping("/delete")
    public String deleteEmploye(@RequestParam Long id){
        employeService.deleteEmploye(id);
        return "deleted";
    }

    @PatchMapping("/update")
    public EmployeEntity updateEmploye(@RequestBody EmployeDto employeDto) {
        return employeService.updateEmploye(employeDto);
    }
}
