package it1.exam.mentoring.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DocumentDto {
    LocalDate signDate;
    LocalDate createDate;
    Integer number;
    String name;
    UUID agreementId;
}
