package hassan.abidar.taskuserservice.service;

import hassan.abidar.taskuserservice.config.JwtProvider;
import hassan.abidar.taskuserservice.model.User;
import hassan.abidar.taskuserservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServiceImpl implements UserService{

    @Autowired
   private UserRepository userRepository;
    @Override
    public User getUserProfile(String jwt) throws Exception {
        String email = JwtProvider.getEmailFromJwtToken(jwt);
        if(email==null)
        {
            throw  new Exception("email not found");
        }
        User user = userRepository.findByEmail(email);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }
}
