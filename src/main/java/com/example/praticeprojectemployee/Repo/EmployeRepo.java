package com.example.praticeprojectemployee.Repo;

import com.example.praticeprojectemployee.Entity.EmployeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeRepo extends JpaRepository<EmployeEntity, Long> {
    List<EmployeEntity> findByName(String name);
}
