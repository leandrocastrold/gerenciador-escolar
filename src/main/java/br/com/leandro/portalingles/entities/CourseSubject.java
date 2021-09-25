package br.com.leandro.portalingles.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "subjects")
public class CourseSubject {
    @Id
    private String id;
    private String name;
    private String duration;

    @DBRef (lazy = true)
    private List<Teacher> teachers;


    public CourseSubject(){}

    public CourseSubject(String name, String duration, List<Teacher> teachers, List<CourseSubject> subjects) {
        this.name = name;
        this.duration = duration;
        this.teachers = teachers;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
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

    @Override
    public String toString() {
        return "CourseSubject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + duration + '\'' +
                '}';
    }
}
