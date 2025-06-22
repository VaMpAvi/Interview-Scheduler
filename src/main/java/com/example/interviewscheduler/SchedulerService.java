package com.example.interviewscheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchedulerService {
    @Autowired
    private InterviewerRepository interviewerRepository;

    @Autowired
    private InterviewRepository interviewRepository;

    @Autowired
    private PositionRepository positionRepository;

    List<Interviewer> getAllInterviewer(){
        return interviewerRepository.findAll();
    }

//    List<Position> getAllPosition1(){
//        return positionRepository.findAll();
//    }

    void saveInterviewDetails(Interview interview){
        interviewRepository.save(interview);
    }

    List<String> getAllInterviewerEmails(){
        return interviewerRepository.findAllEmails();
    }

    List<String> getAllPosition(){
        return positionRepository.findAllPositons();
    }
}
