package br.com.leandro.portalingles.controllers;

import br.com.leandro.portalingles.dtos.CourseClassCreationDto;
import br.com.leandro.portalingles.entities.CourseClass;
import br.com.leandro.portalingles.entities.CourseSubject;
import br.com.leandro.portalingles.services.CourseClassService;
import br.com.leandro.portalingles.services.SubjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin/turmas")
public class CourseClassController {

    @Autowired
    private CourseClassService courseClassService;
    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public ModelAndView viewClasses() {
        List<CourseClass> courseClasses = courseClassService.get();
        ModelAndView mv = new ModelAndView("courseclasses/index");
        mv.addObject("courseClasses", courseClasses);
        return mv;
    }

    @GetMapping("/cadastro")
    public ModelAndView classRegister(CourseClassCreationDto courseClassCreationDto) {
        List<CourseSubject> registeredSubjects = subjectService.get();
        ModelAndView mv = new ModelAndView("/courseclasses/classform");
        mv.addObject("registeredSubjects", registeredSubjects);
        return mv;
    }

    @PostMapping("/cadastro")
    public ModelAndView createClass(@Valid CourseClassCreationDto courseClassCreationDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("Erros no formulário");
            return new ModelAndView("redirect:/admin/turmas/cadastro");
        }
        courseClassService.create(courseClassCreationDto);
        return new ModelAndView("redirect:/admin/turmas");
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editClass(@PathVariable String id) {
        List<CourseSubject> registeredSubjects = subjectService.get();
        ModelAndView mv = new ModelAndView("/courseclasses/edit");
        CourseClass courseClass = courseClassService.getById(id);
        CourseClassCreationDto courseClassCreationDto = new CourseClassCreationDto();
        BeanUtils.copyProperties(courseClass, courseClassCreationDto);
        mv.addObject(courseClassCreationDto);
        mv.addObject("registeredSubjects", registeredSubjects);
        return mv;
    }

    @PostMapping("/editar")
    public ModelAndView edit(@Valid CourseClassCreationDto courseClassCreationDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("Erro nas informações inseridas");
        }
        courseClassService.update(courseClassCreationDto);
        return new ModelAndView("redirect:/admin/turmas");
    }

    @GetMapping("/{id}/excluir")
    public ModelAndView classDelete(@PathVariable String id) {
        CourseClass courseClass = courseClassService.getById(id);
        courseClassService.delete(courseClass);
        return new ModelAndView("redirect:/admin/turmas");
    }
}
