package cl.hakusach.hakusach.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import javax.persistence.GenerationType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
@Builder(toBuilder=true)
public class Evaluacion {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Size(max = 20)
    @NotNull
    private String lang;

    @Size(max = 1000)
    private String code;

    @Column
    @NotNull
    private Long alumnoId;
    
    @Column
    @NotNull
    private Long enunciadoId;

    private float score;

}