package ro.mindscape.studenti_profesori_discipline.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.mindscape.studenti_profesori_discipline.entities.Student;
import ro.mindscape.studenti_profesori_discipline.repositories.StudentRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepo studentRepo;

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Student getStudentById(int id) {
        return studentRepo.findById(id).orElse(null);
    }

    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }

    public Student updateStudent(Student student, int id) {
        Student s = studentRepo.findById(id).orElse(null);
        if(s == null) {
            return null;
        }
        s.setName(student.getName());
        s.setSurname(student.getSurname());
        s.setEmail(student.getEmail());
        s.setAn_studiu(student.getAn_studiu());
        s.setGrupa(student.getGrupa());
        s.setLectures(student.getLectures());
        return studentRepo.save(s);
    }

    public void deleteStudent(int id) {
        studentRepo.deleteById(id);
    }
}
