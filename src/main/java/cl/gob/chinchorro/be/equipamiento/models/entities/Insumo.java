package cl.gob.chinchorro.be.equipamiento.models.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
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
 * Clase Insumo
 * La Clase entidad que representa a la tabla CH_EQUIPAMIENTO.EQMT_INSUMOS
 * @author Vanessa Alejandra Duque Pereira
 */
@Entity
@Table(name="eqmt_insumos")
@NamedQuery(name="Insumo.findAll", query="SELECT i FROM Insumo i")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Insumo implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="INSMS_ID")
    private Long id;

    @Column(name="INSMS_CDG")
    private String cdg;

    @Column(name="INSMS_COLOR")
    private String color;

    @Column(name="INSMS_STOCK")
    private Integer stock;

    @Column(name="INSMS_TAMANO_CANTIDAD")
    private String tamanoCantidad;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonInclude(Include.NON_NULL)
    @Column(name="INSMS_FCH_CREACION")
    private Date fchCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonInclude(Include.NON_NULL)
    @Column(name="INSMS_FCH_MODIFICACION")
    private Date fchModificacion;

    @Column(name="INSMS_ACTIVO")
    private int activo;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PROD_SERIE")
    private Producto producto;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="TPPRO_ID")
    private TpoProducto tpoProducto;
}