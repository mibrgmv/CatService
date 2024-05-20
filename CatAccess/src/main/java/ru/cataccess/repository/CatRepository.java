package ru.cataccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cataccess.entities.Cat;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {
}
