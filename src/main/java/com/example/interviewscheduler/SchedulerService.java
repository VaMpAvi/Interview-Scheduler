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

    @Autowired
    private EmailService emailService;

    void saveInterviewDetails(Interview interview){
        Interview savedinterview = interviewRepository.save(interview);

        String subject = "Interview Scheduled: " + savedinterview.getPosition();
        String bodyCandidate = "Dear Candidate,\n\nYour interview for the position of " + savedinterview.getPosition() +
                " is scheduled on " + savedinterview.getInterviewDate() + " at " + savedinterview.getInterviewTime() +
                ".\nLocation/Link/Contact: " + savedinterview.getContact();
        String bodyInterviewer = "Dear Interviewer,\n\nYou have an interview scheduled with " +
                savedinterview.getCandidateEmail() + " for the position of " + savedinterview.getPosition() +
                " on " + savedinterview.getInterviewDate() + " at " + savedinterview.getInterviewTime() +
                ".\nLocation/Link/Contact: " + savedinterview.getContact();

        emailService.sendEmail(savedinterview.getInterviewerEmail(), subject, bodyInterviewer);
        emailService.sendEmail(savedinterview.getCandidateEmail(), subject, bodyCandidate);

    }

    List<String> getAllInterviewerEmails(){
        return interviewerRepository.findAllEmails();
    }

    List<String> getAllPosition(){
        return positionRepository.findAllPositons();
    }

}
