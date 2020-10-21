package cl.gob.chinchorro.be.equipamiento.models.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * Clase TpoProducto La Clase entidad que representa a la tabla
 * CH_EQUIPAMIENTO.EQMT_TPO_PRODUCTOS
 *
 * @author Vanessa Alejandra Duque Pereira
 */
@Entity
@Table(name = "eqmt_tpo_productos")
@NamedQuery(name = "TpoProducto.findAll", query = "SELECT t FROM TpoProducto t")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TpoProducto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TPPRO_ID")
    private Long id;

    @Column(name = "TPPRO_NAME")
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonInclude(Include.NON_NULL)
    @Column(name = "TPPRO_FCH_CREACION")
    private Date fchCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonInclude(Include.NON_NULL)
    @Column(name = "TPPRO_FCH_MODIFICACION")
    private Date fchModificacion;

    @Column(name = "TPPRO_ACTIVO")
    private int activo;

    @JsonInclude(Include.NON_NULL)
    @OneToMany(mappedBy = "tpoProducto")
    private List<Insumo> insumos;

    @JsonInclude(Include.NON_NULL)
    @OneToMany(mappedBy = "tpoProducto")
    private List<Producto> productos;
}
