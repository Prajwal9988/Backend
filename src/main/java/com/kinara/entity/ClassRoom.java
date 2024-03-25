package com.kinara.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long classId;
    private String name;
    private Integer floor;

    @Override
    public String toString(){
        return "classId: " + classId + " className: " + name + " Floor: " + floor;
    }
}
