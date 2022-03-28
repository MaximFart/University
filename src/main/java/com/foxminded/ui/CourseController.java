package com.foxminded.ui;

import com.foxminded.model.Course;
import com.foxminded.service.CourseDaoService;
import com.foxminded.service.exception.UserInputException;
import com.foxminded.ui.exception.NoEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private final CourseDaoService courseDaoService;

    @Autowired
    public CourseController(CourseDaoService courseDaoService) {
        this.courseDaoService = courseDaoService;
    }

    @GetMapping()
    public String findAllCourses(Model model) {
        model.addAttribute("courses", courseDaoService.findAll());
        return "course/courses";
    }
    @GetMapping("/{id}")
    public String getCourse(@PathVariable("id") int id, Model model) throws Exception {
        model.addAttribute("course", courseDaoService.getById(id).orElseThrow(NoEntityException::new));
        return "course/show";
    }

    @GetMapping("/new")
    public String createCourse(@ModelAttribute("course") Course course) {
        return "course/new";
    }

    @PostMapping()
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseDaoService.create(course);
        return "redirect:/courses";
    }

    @GetMapping("/{id}/edit")
    public String editCourse(Model model, @PathVariable("id") int id) throws Exception {
        model.addAttribute("course", courseDaoService.getById(id).orElseThrow(NoEntityException::new));
        return "course/edit";
    }

    @PutMapping("/{id}")
    public String updateCourse(@ModelAttribute("course") Course course) throws Exception {
        courseDaoService.update(course);
        return "redirect:/courses";
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable("id") int id) throws Exception {
        courseDaoService.delete(id);
        return "redirect:/courses";
    }
}
