package com.scotiabank.challengue.service;

import com.scotiabank.challengue.controller.request.StudentRequest;
import com.scotiabank.challengue.controller.response.StudentCreateResponse;

import reactor.core.publisher.Mono;

public interface StudentService {
    Mono<StudentCreateResponse> createStudent(StudentRequest request);
}
