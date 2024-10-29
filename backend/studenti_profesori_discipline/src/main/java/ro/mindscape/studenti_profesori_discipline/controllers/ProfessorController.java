package ro.mindscape.studenti_profesori_discipline.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ro.mindscape.studenti_profesori_discipline.entities.Professor;
import ro.mindscape.studenti_profesori_discipline.services.ProfessorService;
import java.util.List;

@RestController
@RequestMapping("/api/academia/professor")
@RequiredArgsConstructor
@Validated
public class ProfessorController {
    private final ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<Professor>> getAllProfessors() {
        return ResponseEntity.ok(professorService.getAllProfessors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable int id) {
        Professor p = professorService.getProfessorById(id);
        if(p == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(p);
    }

    @PostMapping
    public ResponseEntity<Professor> createProfessor(@Valid @RequestBody Professor professor) {
        return ResponseEntity.ok(professorService.createProfessor(professor));
    }

    @PutMapping
    public ResponseEntity<Professor> updateProfessor(@Valid @RequestBody Professor professor) {
        return ResponseEntity.ok(professorService.updateProfessor(professor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Professor> deleteProfessor(@PathVariable int id) {
        Professor p = professorService.getProfessorById(id);
        professorService.deleteProfessor(id);
        return ResponseEntity.ok(p);
    }
}
