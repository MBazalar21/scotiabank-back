package com.scotiabank.challengue.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.scotiabank.challengue.controller.request.StudentRequest;
import com.scotiabank.challengue.controller.response.StudentCreateResponse;
import com.scotiabank.challengue.model.StudentEntity;

@Mapper(componentModel = "spring")
public interface AbstractMapperStudent {

    StudentEntity toEntity(StudentRequest request);

    @Mapping(source="id",target="id")
    StudentCreateResponse toCreateResponse(StudentEntity entity);
}
