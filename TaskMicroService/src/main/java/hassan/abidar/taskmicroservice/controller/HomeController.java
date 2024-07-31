package hassan.abidar.taskmicroservice.controller;

import hassan.abidar.taskmicroservice.modal.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {
    @GetMapping("/tasks")
    public ResponseEntity<String> getTaskById() throws Exception {

        return new ResponseEntity<>("Welcome to task service", HttpStatus.OK);
    }
}
