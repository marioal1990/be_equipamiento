package cl.gob.chinchorro.be.equipamiento.models.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase Producto La Clase entidad que representa a la tabla
 * CH_EQUIPAMIENTO.EQMT_PRODUCTOS
 *
 * @author Vanessa Alejandra Duque Pereira
 */
@Entity
@Table(name = "eqmt_productos")
@NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PROD_SERIE")
    private String serie;

    @Column(name = "PROD_ESTADO")
    private String estado;

    @Column(name = "PROD_MARCA")
    private String marca;

    @Column(name = "PROD_MODELO")
    private String modelo;

    @Column(name = "PROD_NRO_INVENTARIO")
    private String nroInventario;

    @Lob
    @Column(name = "PROD_OBSERVACIONES")
    private String observaciones;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonInclude(Include.NON_NULL)
    @Column(name = "PROD_FCH_CREACION")
    private Date fchCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonInclude(Include.NON_NULL)
    @Column(name = "PROD_FCH_MODIFICACION")
    private Date fchModificacion;

    @Column(name = "PROD_ACTIVO")
    private int activo;

    @JsonInclude(Include.NON_NULL)
    @OneToMany(mappedBy = "producto")
    private List<Insumo> insumos;

    @JsonInclude(Include.NON_NULL)
    @OneToMany(mappedBy = "producto")
    private List<Prestamo> prestamos;

    @JsonInclude(Include.NON_NULL)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TPPRO_ID")
    private TpoProducto tpoProducto;
}
