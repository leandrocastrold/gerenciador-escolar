package br.com.leandro.portalingles.repositories;

import br.com.leandro.portalingles.entities.CourseClass;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseClassRepository extends MongoRepository<CourseClass, String> {
}
