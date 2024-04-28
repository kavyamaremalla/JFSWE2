package com.example.demo.boot.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Student DTO")
public class Student {

    @Schema(description = "Student Id")
    private int id;

    @Schema(description = "Student FirstName")
    private String firstName;

    @Schema(description = "Student LastName")
    private String lastName;

}
