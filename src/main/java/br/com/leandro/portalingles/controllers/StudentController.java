package br.com.leandro.portalingles.controllers;

import br.com.leandro.portalingles.dtos.StudentDto;
import br.com.leandro.portalingles.entities.CourseClass;
import br.com.leandro.portalingles.entities.Student;
import br.com.leandro.portalingles.enums.LevelStudent;
import br.com.leandro.portalingles.repositories.StudentRepository;
import br.com.leandro.portalingles.services.CourseClassService;
import br.com.leandro.portalingles.services.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin/alunos")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseClassService courseClassService;


    @GetMapping
    public ModelAndView viewStudent() {
        List<Student> students = studentService.get();
        ModelAndView mv = new ModelAndView("students/index");
        mv.addObject("students", students);
        return mv;
    }


    @GetMapping("/cadastro")
    public ModelAndView studentRegister(StudentDto studentDto) {
        List<CourseClass> courseClasses = courseClassService.get();
        ModelAndView mv = new ModelAndView("students/studentform");
        mv.addObject("levelStudentList", LevelStudent.values());
        mv.addObject("courseClasses", courseClasses);
        return mv;
    }

    @PostMapping("/cadastro")
    public ModelAndView createAluno(@Valid StudentDto studentDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return new ModelAndView("redirect:/admin/alunos/cadastro");

        }
        System.out.println(studentDto);
        studentService.create(studentDto);
        return new ModelAndView("redirect:/admin/alunos");
    }


    @GetMapping("/editar/{id}")
    public ModelAndView editStudent(@PathVariable String id) {
        List<CourseClass> courseClasses = courseClassService.get();
        ModelAndView mv = new ModelAndView("students/studentedit");
        mv.addObject("levelStudentList", LevelStudent.values());
        mv.addObject("courseClasses", courseClasses);
        Student studentToEdit = studentService.getById(id);
        StudentDto studentDto = new StudentDto();
        BeanUtils.copyProperties(studentToEdit,studentDto);
        mv.addObject(studentDto);
        return mv;
    }

    @PostMapping("/editar")
    public ModelAndView editStudent(@Valid StudentDto studentDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return new ModelAndView("redirect:/admin/alunos/editar");
        }
        System.out.println(studentDto);
        studentService.update(studentDto);
        return new ModelAndView("redirect:/admin/alunos");
    }

    @GetMapping("/{id}/excluir")
    public ModelAndView deleteStudent(@PathVariable String id) {
        studentService.delete(id);
        return new ModelAndView("redirect:/admin/alunos");
    }



}
