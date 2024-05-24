package ru.owneraccess.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class OwnerDTO {

    private Long id;

    private String name;

    private LocalDate dateOfBirth;
}