package br.com.leandro.portalingles.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class CourseClassCreationDto {

    private String id;
    @NotNull
    @NotBlank
    private String name;
    private List<String> subjectsName;

    public CourseClassCreationDto() {
    }

    public CourseClassCreationDto(String name, List<String> subjectsName) {
        this.name = name;
        this.subjectsName = subjectsName;
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

    public List<String> getSubjectsName() {
        return subjectsName;
    }

    public void setSubjectsName(List<String> subjectsName) {
        this.subjectsName = subjectsName;
    }

    @Override
    public String toString() {
        return "CourseClassCreationDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", subjectsName=" + subjectsName +
                '}';
    }
}
