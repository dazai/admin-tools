package tn.monjislim.office.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "grade")
public class Grade implements Serializable {

    @Id
    private String id;

    private Integer level;

    private Integer subClass;

}
