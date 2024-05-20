package ru.owneraccess;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "owners")
@NoArgsConstructor
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @OneToMany(mappedBy = "owner")
    private Set<Cat> cats;
}
