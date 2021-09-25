package br.com.leandro.portalingles.services;

import br.com.leandro.portalingles.dtos.TeacherDto;
import br.com.leandro.portalingles.entities.CourseSubject;
import br.com.leandro.portalingles.entities.Teacher;
import br.com.leandro.portalingles.repositories.SubjectRepository;
import br.com.leandro.portalingles.repositories.TeacherRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private SubjectRepository subjectRepository;

    public  List<Teacher> get() {
        return teacherRepository.findAll();
    }

    public void create(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        teacher.setName(teacherDto.getName());
        teacher.setAge(teacherDto.getAge());
        List<CourseSubject> subjectList = convertStringsToSubjectsList(teacherDto.getCourseSubjectList(), teacher);
        teacher.setCourseSubjectList(subjectList);
        AssociateTeacherToSubject(teacherRepository.save(teacher),subjectList);
    }

    private List<CourseSubject> convertStringsToSubjectsList(List<String> strings, Teacher teacher) {


            List<CourseSubject> courseSubjectList = new ArrayList<>();
        if (strings != null) {
            for (int i = 0; i < strings.size(); i++) {
                String currentString = strings.get(i);
                if (currentString != null) {
                    CourseSubject courseSubject = subjectRepository.findByName(currentString);
                    courseSubjectList.add(courseSubject);
                }
            }
        }
        System.out.println("Subjects: " +courseSubjectList);
        return courseSubjectList;
    }

    private void AssociateTeacherToSubject(Teacher teacher, List<CourseSubject> courseSubjects) {
        for (CourseSubject subject : courseSubjects) {
            subjectService.RegisterAssociatedTeacher(subject.getId(), teacher);
        }
    }

    public TeacherDto getById(String id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);

        if (teacher.isPresent()) {
            TeacherDto teacherDto = new TeacherDto();
            BeanUtils.copyProperties(teacher.get(), teacherDto);
            return teacherDto;
        } else {
            throw new IllegalArgumentException("Id inválido");
        }
    }

    public void update(TeacherDto teacherDto) {

        Optional<Teacher> teacher = teacherRepository.findById(teacherDto.getId());
        if (teacher.isPresent()) {
         BeanUtils.copyProperties(teacherDto, teacher.get());
            List<CourseSubject> subjectList = convertStringsToSubjectsList(teacherDto.getCourseSubjectList(), teacher.get());
            teacher.get().setCourseSubjectList(subjectList);
            AssociateTeacherToSubject(teacherRepository.save(teacher.get()),subjectList);
        } else {
            throw new IllegalArgumentException("Id inválido");
        }
    }

    public void delete(String id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (teacher.isPresent()) {

            teacherRepository.delete(teacher.get());
        } else {
            throw new IllegalArgumentException("Id inválido");
        }
    }

}
