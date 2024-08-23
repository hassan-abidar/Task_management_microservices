package hassan.abidar.submissionmicroservice.controller;

import hassan.abidar.submissionmicroservice.model.Submission;
import hassan.abidar.submissionmicroservice.model.UserDto;
import hassan.abidar.submissionmicroservice.service.SubmissionService;
import hassan.abidar.submissionmicroservice.service.TaskService;
import hassan.abidar.submissionmicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/submissions")

public class SubmissionController {
    @Autowired
    private SubmissionService submissionService;

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;


    @PostMapping()
    public ResponseEntity<Submission> submitTask(
            @RequestParam Long task_id,
            @RequestParam String github_link,
            @RequestHeader ("Authorization") String jwt
    ) throws Exception{
        UserDto user = userService.getUserProfile(jwt);
        Submission submission = submissionService.submitTask(task_id,github_link, user.getId(), jwt);
        return new ResponseEntity<Submission>(submission, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Submission> getSubmissionById(
            @PathVariable Long id,
            @RequestHeader ("Authorization") String jwt
    ) throws Exception{
        UserDto user = userService.getUserProfile(jwt);
        Submission submission = submissionService.getTaskSubmissionById(id);
        return new ResponseEntity<Submission>(submission, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Submission>> getAllSubmissions (
            @RequestHeader ("Authorization") String jwt
    )throws Exception{
        UserDto user = userService.getUserProfile(jwt);
        List<Submission> submissions = submissionService.getAllTaskSubmissions();
        return new ResponseEntity<List<Submission>>(submissions,HttpStatus.OK);
    }

    @GetMapping("/tasks/{task_id}")
    public ResponseEntity<List<Submission>> getTaskSubmissionsByTaskId (
            @PathVariable Long task_id,
            @RequestHeader ("Authorization") String jwt
    )throws Exception{
        UserDto user = userService.getUserProfile(jwt);
        List<Submission> submissions = submissionService.getTaskSubmissionsByTaskId(task_id);
        return new ResponseEntity<>(submissions, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Submission> acceptDeclineSubmission (
            @PathVariable Long id,
            @RequestParam String status,
            @RequestHeader ("Authorization") String jwt
    ) throws Exception{
        UserDto user = userService.getUserProfile(jwt);
        Submission submission = submissionService.acceptDeclineSubmission(id,status);
        return new ResponseEntity<>(submission,HttpStatus.OK);
    }

}
