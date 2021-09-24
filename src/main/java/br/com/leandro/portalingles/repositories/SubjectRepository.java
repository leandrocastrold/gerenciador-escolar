package br.com.leandro.portalingles.repositories;

import br.com.leandro.portalingles.entities.CourseSubject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends MongoRepository<CourseSubject, String> {

    public CourseSubject findByName(String name);
}
