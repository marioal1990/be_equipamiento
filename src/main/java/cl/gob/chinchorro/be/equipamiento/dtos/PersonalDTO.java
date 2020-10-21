package cl.gob.chinchorro.be.equipamiento.dtos;

import java.io.Serializable;

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

    protected Long rut;
    protected String nombres;
    protected String apellidos;
    protected String area;
    protected String email;
    protected String fonoContacto;
    protected String fchCreacion;
    protected String fchModificacion;
    protected int activo;
}
