package com.example.praticeprojectemployee.Service.Implementation;

import com.example.praticeprojectemployee.Dto.EmployeDto;
import com.example.praticeprojectemployee.Entity.EmployeEntity;
import com.example.praticeprojectemployee.Exceptions.NotFound;
import com.example.praticeprojectemployee.Repo.EmployeRepo;
import com.example.praticeprojectemployee.Service.EmployeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeServiceImpl implements EmployeService {
    @Autowired
    private EmployeRepo employeRepo;


    @Autowired
    ObjectMapper objectMapper;



//    public EmployeServiceImpl(EmployeRepo employeRepo) {
//        this.employeRepo = employeRepo;
//    }

    @Override
    public EmployeEntity insertEmploye(EmployeDto employeDto) {
        EmployeEntity employeEntity=new EmployeEntity();
        employeEntity=objectMapper.convertValue(employeDto,EmployeEntity.class);
         return employeRepo.save(employeEntity);
    }

    public static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for(PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        return emptyNames.toArray(new String[0]);
    }

    @Override
    public EmployeEntity updateEmploye(EmployeDto employeDto) {
        EmployeEntity employe=employeRepo.findById(employeDto.getId()).orElseThrow(()->new NotFound("Not Found"));
//        employe=objectMapper.convertValue(employeDto,EmployeEntity.class);
        BeanUtils.copyProperties(employeDto, employe, getNullPropertyNames(employeDto));
        return employeRepo.save(employe);
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
