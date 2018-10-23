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
public class Alumno {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Size(max = 200)
    @NotNull
    private String nombres;

    @Size(max = 200)
    @NotNull
    private String apellidos;

    @Size(max = 100)
    @NotNull
    @Column(unique=true)
    private String username;

    @Size(max = 100)
    @NotNull
    private String password;

}