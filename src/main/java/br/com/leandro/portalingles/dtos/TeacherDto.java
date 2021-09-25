package br.com.leandro.portalingles.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class TeacherDto {

    private String id;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    private Integer age;
    private List<String> courseSubjectList;

    public TeacherDto() {
    }

    public TeacherDto(String name, Integer age, List<String> courseSubjectList) {
        this.name = name;
        this.age = age;
        this.courseSubjectList = courseSubjectList;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<String> getCourseSubjectList() {
        return courseSubjectList;
    }

    public void setCourseSubjectList(List<String> courseSubjectList) {
        this.courseSubjectList = courseSubjectList;
    }

    @Override
    public String toString() {
        return "TeacherDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", courseSubjectList=" + courseSubjectList +
                '}';
    }
}
