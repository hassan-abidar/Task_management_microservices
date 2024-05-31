package hassan.abidar.taskuserservice.service;

import hassan.abidar.taskuserservice.model.User;

import java.util.List;

public interface UserService {
    public User getUserProfile(String jwt) throws Exception;
    public List<User> getAllUsers();
}
