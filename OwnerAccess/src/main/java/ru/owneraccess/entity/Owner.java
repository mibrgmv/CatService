package ru.owneraccess.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "owners")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
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

//    @OneToMany(mappedBy = "owner")
//    private Set<Cat> cats;
}
