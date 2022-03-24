package com.foxminded.ui;

import com.foxminded.model.Course;
import com.foxminded.model.University;
import com.foxminded.service.UniversityDaoService;
import com.foxminded.service.exception.UserInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.Collectors;
@Controller
@RequestMapping("/universities")
public class UniversityController {
    private final UniversityDaoService universityDaoService;

    @Autowired
    public UniversityController(UniversityDaoService universityDaoService) {
        this.universityDaoService = universityDaoService;
    }

    @GetMapping()
    public String findAll(Model model) {
        model.addAttribute("universities", universityDaoService.findAll().stream().map(Optional::get).collect(Collectors.toList()));
        return "university/universities";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") int id, Model model) throws Exception {
        model.addAttribute("university", universityDaoService.getById(id).get());
        return "university/show";
    }
    @GetMapping("/new")
    public String newCourse(@ModelAttribute("university") Course course) {
        return "university/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("university") University university) throws UserInputException {
        universityDaoService.create(university);
        return "redirect:/universities";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) throws Exception {
        model.addAttribute("university", universityDaoService.getById(id).get());
        return "university/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("university") University university, @PathVariable("id") int id) throws UserInputException {
        universityDaoService.update(university, id);
        return "redirect:/universities";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) throws UserInputException {
        universityDaoService.delete(id);
        return "redirect:/universities";
    }
}
