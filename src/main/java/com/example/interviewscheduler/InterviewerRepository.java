package com.example.interviewscheduler;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InterviewerRepository extends JpaRepository<Interviewer, Integer> {
    @Query(value = "SELECT email FROM interviewpanel", nativeQuery = true)
    List<String> findAllEmails();
}
