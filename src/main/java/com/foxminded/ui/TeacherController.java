//package com.foxminded.ui;
//
//import com.foxminded.model.Teacher;
//import com.foxminded.service.TeacherDaoService;
//import com.foxminded.service.exception.UserInputException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Controller
//@RequestMapping("/teachers")
//public class TeacherController {
//
//    private final TeacherDaoService teacherDaoService;
//
//    @Autowired
//    public TeacherController(TeacherDaoService teacherDaoService) {
//        this.teacherDaoService = teacherDaoService;
//    }
//
//    @GetMapping()
//    public String findAll(Model model) {
//        model.addAttribute("teachers", teacherDaoService.findAll().stream().map(Optional::get).collect(Collectors.toList()));
//        return "teacher/teachers";
//    }
//
//    @GetMapping("/{id}")
//    public String getById(@PathVariable("id") int id, Model model) throws Exception {
//        model.addAttribute("teacher", teacherDaoService.getById(id).get());
//        return "teacher/show";
//    }
//    @GetMapping("/new")
//    public String newCourse(@ModelAttribute("teacher")Teacher teacher) {
//        return "teacher/new";
//    }
//
//    @PostMapping()
//    public String create(@ModelAttribute("teacher") Teacher teacher) throws UserInputException {
//        teacherDaoService.create(teacher);
//        return "redirect:/teachers";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String edit(Model model, @PathVariable("id") int id) throws Exception {
//        model.addAttribute("teacher", teacherDaoService.getById(id).get());
//        return "teacher/edit";
//    }
//
//    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("teacher") Teacher teacher, @PathVariable("id") int id) throws UserInputException {
//        teacherDaoService.update(teacher, id);
//        return "redirect:/teachers";
//    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") int id) throws UserInputException {
//        teacherDaoService.delete(id);
//        return "redirect:/teachers";
//    }
//}
//
