package tn.monjislim.office.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String className;

    private String sex;

    private String birthDate;

    private String fatherName;

    private String inscriptionDate;

    private boolean present;

    private String interruptionDate;

    private JuryDecision juryDecision;

    private Float average;

}
