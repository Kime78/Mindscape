package ro.mindscape.studenti_profesori_discipline.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.mindscape.studenti_profesori_discipline.entities.Lecture;
import ro.mindscape.studenti_profesori_discipline.entities.Student;
import ro.mindscape.studenti_profesori_discipline.repositories.LectureRepo;
import ro.mindscape.studenti_profesori_discipline.repositories.StudentRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureService {
    private final LectureRepo lectureRepo;
    private final StudentRepo studentRepo;

    public List<Lecture> getAllLectures() {
        return lectureRepo.findAll();
    }

    public Lecture getLectureById(String id) {
        return lectureRepo.findById(id).orElse(null);
    }

    public Lecture createLecture(Lecture lecture) {
        return lectureRepo.save(lecture);
    }

    public Lecture updateLecture(Lecture lecture, String id) {
        Lecture l = lectureRepo.findById(id).orElse(null);
        if(l == null) {
            return null;
        }
        l.setAnStudiu(lecture.getAnStudiu());
        l.setCod(lecture.getCod());
        l.setStudents(lecture.getStudents());
        l.setProfessor(lecture.getProfessor());
        l.setNume_disciplina(lecture.getNume_disciplina());
        l.setCategorie_disciplina(lecture.getCategorie_disciplina());
        l.setTip_disciplina(lecture.getTip_disciplina());
        l.setTip_examinare(lecture.getTip_examinare());
        return lectureRepo.save(lecture);
    }

    public void deleteLecture(String id) {
        lectureRepo.deleteById(id);
    }

    public List<Lecture> getLecturesByStudentId(int studentId) {
        Student s = studentRepo.findById(studentId).orElse(null);
        if(s == null) {
            return null;
        }
        return s.getLectures();
    }
}
