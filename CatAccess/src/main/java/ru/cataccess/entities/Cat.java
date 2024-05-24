package ru.cataccess.entities;

import jakarta.persistence.*;
import lombok.*;
import ru.cataccess.objects.Breed;
import ru.cataccess.objects.Color;

@Entity
@Table(name = "cats")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "name", nullable = false)
    private String name;

    @NonNull
    @Column(name = "breed", nullable = false)
    @Enumerated(EnumType.STRING)
    private Breed breed;

    @NonNull
    @Column(name = "color", nullable = false)
    @Enumerated(EnumType.STRING)
    private Color color;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "owner_id", nullable = false)
//    private Owner owner;
}
