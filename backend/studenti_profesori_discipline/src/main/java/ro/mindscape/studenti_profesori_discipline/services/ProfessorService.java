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

    public Professor updateProfessor(Professor professor, int id) {
        Professor p = professorRepo.findById(id).orElse(null);
        if (p == null) {
            return null;
        }
        p.setName(professor.getName());
        p.setSurname(professor.getSurname());
        p.setEmail(professor.getEmail());
        p.setAfiliere(professor.getAfiliere());
        p.setGradDidactic(professor.getGradDidactic());
        p.setTipAsociere(professor.getTipAsociere());
        return professorRepo.save(p);
    }

    public void deleteProfessor(int id) {
        professorRepo.deleteById(id);
    }
}

