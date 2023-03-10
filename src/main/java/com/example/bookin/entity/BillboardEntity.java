package com.example.bookin.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillboardEntity {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @Column(name = "STATUS")
    @NotNull(message = "El status de la cartelera no puede ser nulo")
    Boolean status;
    @NotNull(message = "La fecha de la cartelera no puede ser nulo")
    @Column(name = "DATE")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    LocalDateTime date;
    @NotNull(message = "La fecha de finalización de la cartelera no puede ser nulo")
    @Column(name = "END_TIME")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    LocalDateTime endTime;
    @NotNull(message = "La fecha de inicio de la cartelera no puede ser nulo")
    @Column(name = "START_TIME")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    LocalDateTime startTime;

}
