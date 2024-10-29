package ro.mindscape.studenti_profesori_discipline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.mindscape.studenti_profesori_discipline.entities.Lecture;

public interface LectureRepo extends JpaRepository<Lecture, String> {
}
