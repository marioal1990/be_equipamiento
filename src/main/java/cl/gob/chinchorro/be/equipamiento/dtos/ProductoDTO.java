package cl.gob.chinchorro.be.equipamiento.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase DTO Producto
 * La Clase entidad que representa a la entidad Producto que saldrá para afuera
 * @author Vanessa Alejandra Duque Pereira
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String serie;
    protected String marca;
    protected String modelo;
    protected String nroInventario;
    protected Long idTpoProducto;
    protected String observaciones;
    protected String estado;
    protected String fchCreacion;
    protected String fchModificacion;
    protected int activo;
}
