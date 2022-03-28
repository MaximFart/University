package com.foxminded.ui;

import com.foxminded.model.Groups;
import com.foxminded.service.GroupsDaoService;
import com.foxminded.service.exception.UserInputException;
import com.foxminded.ui.exception.NoEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/groups")
public class GroupsController {

    private final GroupsDaoService groupsDaoService;

    @Autowired
    public GroupsController(GroupsDaoService groupsDaoService) {
        this.groupsDaoService = groupsDaoService;
    }

    @GetMapping()
    public String findAllGroups(Model model) {
        model.addAttribute("groups", groupsDaoService.findAll());
        return "group/groups";
    }
    @GetMapping("/{id}")
    public String getGroup(@PathVariable("id") int id, Model model) throws Exception {
        model.addAttribute("group", groupsDaoService.getById(id).orElseThrow(NoEntityException::new));
        return "group/show";
    }
    @GetMapping("/new")
    public String createGroup(@ModelAttribute("group") Groups groups) {
        return "group/new";
    }

    @PostMapping()
    public String saveGroup(@ModelAttribute("group") Groups groups) throws UserInputException {
        groupsDaoService.create(groups);
        return "redirect:/groups";
    }

    @GetMapping("/{id}/edit")
    public String editGroup(Model model, @PathVariable("id") int id) throws Exception {
        model.addAttribute("group", groupsDaoService.getById(id).orElseThrow(NoEntityException::new));
        return "group/edit";
    }

    @PutMapping("/{id}")
    public String updateGroup(@ModelAttribute("group") Groups groups, @PathVariable("id") int id) throws UserInputException, Exception {
        groupsDaoService.update(groups);
        return "redirect:/groups";
    }

    @DeleteMapping("/{id}")
    public String deleteGroup(@PathVariable("id") int id) throws UserInputException {
        groupsDaoService.delete(id);
        return "redirect:/groups";
    }
}