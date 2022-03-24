package com.foxminded.ui;

import com.foxminded.model.Department;
import com.foxminded.service.DepartmentDaoService;
import com.foxminded.service.exception.UserInputException;
import com.foxminded.ui.exception.NoEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentDaoService departmentDaoService;

    @Autowired
    public DepartmentController(DepartmentDaoService departmentDaoService) {
        this.departmentDaoService = departmentDaoService;
    }

    @GetMapping()
    public String findAll(Model model) {
        model.addAttribute("departments", departmentDaoService.findAll());
        return "department/departments";
    }
    @GetMapping("/{id}")
    public String getById(@PathVariable("id") int id, Model model) throws Exception {
        model.addAttribute("department", departmentDaoService.getById(id).orElseThrow(NoEntityException::new));
        return "department/show";
    }

    @GetMapping("/new")
    public String newDepartment(@ModelAttribute("department") Department department) {
        return "department/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("department") Department department) throws UserInputException {
        departmentDaoService.create(department);
        return "redirect:/departments";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) throws Exception {
        model.addAttribute("department", departmentDaoService.getById(id).orElseThrow(NoEntityException::new));
        return "department/edit";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("department") Department department) throws UserInputException {
        departmentDaoService.update(department);
        return "redirect:/departments";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) throws UserInputException {
        departmentDaoService.delete(id);
        return "redirect:/departments";
    }
}
