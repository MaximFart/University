package com.foxminded.ui;

import com.foxminded.model.Course;
import com.foxminded.service.CourseDaoService;
import com.foxminded.service.exception.UserInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private final CourseDaoService courseDaoService;

    @Autowired
    public CourseController(CourseDaoService courseDaoService) {
        this.courseDaoService = courseDaoService;
    }

    @GetMapping()
    public String findAll(Model model) {
        model.addAttribute("courses", courseDaoService.findAll().stream().map(Optional::get).collect(Collectors.toList()));
        return "course/courses";
    }
    @GetMapping("/{id}")
    public String getById(@PathVariable("id") int id, Model model) throws Exception {
        model.addAttribute("course", courseDaoService.getById(id).get());
        return "course/show";
    }

    @GetMapping("/new")
    public String newCourse(@ModelAttribute("course") Course course) {
        return "course/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("course") Course course) {
        courseDaoService.create(course);
        return "redirect:/courses";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) throws Exception {
        model.addAttribute("course", courseDaoService.getById(id).get());
        return "course/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("course") Course course, @PathVariable("id") int id) {
        courseDaoService.update(course, id);
        return "redirect:/courses";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) throws UserInputException {
        courseDaoService.delete(id);
        return "redirect:/courses";
    }
}
