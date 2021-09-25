package br.com.leandro.portalingles.repositories;

import br.com.leandro.portalingles.entities.CourseSubject;
import br.com.leandro.portalingles.entities.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends MongoRepository<Teacher, String> {

    CourseSubject findByName(String currentString);}
