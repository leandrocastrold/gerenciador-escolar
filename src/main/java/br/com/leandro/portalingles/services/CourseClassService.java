package br.com.leandro.portalingles.services;

import br.com.leandro.portalingles.dtos.CourseClassCreationDto;
import br.com.leandro.portalingles.entities.CourseClass;
import br.com.leandro.portalingles.entities.CourseSubject;
import br.com.leandro.portalingles.repositories.CourseClassRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseClassService {

    @Autowired
    private CourseClassRepository courseClassRepository;
    @Autowired
    private SubjectService subjectService;

    public List<CourseClass> get() {
        return courseClassRepository.findAll();
    }

    public void create(CourseClassCreationDto courseClassCreationDto) {
        CourseClass courseClass = new CourseClass();
        courseClass.setName(courseClassCreationDto.getName());
        List<CourseSubject> courseSubjectList = findSubjectByName(
                courseClassCreationDto.getSubjectsName(), subjectService.get());
        courseClass.setCourseSubjectList(courseSubjectList);
        courseClassRepository.save(courseClass);
        System.out.println(courseClass);
    }

    private List<CourseSubject> findSubjectByName(List<String> list, List<CourseSubject> registeredSubjects) {
        List<CourseSubject> courseSubjectList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String subjectName = list.get(i);
            if (subjectName != null) {
                CourseSubject subjectToAdd = subjectService.getByName(subjectName);
                courseSubjectList.add(subjectToAdd);
            }
        }
        return courseSubjectList;
    }

    public void delete(CourseClass courseClass) {
        courseClassRepository.delete(courseClass);
    }

    public CourseClass getById(String id) {

        Optional<CourseClass> courseClass = courseClassRepository.findById(id);
        if (courseClass.isPresent()) {
            return courseClass.get();
        }
        throw new IllegalArgumentException("Turma não encontrada");
    }

    public void update(CourseClassCreationDto courseClassCreationDto) {
        System.out.println(courseClassCreationDto);
        Optional<CourseClass> courseClass = courseClassRepository.findById(courseClassCreationDto.getId());
        if (courseClass.isPresent()) {
            List<CourseSubject> courseSubjectList = findSubjectByName(courseClassCreationDto.getSubjectsName(), subjectService.get());
            courseClass.get().setCourseSubjectList(courseSubjectList);
            BeanUtils.copyProperties(courseClassCreationDto, courseClass.get());
            System.out.println(courseClass);
            courseClassRepository.save(courseClass.get());

        } else {
            throw new IllegalArgumentException("Id não encontrado" + courseClassCreationDto.getId());
        }
    }
}
