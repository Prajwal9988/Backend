package com.kinara.service.serviceInterface;

import com.kinara.entity.Student;
import com.kinara.utils.StudentFilterTemplate;
import com.kinara.utils.StudentResponse;
import org.apache.coyote.BadRequestException;

import java.util.*;

public interface StudentServiceInterface {
    public StudentResponse getAllStudents(Integer pageNumber, Integer pageSize, String sortBy, String sortDirection, StudentFilterTemplate studentFilterTemplate) throws BadRequestException;
}
