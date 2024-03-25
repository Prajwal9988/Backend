package com.kinara.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String name;

    private Double totalMarks;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "class_room_id")
    private ClassRoom classRoom;
}
