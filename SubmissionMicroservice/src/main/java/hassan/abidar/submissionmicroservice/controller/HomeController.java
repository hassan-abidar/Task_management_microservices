package hassan.abidar.submissionmicroservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {

    @GetMapping("/submission")

    public ResponseEntity<String> Home (){
        return new ResponseEntity<>("Hello Home", HttpStatus.OK);
    }
}
