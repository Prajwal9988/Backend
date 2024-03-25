package com.kinara.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Data
@Component
@NoArgsConstructor
public class StudentFilterTemplate {
    private String searchByName;
    private Long searchByRollNumber;
    private String className;
}
