package ru.owneraccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.owneraccess.entity.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
