package br.com.leandro.portalingles.entities;
import br.com.leandro.portalingles.enums.LevelStudent;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "students")
public class Student {
   @Id
   private String id;
   private String name;
   private Integer age;
   private LevelStudent levelStudent;
   @DBRef
   private CourseClass courseClass;

   public Student(){}

    public Student(String name, Integer age, LevelStudent levelStudent, CourseClass courseClass) {
        this.name = name;
        this.age = age;
        this.levelStudent = levelStudent;
        this.courseClass = courseClass;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer idade) {
        this.age = idade;
    }

    public LevelStudent getLevelStudent() {
        return levelStudent;
    }

    public void setLevelStudent(LevelStudent levelStudent) {
        this.levelStudent = levelStudent;
    }

    public CourseClass getCourseClass() {
        return courseClass;
    }

    public void setCourseClass(CourseClass courseClass) {
        this.courseClass = courseClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", levelStudent=" + levelStudent +
                ", courseClass=" + courseClass +
                '}';
    }
}

