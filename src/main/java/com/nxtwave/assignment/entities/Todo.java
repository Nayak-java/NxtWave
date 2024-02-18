package com.nxtwave.assignment.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TODOLIST")
@Setter
@Getter
@EqualsAndHashCode(exclude = "id")
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "of")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String todo;
    private String status;
    private String priority;
}
