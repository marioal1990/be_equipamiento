package cl.gob.chinchorro.be.equipamiento.dtos;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase DTO Personal
 * La Clase entidad que representa a la entidad Personal que saldrá para afuera
 * @author Vanessa Alejandra Duque Pereira
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonalDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    protected Long rut;
    @NotNull
    protected String nombres;
    @NotNull
    protected String apellidos;
    @NotNull
    protected String area;
    @NotNull
    protected String email;
    @NotNull
    protected String fonoContacto;
    protected String fchCreacion;
    protected String fchModificacion;
    protected int activo;
}
