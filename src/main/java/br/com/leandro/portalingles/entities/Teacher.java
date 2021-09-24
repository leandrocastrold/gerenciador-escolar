package br.com.leandro.portalingles.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "teachers")
public class Teacher {
    @Id
    private String id;
    private String name;
    private Integer age;
    @DBRef (lazy = true)
    private List<CourseSubject> courseSubjectList;

    public Teacher() {
    }

    public Teacher(String name, String age, List<CourseSubject> courseSubjectList) {
        this.name = name;
        this.id = age;
        this.courseSubjectList = courseSubjectList;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<CourseSubject> getCourseSubjectList() {
        return courseSubjectList;
    }

    public void setCourseSubjectList(List<CourseSubject> courseSubjectList) {
        this.courseSubjectList = courseSubjectList;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
//              ?  ", courseSubjectList=" + courseSubjectList +
                '}';
    }
}
