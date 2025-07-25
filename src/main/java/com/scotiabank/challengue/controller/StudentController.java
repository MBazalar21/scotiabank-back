package com.scotiabank.challengue.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scotiabank.challengue.controller.request.StudentRequest;
import com.scotiabank.challengue.controller.response.StudentCreateResponse;
import com.scotiabank.challengue.service.StudentService;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/student")
@Validated
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public Mono<ResponseEntity<StudentCreateResponse>> createStudent(@Valid @RequestBody Mono<StudentRequest> request) {
        return request
            .flatMap(req -> studentService.createStudent(req))
                .map(res -> ResponseEntity.status(HttpStatus.CREATED).body(res));
    }
    
    
}
