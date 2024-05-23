package ru.cataccess.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.cataccess.objects.Breed;
import ru.cataccess.objects.Color;

@Entity
@Table(name = "cats")
@Data
@NoArgsConstructor
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "breed", nullable = false)
    @Enumerated(EnumType.STRING)
    private Breed breed;

    @Column(name = "color", nullable = false)
    @Enumerated(EnumType.STRING)
    private Color color;

//    @ManyToOne
//    @JoinColumn(name = "owner_id", nullable = false)
//    private Owner owner;

    public Cat(String name, Breed breed, Color color) {
        this.name = name;
        this.breed = breed;
        this.color = color;
    }
}
