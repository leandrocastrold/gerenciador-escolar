package br.com.leandro.portalingles.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/admin")

public class AdminController {

    @GetMapping()
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/admin/index");
        return mv;
    }
//
//    @GetMapping("/cadastro-aluno")
//    public ModelAndView studentRegister(StudentDto studentDto) {
//        List<CourseClass> courseClasses = courseClassService.get();
//        ModelAndView mv = new ModelAndView("/students/studentform");
//        mv.addObject("levelStudentList", LevelStudent.values());
//        mv.addObject("courseClasses", courseClasses);
//        return mv;
//    }

//    @GetMapping("/cadastro-turma")
//    public ModelAndView classRegister(CourseClassCreationDto courseClassCreationDto) {
//
//        List<CourseSubject> registeredSubjects = subjectService.get();
//        ModelAndView mv = new ModelAndView("/courseclasses/classform");
//        mv.addObject("registeredSubjects", registeredSubjects);
//        return mv;
//    }
//
//    @GetMapping("/cadastro-disciplina")
//    public ModelAndView subjectRegister(SubjectDto subjectDto) {
//        ModelAndView mv = new ModelAndView("/subjects/subjectform");
//
//        return mv;
//    }

//    @GetMapping("/cadastro-professor")
//    public ModelAndView teacherRegister(TeacherDto teacherDto) {
//        ModelAndView mv = new ModelAndView("/teachers/teacherform");
//        List<CourseSubject> subjectList = subjectService.get();
////        System.out.println("Lista de disciplinas " + subjectList);
//        mv.addObject("subjectList", subjectList);
//        return mv;
//    }

//    @PostMapping("/cadastro-aluno")
//    public ModelAndView createAluno(@Valid StudentDto studentDto, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            System.out.println(bindingResult.getAllErrors());
//            return new ModelAndView("redirect:/admin/cadastro-aluno");
//
//        }
//        System.out.println(studentDto);
//        studentService.create(studentDto);
//        return new ModelAndView("redirect:/admin");
//    }

//    @PostMapping("/cadastro-turma")
//    public ModelAndView createClass(@Valid CourseClassCreationDto courseClassCreationDto, BindingResult bindingResult) {
//
//        if (bindingResult.hasErrors()) {
//            System.out.println("Erros no formulário");
//            return new ModelAndView("redirect:/admin/cadastro-turma");
//        }
//        courseClassService.create(courseClassCreationDto);
//        return new ModelAndView("redirect:/admin");
//    }

//    @PostMapping("/cadastro-disciplina")
//    public ModelAndView createSubject(@Valid SubjectDto subjectDto, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//
//            return new ModelAndView("redirect:/admin/cadastro-disciplina");
//        }
//        subjectService.create(subjectDto);
//        return new ModelAndView("redirect:/admin");
//    }

//    @PostMapping("/cadastro-professor")
//    public ModelAndView createTeacher(@Valid TeacherDto teacherDto, BindingResult bindingResult) {
//
//        if (bindingResult.hasErrors()) {
//            System.out.println(bindingResult);
//            return new ModelAndView("redirect:/admin/cadastro-professor");
//        }
//        teacherService.create(teacherDto);
//        return new ModelAndView("redirect:/admin");
//    }

    // VIEWS


//    @GetMapping("/alunos")
//    public ModelAndView viewStudent() {
//        List<Student> students = studentService.get();
//        ModelAndView mv = new ModelAndView("students/index");
//        mv.addObject("students", students);
//        return mv;
//    }

//
//    @GetMapping("/professores")
//    public ModelAndView viewTeacher() {
//        List<Teacher> teachers  = teacherService.get();
//        ModelAndView mv = new ModelAndView("teachers/index");
//        mv.addObject("teachers", teachers);
//        return mv;
//    }

//    @GetMapping("/disciplinas")
//    public ModelAndView viewSubject() {
//        List<CourseSubject> subjects  = subjectService.get();
//        ModelAndView mv = new ModelAndView("subjects/index");
//        mv.addObject("subjects", subjects);
//        return mv;
//    }

//    @GetMapping("/turmas")
//    public ModelAndView viewClasses() {
//        List<CourseClass> courseClasses  = courseClassService.get();
//        ModelAndView mv = new ModelAndView("courseclasses/index");
//        mv.addObject("courseClasses", courseClasses);
//        return mv;
//    }

    //EDIÇÃO
//
//    @GetMapping("/alunos/editar/{id}")
//    public ModelAndView editStudent(@PathVariable String id) {
//        List<CourseClass> courseClasses = courseClassService.get();
//        ModelAndView mv = new ModelAndView("/students/studentedit");
//        mv.addObject("levelStudentList", LevelStudent.values());
//        mv.addObject("courseClasses", courseClasses);
//        Student studentToEdit = studentService.getById(id);
//        StudentDto studentDto = new StudentDto();
//        BeanUtils.copyProperties(studentToEdit,studentDto);
//        mv.addObject(studentDto);
//        return mv;
//    }

//    @PostMapping("/alunos/editar")
//    public ModelAndView editStudent(@Valid StudentDto studentDto, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            System.out.println(bindingResult.getAllErrors());
//            return new ModelAndView("redirect:/admin/alunos/editar");
//        }
//        System.out.println(studentDto);
//        studentService.update(studentDto);
//        return new ModelAndView("redirect:/admin/alunos");
//    }
//
//    @GetMapping("alunos/{id}/deletar")
//    public ModelAndView deleteStudent(@PathVariable String id) {
//        studentService.delete(id);
//        return new ModelAndView("redirect:/admin/alunos");
//
//    }

}
