package com.example.interviewscheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("/scheduler/api")
public class ScheduleController {

    @Autowired
    private SchedulerService schedulerService;

    @GetMapping("/interviewers")
    public List<String> getAllInterviewers(){
        return schedulerService.getAllInterviewerEmails();
    }

    @GetMapping("/positions")
    public List<String> getAllPositions(){
        return schedulerService.getAllPosition();
    }

    @PostMapping("/interview")
    ResponseEntity<Map<String,String>> scheduleInterview(@RequestBody Interview interview){
        schedulerService.saveInterviewDetails(interview);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Interview has been saved successfully");

        return ResponseEntity.ok(response);
    }
}
