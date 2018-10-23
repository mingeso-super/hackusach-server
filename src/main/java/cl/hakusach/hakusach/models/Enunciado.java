package cl.hakusach.hakusach.models;

import java.util.List;

import javax.persistence.ElementCollection;
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
public class Enunciado {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Size(max = 500)
    @NotNull
    private String enunciado;

    @ElementCollection(targetClass=String.class)
    private List<String> entradas;

    @ElementCollection(targetClass=String.class)
    private List<String> salidas;

}