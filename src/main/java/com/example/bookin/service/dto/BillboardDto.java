package com.example.bookin.service.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillboardDto {

    Integer id;
    Boolean status;
    LocalDateTime date;
    LocalDateTime endTime;
    LocalDateTime startTime;

}
