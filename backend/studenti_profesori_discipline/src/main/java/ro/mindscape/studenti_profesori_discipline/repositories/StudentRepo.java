package ro.mindscape.studenti_profesori_discipline.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ro.mindscape.studenti_profesori_discipline.entities.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
