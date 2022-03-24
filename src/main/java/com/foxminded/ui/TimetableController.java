package com.foxminded.ui;

import com.foxminded.dao.exception.DaoException;
import com.foxminded.model.Course;
import com.foxminded.model.Timetable;
import com.foxminded.service.TimetableDaoService;
import com.foxminded.service.exception.UserInputException;
import com.foxminded.ui.exception.NoEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/timetables")
public class TimetableController {

    private final TimetableDaoService timetableDaoService;

    @Autowired
    public TimetableController(TimetableDaoService timetableDaoService) {
        this.timetableDaoService = timetableDaoService;
    }

    @GetMapping()
    public String findAll(Model model) {
        model.addAttribute("timetables", timetableDaoService.findAll());
        return "timetable/timetables";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") int id, Model model) throws Exception {
        model.addAttribute("timetable", timetableDaoService.getById(id).orElseThrow(NoEntityException::new));
        return "timetable/show";
    }
    @GetMapping("/new")
    public String newCourse(@ModelAttribute("timetable") Timetable timetable) {
        return "timetable/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("timetable") Timetable timetable) throws UserInputException {
        timetableDaoService.create(timetable);
        return "redirect:/timetables";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) throws Exception {
        model.addAttribute("timetable", timetableDaoService.getById(id).orElseThrow(NoEntityException::new));
        return "timetable/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("timetable") Timetable timetable, @PathVariable("id") int id) throws UserInputException, DaoException {
        timetableDaoService.update(timetable, id);
        return "redirect:/timetables";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) throws UserInputException {
        timetableDaoService.delete(id);
        return "redirect:/timetables";
    }
}
