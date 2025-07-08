package com.scotiabank.challengue.model;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor 
@Document(collection = "student")
public class StudentEntity {
    private String id = UUID.randomUUID().toString();

    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private boolean estado;
    
}
