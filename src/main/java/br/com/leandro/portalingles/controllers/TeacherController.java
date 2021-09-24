package br.com.leandro.portalingles.controllers;

import br.com.leandro.portalingles.dtos.TeacherDto;
import br.com.leandro.portalingles.entities.CourseSubject;
import br.com.leandro.portalingles.entities.Teacher;
import br.com.leandro.portalingles.services.SubjectService;
import br.com.leandro.portalingles.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin/professores")
public class TeacherController {

    @Autowired
    SubjectService subjectService;
    @Autowired
    TeacherService teacherService;

    @GetMapping
    public ModelAndView viewTeacher() {
        List<Teacher> teachers  = teacherService.get();
        ModelAndView mv = new ModelAndView("teachers/index");
        mv.addObject("teachers", teachers);
        return mv;
    }

    @GetMapping("/cadastrar")
    public ModelAndView teacherRegister(TeacherDto teacherDto) {
        ModelAndView mv = new ModelAndView("teachers/teacherform");
           List<CourseSubject> subjectList = subjectService.get();
//        System.out.println("Lista de disciplinas " + subjectList);
           mv.addObject("subjectList", subjectList);
        return mv;
    }

    @PostMapping("/cadastro")
    public ModelAndView createTeacher(@Valid TeacherDto teacherDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            return new ModelAndView("redirect:/admin/cadastro-professor");
        }
        teacherService.create(teacherDto);
        return new ModelAndView("redirect:/admin/professores");
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editform(@PathVariable String id){
        TeacherDto teacherDto = teacherService.getById(id);
        List<CourseSubject> subjectList = subjectService.get();
        ModelAndView mv = new ModelAndView("/teachers/edit");
        mv.addObject(teacherDto);
        mv.addObject("subjectList", subjectList);
        return mv;
    }

    @PostMapping("/editar")
    public ModelAndView update (@Valid TeacherDto teacherDto) {
        teacherService.update(teacherDto);
        return new ModelAndView("redirect:/admin/professores");
    }

    @GetMapping("/{id}/excluir")
    public ModelAndView delete(@PathVariable String id) {
        teacherService.delete(id);
        return new ModelAndView("redirect:/admin/professores");
    }

}
