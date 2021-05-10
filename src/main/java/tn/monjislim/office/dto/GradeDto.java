package tn.monjislim.office.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GradeDto implements Serializable {

    private Integer level;

    @JsonProperty("sub_class")
    private Integer subClass;

}
