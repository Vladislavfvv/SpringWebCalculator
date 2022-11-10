package by.tms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Operation extends Entity {

    private Long id;
    private double num1;
    private double num2;
    private String operation;
    private double result;
    private User user;
    private LocalDateTime date;
}
