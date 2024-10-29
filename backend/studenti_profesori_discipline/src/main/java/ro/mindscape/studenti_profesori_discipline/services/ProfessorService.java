package ro.mindscape.studenti_profesori_discipline.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.mindscape.studenti_profesori_discipline.entities.Professor;
import ro.mindscape.studenti_profesori_discipline.repositories.ProfessorRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorRepo professorRepo;

    public List<Professor> getAllProfessors() {
        return professorRepo.findAll();
    }

    public Professor getProfessorById(int id) {
        return professorRepo.findById(id).orElse(null);
    }

    public Professor createProfessor(Professor professor) {
        return professorRepo.save(professor);
    }

    public Professor updateProfessor(Professor professor) {
        return professorRepo.save(professor);
    }

    public void deleteProfessor(int id) {
        professorRepo.deleteById(id);
    }
}

