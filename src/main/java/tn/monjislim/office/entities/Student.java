package tn.monjislim.office.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.monjislim.office.dto.StudentDto;

import javax.persistence.*;
import java.io.Serializable;
import java.text.Collator;
import java.util.Locale;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student implements Serializable, Comparable<Student> {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(name = "class_name")
    private String className;

    private String gender;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "inscription_date")
    private String inscriptionDate;

    private boolean present = true;

    @Column(name = "interruption_date")
    private String interruptionDate;

    public static Student create(StudentDto studentDto) {
        Student student = new Student();
        student.setBirthDate(studentDto.getBirthDate());
        student.setClassName(studentDto.getClassName());
        student.setFatherName(studentDto.getFatherName());
        student.setInscriptionDate(studentDto.getInscriptionDate());
        student.setName(studentDto.getName());
        student.setGender(studentDto.getSex());
        return student;
    }

    @Override
    public int compareTo(Student o) {
        return Collator.getInstance(new Locale("ar")).compare(this, o);
    }
}
