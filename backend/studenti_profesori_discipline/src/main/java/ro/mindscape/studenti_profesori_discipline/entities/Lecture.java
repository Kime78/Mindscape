package ro.mindscape.studenti_profesori_discipline.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.mindscape.studenti_profesori_discipline.enums.CategorieDisciplina;
import ro.mindscape.studenti_profesori_discipline.enums.TipDisciplina;
import ro.mindscape.studenti_profesori_discipline.enums.TipExaminare;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lecture")
public class Lecture {
    @Id
    private String cod;

    @ManyToMany(mappedBy = "lectures")
    Set<Student> students;

    @ManyToOne
    private Professor professor;
    @NotNull
    private int anStudiu;
    @NotNull
    private String nume_disciplina;
    @NotNull
    private TipDisciplina tip_disciplina;
    @NotNull
    private CategorieDisciplina categorie_disciplina;
    @NotNull
    private TipExaminare tip_examinare;

}
