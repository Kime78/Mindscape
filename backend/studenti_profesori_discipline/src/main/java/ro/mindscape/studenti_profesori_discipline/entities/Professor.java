package ro.mindscape.studenti_profesori_discipline.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.mindscape.studenti_profesori_discipline.enums.GradDidactic;
import ro.mindscape.studenti_profesori_discipline.enums.TipAsociere;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "proffesor")
public class Professor {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String surname;
    private String email;
    private GradDidactic gradDidactic;
    private TipAsociere tipAsociere;
    private String afiliere;
}
