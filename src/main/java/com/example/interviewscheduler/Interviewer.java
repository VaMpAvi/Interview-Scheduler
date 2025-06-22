package com.example.interviewscheduler;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "interviewpanel")
@Data
public class Interviewer {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String email;

    private String designation;
}
