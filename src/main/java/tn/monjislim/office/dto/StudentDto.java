package tn.monjislim.office.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private String name;

    private String className;

    private String sex;

    private String birthDate;

    private String fatherName;

    private String inscriptionDate;
}
