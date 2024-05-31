package hassan.abidar.taskuserservice.controller;

import hassan.abidar.taskuserservice.model.User;
import hassan.abidar.taskuserservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<User> getUserProfile(
            @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.getUserProfile(jwt);
        return new ResponseEntity<User> (user, HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers(
           @RequestHeader("Authorization") String jwt
    ){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<List<User>>(users,HttpStatus.OK);
    }
}
