package com.scotiabank.challengue.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.scotiabank.challengue.model.StudentEntity;
import reactor.core.publisher.Mono;

public interface StudentRepository extends ReactiveMongoRepository<StudentEntity, String>{
    Mono<StudentEntity> save(StudentEntity student);
}
