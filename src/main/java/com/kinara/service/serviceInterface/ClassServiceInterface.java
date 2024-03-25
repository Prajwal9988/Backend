package com.kinara.service.serviceInterface;

import com.kinara.entity.ClassRoom;
import org.apache.coyote.BadRequestException;

public interface ClassServiceInterface {
    public ClassRoom getClassRoom(String className) throws BadRequestException;
}
