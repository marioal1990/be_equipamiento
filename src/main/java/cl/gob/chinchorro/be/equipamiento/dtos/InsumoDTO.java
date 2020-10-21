package cl.gob.chinchorro.be.equipamiento.dtos;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase DTO Insumo
 * La Clase entidad que representa a la entidad Insumo que saldrá para afuera
 * @author Vanessa Alejandra Duque Pereira
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InsumoDTO {
    
    protected Long id;
    @NotNull
    protected String cdg;
    @NotNull
    protected String serieProducto;
    @NotNull
    protected Long idTpoProducto;
    @NotNull
    protected String color;
    @NotNull
    protected Integer stock;
    @NotNull
    protected String tamanoCantidad;
    protected String fchCreacion;
    protected String fchModificacion;
    protected int activo;
}
