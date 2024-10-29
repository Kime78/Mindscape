package ro.mindscape.studenti_profesori_discipline.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.mindscape.studenti_profesori_discipline.enums.CicluStudii;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue
    private int id;
    @ManyToMany
            @JoinTable(
                    name = "student_lecture",
                    joinColumns = @JoinColumn(name = "student_id"),
                    inverseJoinColumns = @JoinColumn(name = "lecture_id")
            )
    List<Lecture> lectures;

    private String name;
    private String surname;
    @Column(unique = true)
    private String email;
    private int an_studiu;
    private int grupa;
    @Enumerated(EnumType.ORDINAL)
    private CicluStudii cicluStudii;
}
