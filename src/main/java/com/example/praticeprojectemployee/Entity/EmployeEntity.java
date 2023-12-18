package com.example.praticeprojectemployee.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employe")
public class EmployeEntity {
@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    String address;
    String gender;
    String email;
}
