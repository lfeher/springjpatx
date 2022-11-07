package com.lfeher.springjpatx.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
public class UserDto {

    private Long id;

    @NotBlank
    private String name;

    @NotNull
    @Past
    private LocalDate birthDay;
}
