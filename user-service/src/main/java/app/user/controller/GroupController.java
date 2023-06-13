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

import app.user.model.Group;
import app.user.repositories.GroupRepository;

@RestController
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    private GroupRepository groupRepository;

    @GetMapping(value = "")
    public List<Group> getAllApplications() {
        return groupRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Group> getApplicationById(@PathVariable("id") String id) {
        return groupRepository.findById(id);
    }

    @PostMapping(value = "")
    public Group addNewApplication(@RequestBody Group application){
        return groupRepository.save(application);
    }

    @PutMapping(value = "/{id}")
    public Group updateApplication(@PathVariable("id") String id, @RequestBody Group group){
        group.setId(id);
        return groupRepository.save(group);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteApplication(@PathVariable("id") String id) {
        groupRepository.deleteById(id);
    }

}
