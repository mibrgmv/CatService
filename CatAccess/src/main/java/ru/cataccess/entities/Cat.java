package ru.cataccess.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import ru.cataccess.objects.Breed;
import ru.cataccess.objects.Color;

@Entity
@Table(name = "cats")
@NoArgsConstructor
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "breed", nullable = false)
    private Breed breed;

    @Column(name = "color", nullable = false)
    private Color color;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;
}
