package com.foxminded.ui;

import com.foxminded.model.Timetable;
import com.foxminded.service.TimetableDaoService;
import com.foxminded.service.exception.UserInputException;
import com.foxminded.ui.exception.NoEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("thisTimetable", new Timetable());
        model.addAttribute("timetables", timetableDaoService.findAll());
        return "timetable/timetables";
    }

    @PostMapping("/search")
    public String findTimetablesByDate(@ModelAttribute("thisTimetable") Timetable timetable, Model model) {
        model.addAttribute("timetables", timetableDaoService.
                findTimetablesByTeacherIdOrCourseIdOrDateOrGroupsId(timetable.getTeacher().getId(), timetable.getCourse().getId(), timetable.getDate(),
                        timetable.getGroups().getId()));
        return "timetable/search";
    }

    @GetMapping("/id/{id}")
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

    @PutMapping("/{id}")
    public String update(@ModelAttribute("timetable") Timetable timetable) {
        timetableDaoService.update(timetable);
        return "redirect:/timetables";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        timetableDaoService.delete(id);
        return "redirect:/timetables";
    }
}
