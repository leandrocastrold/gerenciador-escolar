package br.com.leandro.portalingles.dtos;

import br.com.leandro.portalingles.entities.CourseClass;
import br.com.leandro.portalingles.enums.LevelStudent;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StudentDto {

    private String id;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    private Integer age;
    private LevelStudent levelStudent;
    private String courseClassId;

    public StudentDto() {
    }

    public StudentDto(String name, Integer age, LevelStudent levelStudent) {
        this.name = name;
        this.age = age;
        this.levelStudent = levelStudent;
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

    public LevelStudent getLevelStudent() {
        return levelStudent;
    }

    public void setLevelStudent(LevelStudent levelStudent) {
        this.levelStudent = levelStudent;
    }

    public String getCourseClassId() {
        return courseClassId;
    }

    public void setCourseClassId(String courseClass) {
        this.courseClassId = courseClass;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", levelStudent=" + levelStudent +
                ", courseClass=" + courseClassId +
                '}';
    }
}
