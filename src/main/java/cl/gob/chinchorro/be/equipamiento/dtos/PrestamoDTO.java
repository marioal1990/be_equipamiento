package cl.gob.chinchorro.be.equipamiento.dtos;

import java.io.Serializable;

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
    protected Long rutPersonal;
    protected String serieProducto;
    protected String observaciones;
    protected String tipoConexion;
    protected String ubicacion;
    protected String fchCreacion;
    protected String fchModificacion;
    protected int activo;
}
