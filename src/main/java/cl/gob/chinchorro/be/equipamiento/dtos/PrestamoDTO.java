package cl.gob.chinchorro.be.equipamiento.dtos;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Clase DTO Prestamo
 * La Clase entidad que representa a la entidad Prestamo que saldrá para afuera
 * @author Vanessa Alejandra Duque Pereira
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrestamoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    protected Long id;
    @NotNull
    protected Long rutPersonal;
    @NotNull
    protected String serieProducto;
    @NotNull
    protected String observaciones;
    @NotNull
    protected String tipoConexion;
    @NotNull
    protected String ubicacion;
    protected String fchCreacion;
    protected String fchModificacion;
    protected int activo;
}
