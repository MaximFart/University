package com.foxminded.ui;

import com.foxminded.model.Course;
import com.foxminded.model.Student;
import com.foxminded.service.StudentDaoService;
import com.foxminded.service.exception.UserInputException;
import com.foxminded.ui.exception.NoEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentDaoService studentDaoService;

    @Autowired
    public StudentController(StudentDaoService studentDaoService) {
        this.studentDaoService = studentDaoService;
    }

    @GetMapping()
    public String findAll(Model model) {
        model.addAttribute("students", studentDaoService.findAll());
        return "student/students";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") int id, Model model) throws Exception {
        model.addAttribute("student", studentDaoService.getById(id).orElseThrow(NoEntityException::new));
        return "student/show";
    }

    @GetMapping("/new")
    public String newCourse(@ModelAttribute("student") Student student) {
        return "student/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("student") Student student) throws UserInputException {
        studentDaoService.create(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) throws Exception {
        model.addAttribute("student", studentDaoService.getById(id).orElseThrow(NoEntityException::new));
        return "student/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("student") Student student) throws UserInputException {
        studentDaoService.update(student);
        return "redirect:/students";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) throws UserInputException {
        studentDaoService.delete(id);
        return "redirect:/students";
    }
}
