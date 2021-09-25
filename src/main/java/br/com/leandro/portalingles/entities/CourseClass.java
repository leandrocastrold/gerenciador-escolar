package br.com.leandro.portalingles.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "classes")
public class CourseClass {
    @Id
    private String id;
    private String name;
    @DBRef
    private List<CourseSubject> courseSubjectList;
    @DBRef
    private List<Student> students;

    public CourseClass(){}

    public CourseClass(String name, List<CourseSubject> courseSubjectList, List<Student> students) {
        this.name = name;
        this.courseSubjectList = courseSubjectList;
        this.students = students;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CourseSubject> getCourseSubjectList() {
        return courseSubjectList;
    }

    public void setCourseSubjectList(List<CourseSubject> courseSubjectList) {
        this.courseSubjectList = courseSubjectList;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "CourseClass{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", courseSubjectList=" + courseSubjectList +
                ", students=" + students +
                '}';
    }
}
