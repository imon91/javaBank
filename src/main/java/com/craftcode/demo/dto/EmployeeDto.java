package com.craftcode.demo.dto;

import com.craftcode.demo.annotation.EmployeRoleAnnotation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDto {
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be 3-50 characters")

    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email is invalid")
    private String email;
    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 100, message = "Age must be at most 100")
    private Integer age;
    private LocalDate dateOfJoining;

    @EmployeRoleAnnotation
    private String role;

    @JsonProperty("isActive")
    private Boolean isActive;


}
