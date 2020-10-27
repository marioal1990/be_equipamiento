package cl.gob.chinchorro.be.equipamiento.dtos;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase DTO TpoProducto
 * La Clase entidad que representa a la entidad TpoProducto que saldrá para afuera
 * @author Vanessa Alejandra Duque Pereira
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TpoProductoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    protected Long id;
    @NotNull
    protected String name;
    protected String fchCreacion;
    protected String fchModificacion;
    protected int activo;
}
