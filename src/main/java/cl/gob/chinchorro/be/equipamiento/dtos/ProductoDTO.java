package cl.gob.chinchorro.be.equipamiento.dtos;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

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

    @NotNull
    protected String serie;
    @NotNull
    protected String marca;
    @NotNull
    protected String modelo;
    @NotNull
    protected String nroInventario;
    @NotNull
    protected Long idTpoProducto;
    @NotNull
    protected String observaciones;
    @NotNull
    protected String estado;
    protected String fchCreacion;
    protected String fchModificacion;
    protected int activo;
}
