package com.scotiabank.challengue.service.impl;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Service;

import com.scotiabank.challengue.controller.request.StudentRequest;
import com.scotiabank.challengue.controller.response.StudentCreateResponse;
import com.scotiabank.challengue.mappers.AbstractMapperStudent;
import com.scotiabank.challengue.model.StudentEntity;
import com.scotiabank.challengue.repository.StudentRepository;
import com.scotiabank.challengue.service.StudentService;

import reactor.core.publisher.Mono;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;
    private final AbstractMapperStudent mapperStudent;

    public StudentServiceImpl(StudentRepository repository,AbstractMapperStudent mapperStudent){
        this.repository = repository;
        this.mapperStudent = mapperStudent;
    }
    
    @Override
    public Mono<StudentCreateResponse> createStudent(StudentRequest request){
        StudentEntity entity = this.mapperStudent.toEntity(request);
        return this.repository.save(entity).map(ent -> {
            StudentCreateResponse response = this.mapperStudent.toCreateResponse(ent);
            System.out.println(response.getId());
            System.out.println(response.getNombre());
            System.out.println(response.getApellido());
            response.setEdad(calcularEdad(ent.getFechaNacimiento()));
            response.setEstado(true);
            return response;
        });
    }

    private int calcularEdad(LocalDate fechaNacimiento) {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }
}
