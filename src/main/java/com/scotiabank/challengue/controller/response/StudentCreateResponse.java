package com.scotiabank.challengue.controller.response;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor 
public class StudentCreateResponse {
    private String id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private int edad;
    private boolean estado;
}
