package br.com.leandro.portalingles.services;

import br.com.leandro.portalingles.dtos.SubjectDto;
import br.com.leandro.portalingles.entities.CourseSubject;
import br.com.leandro.portalingles.entities.Teacher;
import br.com.leandro.portalingles.repositories.SubjectRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public ResponseEntity<String> create(SubjectDto subjectDto) {
        CourseSubject courseSubject = new CourseSubject();
        BeanUtils.copyProperties(subjectDto, courseSubject);

        System.out.println(subjectDto);
        subjectRepository.save(courseSubject);
        return new ResponseEntity<>("Disciplina criada", HttpStatus.CREATED);
    }

    public List<CourseSubject> get() {
      List<CourseSubject> courseSubjectList = subjectRepository.findAll();
      //  List<CourseSubject> courseSubjectList =new ArrayList<>();
      return courseSubjectList;
    }

    public CourseSubject getByName(String subjectName) {
       CourseSubject courseSubject = subjectRepository.findByName(subjectName);
       return courseSubject;
    }

    public void RegisterAssociatedTeacher(String subjectId, Teacher teacher) {
        Optional<CourseSubject> courseSubject = subjectRepository.findById(subjectId);

        if (courseSubject.isPresent()) {
            List <Teacher> teachers = courseSubject.get().getTeachers();
            if (teachers == null) {
                teachers = new ArrayList<>();
            }
            teachers.add(teacher);
            courseSubject.get().setTeachers(teachers);
            System.out.println(String.format("Professor %s associado(a) a disciplina %s", teacher.getName(), courseSubject.get().getName()));
            subjectRepository.save(courseSubject.get());
        }
        else {
            System.out.println("Disciplina não encontrada");
        }

    }

    public CourseSubject getById(String id) {

        Optional<CourseSubject> courseSubject = subjectRepository.findById(id);
        if (courseSubject.isPresent()) {
            return courseSubject.get();
        }
        throw new IllegalArgumentException("Id inválido");
    }

    public void update(CourseSubject courseSubject) {
        if (subjectRepository.findById(courseSubject.getId()).isPresent()) {
            subjectRepository.save(courseSubject);
        } else {
            throw new IllegalArgumentException("Id inválido");
        }
    }

    public void delete(String id) {

        Optional<CourseSubject> courseSubject = subjectRepository.findById(id);

        if (courseSubject.isPresent()) {
            subjectRepository.delete(courseSubject.get());
        } else {
            throw new IllegalArgumentException("Não foi possível apagar registro");
        }
    }
}
