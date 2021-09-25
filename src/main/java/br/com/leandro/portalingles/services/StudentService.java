package br.com.leandro.portalingles.services;

import br.com.leandro.portalingles.dtos.StudentDto;
import br.com.leandro.portalingles.entities.CourseClass;
import br.com.leandro.portalingles.entities.Student;
import br.com.leandro.portalingles.repositories.CourseClassRepository;
import br.com.leandro.portalingles.repositories.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseClassRepository courseClassRepository;


    public List<Student> get() {
       return studentRepository.findAll();
    }

    public Student getById(String id)
    {
        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return new Student();
    }

    public ResponseEntity<String> create(StudentDto studentDto) {
        CourseClass courseClass = new CourseClass();
        if (studentDto.getCourseClassId() != null) {
            Optional<CourseClass> optional = courseClassRepository.findById(studentDto.getCourseClassId());
            if (optional.isPresent()) {
                courseClass = optional.get();
            }
        }

        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        student.setCourseClass(courseClass);
        studentRepository.save(student);
        System.out.println("Created :" + student);
        return new ResponseEntity<>("Aluno criado!", HttpStatus.CREATED);
    }

    public ResponseEntity<String> update(StudentDto studentDto) {

        Optional<Student> student = studentRepository.findById(studentDto.getId());
        if (student.isPresent()) {
            CourseClass courseClass = courseClassRepository.findById(studentDto.getCourseClassId()).get();
            student.get().setCourseClass(courseClass);
            BeanUtils.copyProperties(studentDto, student.get());
            studentRepository.save(student.get());
            return new ResponseEntity<>("Aluno atualizado", HttpStatus.OK);
        }

        throw  new IllegalArgumentException("Id não encontrado");
    }

    public void delete(String id) {
        Optional<Student> student = studentRepository.findById(id);

        if (student.isPresent()) {
            studentRepository.delete(student.get());
        } else {
            throw new IllegalArgumentException("Id não encontrado");
        }

    }
}
