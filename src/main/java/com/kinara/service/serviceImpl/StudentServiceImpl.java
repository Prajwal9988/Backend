package com.kinara.service.serviceImpl;

import com.kinara.entity.ClassRoom;
import com.kinara.entity.Student;
import com.kinara.exception.DefaultException;
import com.kinara.repository.StudentRepo;
import com.kinara.service.serviceInterface.ClassServiceInterface;
import com.kinara.service.serviceInterface.StudentServiceInterface;
import com.kinara.utils.StudentFilterTemplate;
import com.kinara.utils.StudentResponse;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class StudentServiceImpl implements StudentServiceInterface {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ClassServiceInterface classService;

    private ClassRoom classRoom;

    @Override
    public StudentResponse getAllStudents(Integer pageNumber, Integer pageSize, String sortBy, String sortDirection, StudentFilterTemplate studentFilterTemplate) throws BadRequestException {
       try{
           String studentName = studentFilterTemplate.getSearchByName();
           String classRoomName = studentFilterTemplate.getClassName();
           Long rollNumber = studentFilterTemplate.getSearchByRollNumber();

           if(false)
               classRoom = classService.getClassRoom(classRoomName);

           // -------------------------- Configuring pagination object with either default values or custom values -----------------------------
           Pageable pageable = PageRequest.of(pageNumber, pageSize)
                              .withSort(Objects.equals(sortDirection, "ASC") ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy);

           // --------------------------------- Based on the available values Filter is applied ------------------------------------
           Page<Student> studentPages = studentRepo.findByClassAndNameAndRollNumber( studentName, rollNumber, classRoomName, pageable);

           if(studentPages == null || studentPages.isEmpty()) return new StudentResponse(new ArrayList<>(), 0);

           return new StudentResponse(studentPages.getContent(), studentPages.getTotalPages());

       }catch(BadRequestException e){
           e.printStackTrace();
           throw new BadRequestException(e.getMessage());
       }catch (Exception e){
           e.printStackTrace();
           throw new DefaultException("Something went wrong, Please try again later");
       }
    }
}
