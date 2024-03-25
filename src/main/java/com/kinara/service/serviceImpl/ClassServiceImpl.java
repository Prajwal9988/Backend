package com.kinara.service.serviceImpl;

import com.kinara.entity.ClassRoom;
import com.kinara.repository.ClassRepo;
import com.kinara.service.serviceInterface.ClassServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ClassServiceImpl implements ClassServiceInterface {
    @Autowired
    private ClassRepo classRepo;

    @Override
    public ClassRoom getClassRoom(String className) throws BadRequestException {
        log.info(className);
        ClassRoom classRoom = classRepo.findByName(className);
        log.info(classRoom.toString());
        if(classRoom == null) throw new BadRequestException("No Class Room found");
        return classRoom;
    }
}
