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

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", num1=" + num1 +
                ", num2=" + num2 +
                ", operation='" + operation + '\'' +
                ", result=" + result +
                ", user=" + user +
                ", date=" + date +
                '}';
    }
}
