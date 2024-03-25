package com.kinara.controller;

import com.kinara.service.serviceInterface.StudentServiceInterface;
import com.kinara.utils.StudentFilterTemplate;
import com.kinara.utils.StudentResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentServiceInterface studentServiceInterface;

    @Autowired
    StudentFilterTemplate studentFilterTemplate;

    @GetMapping("/students")
    public ResponseEntity<StudentResponse> getStudents(
            @RequestParam(required = false, defaultValue = "0") Integer pageNumber,
            @RequestParam(required = false, defaultValue = "25") Integer pageSize,
            @RequestParam(required = false, defaultValue = "studentId") String sortBy,
            @RequestParam(required = false, defaultValue = "ASC") String sortDirection,
            @RequestParam(required = false, defaultValue = "") String searchByName,
            @RequestParam(required = false) Long searchByRollNumber,
            @RequestParam(required = false, defaultValue = "") String className
    ) throws BadRequestException {
        studentFilterTemplate.setSearchByName(searchByName);
        studentFilterTemplate.setClassName(className);
        if(searchByRollNumber != null) studentFilterTemplate.setSearchByRollNumber(searchByRollNumber);

        StudentResponse studentResponse = studentServiceInterface.getAllStudents(pageNumber, pageSize, sortBy, sortDirection, studentFilterTemplate);
        return ResponseEntity.ok(studentResponse);
    }
}
