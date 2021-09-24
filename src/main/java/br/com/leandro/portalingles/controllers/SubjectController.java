package br.com.leandro.portalingles.controllers;

import br.com.leandro.portalingles.dtos.SubjectDto;
import br.com.leandro.portalingles.entities.CourseSubject;
import br.com.leandro.portalingles.services.SubjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin/disciplinas")
public class SubjectController {

    @Autowired
    SubjectService subjectService;


    @GetMapping
    public ModelAndView viewSubject() {
        List<CourseSubject> subjects  = subjectService.get();
        ModelAndView mv = new ModelAndView("subjects/index");
        mv.addObject("subjects", subjects);
        return mv;
    }

    @GetMapping("/cadastro")
    public ModelAndView subjectRegister(SubjectDto subjectDto) {
        ModelAndView mv = new ModelAndView("/subjects/subjectform");

        return mv;
    }

    @PostMapping("/cadastro")
    public ModelAndView createSubject(@Valid SubjectDto subjectDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            return new ModelAndView("redirect:/admin/disciplinas/cadastro");
        }
        subjectService.create(subjectDto);
        return new ModelAndView("redirect:/admin/disciplinas");
    }

    @GetMapping("/{id}/editar")
    public ModelAndView edit(@PathVariable String id) {
     CourseSubject courseSubject = subjectService.getById(id);
     SubjectDto subjectDto = new SubjectDto();
     BeanUtils.copyProperties(courseSubject, subjectDto);
     ModelAndView mv = new ModelAndView("/subjects/edit");
     mv.addObject(subjectDto);
     return mv;
    }

    @PostMapping("/editar")
    public ModelAndView update(CourseSubject courseSubject) {
        subjectService.update(courseSubject);
        return new ModelAndView("redirect:/admin/disciplinas");
    }

    @GetMapping("/{id}/excluir")
    public ModelAndView delete(@PathVariable String id) {
        subjectService.delete(id);
        return new ModelAndView("redirect:/admin/disciplinas");
    }

}
