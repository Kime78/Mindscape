package ro.mindscape.studenti_profesori_discipline.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ro.mindscape.studenti_profesori_discipline.entities.Student;
import ro.mindscape.studenti_profesori_discipline.services.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/academia/student")
@RequiredArgsConstructor
@Validated
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        Student student = studentService.getStudentById(id);
        if(student == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
        return ResponseEntity.ok(studentService.createStudent(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@Valid @RequestBody Student student, @PathVariable int id) {
        Student s = studentService.getStudentById(id);
        if(s == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentService.updateStudent(student, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable int id) {
        Student s = studentService.getStudentById(id);
        if(s == null) {
            return ResponseEntity.notFound().build();
        }
        studentService.deleteStudent(id);
        return ResponseEntity.ok(s);
    }

}
