package com.example.interviewscheduler;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "interview")
@Data
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int interview_id;

    @Column
    private String interviewerEmail;


    private String candidateEmail;

    @Column
    private LocalTime interviewTime;

    @Column
    private LocalDate interviewDate;

    @Column
    private String position;

    @Column
    private String interviewType;

    @Column
    private String contact;

    @Column
    private String resumeLink;
}
