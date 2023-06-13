package app.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.user.model.User;
import app.user.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    // @Autowired
    // private ContentRepository contentRepository;

    @GetMapping(value = "")
    public List<User> getAllApplications() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<User> getApplicationById(@PathVariable("id") String id) {
        return userRepository.findById(id);
    }

    @PostMapping(value = "")
    public User addNewApplication(@RequestBody User application){
        return userRepository.save(application);
    }

    @PutMapping(value = "/{id}")
    public User updateApplication(@PathVariable("id") String id, @RequestBody User user){
        user.setId(id);
        return userRepository.save(user);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteApplication(@PathVariable("id") String id) {
        userRepository.deleteById(id);
    }


}
