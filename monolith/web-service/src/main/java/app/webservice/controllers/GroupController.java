package app.webservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import app.webservice.repositories.GroupRepository;

@Controller
public class GroupController {

    private final GroupRepository groupRepository;

    public GroupController(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @GetMapping("/groups")
    public String getGroups(Model model){
        model.addAttribute("groups", groupRepository.findAll());

        return "groups/list";
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello !!!";
    }
}
