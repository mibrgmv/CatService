package ru.owneraccess.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "owners")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "name", nullable = false)
    private String name;

    @NonNull
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

//    @NonNull
//    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
//    private Set<Cat> cats;
}
