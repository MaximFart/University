package com.foxminded.ui;

import com.foxminded.model.Course;
import com.foxminded.model.StudentCourse;
import com.foxminded.service.DepartmentDaoService;
import com.foxminded.service.StudentCourseDaoService;
import com.foxminded.service.exception.UserInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/student_courses")
public class StudentCourseController {

    private final StudentCourseDaoService studentCourseDaoService;

    @Autowired
    public StudentCourseController(StudentCourseDaoService studentCourseDaoService) {
        this.studentCourseDaoService = studentCourseDaoService;
    }

    @GetMapping()
    public String findAll(Model model) {
        model.addAttribute("studentCourses", studentCourseDaoService.findAll().stream().map(Optional::get).collect(Collectors.toList()));
        return "student_course/student_courses";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") int id, Model model) throws Exception {
        model.addAttribute("studentCourse", studentCourseDaoService.getById(id).get());
        return "student_course/show";
    }
    @GetMapping("/new")
    public String newCourse(@ModelAttribute("studentCourse") StudentCourse studentCourse) {
        return "student_course/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("studentCourse") StudentCourse studentCourse) throws UserInputException {
        studentCourseDaoService.create(studentCourse);
        return "redirect:/student_courses";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) throws Exception {
        model.addAttribute("studentCourse", studentCourseDaoService.getById(id).get());
        return "student_course/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("studentCourse") StudentCourse studentCourse, @PathVariable("id") int id) throws UserInputException {
        studentCourseDaoService.update(studentCourse, id);
        return "redirect:/student_courses";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) throws UserInputException {
        studentCourseDaoService.delete(id);
        return "redirect:/student_courses";
    }
}
