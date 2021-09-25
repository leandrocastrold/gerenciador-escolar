package br.com.leandro.portalingles.dtos;

import br.com.leandro.portalingles.entities.Teacher;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


public class SubjectDto {
    private String id;
    @NotBlank
    private String name;
    @NotNull
    private String duration;

    private List<Teacher> teachers;

    public SubjectDto(){}

    public SubjectDto(String name, String duration, List<Teacher> teachers) {
        this.name = name;
        this.duration = duration;
        this.teachers = teachers;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "SubjectDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", teachers=" + teachers +
                '}';
    }
}
