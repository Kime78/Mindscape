package ro.mindscape.studenti_profesori_discipline.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ro.mindscape.studenti_profesori_discipline.entities.Lecture;
import ro.mindscape.studenti_profesori_discipline.services.LectureService;

import java.util.List;

@RestController
@RequestMapping("/api/academia/lecture")
@RequiredArgsConstructor
@Validated
public class LectureController {
    private final LectureService lectureService;

    @GetMapping
    public ResponseEntity<List<Lecture>> getAllLectures() {
        return ResponseEntity.ok(lectureService.getAllLectures());
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<List<Lecture>> getLecturesById(@PathVariable int studentId) {
        List<Lecture> lectureList = lectureService.getLecturesByStudentId(studentId);
        if(lectureList == null) {
            return ResponseEntity.notFound().build();
        }
        else return ResponseEntity.ok(lectureList);
    }

    @PostMapping
    public ResponseEntity<Lecture> createLecture(@RequestBody @Valid Lecture lecture) {
        return ResponseEntity.ok(lectureService.createLecture(lecture));
    }

    @PutMapping
    public ResponseEntity<Lecture> updateLecture(@RequestBody @Valid Lecture lecture) {
        return ResponseEntity.ok(lectureService.updateLecture(lecture));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Lecture> deleteLecture(@PathVariable String id) {
        Lecture l = lectureService.getLectureById(id);
        if(l == null) {
            return ResponseEntity.notFound().build();
        }
        lectureService.deleteLecture(id);
        return ResponseEntity.ok(l);
    }
}
