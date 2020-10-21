package cl.gob.chinchorro.be.equipamiento.models.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Clase Personal La Clase entidad que representa a la tabla
 * CH_EQUIPAMIENTO.EQMT_PRESTAMOS
 *
 * @author Vanessa Alejandra Duque Pereira
 */
@Entity
@Table(name = "eqmt_prestamos")
@NamedQuery(name = "Prestamo.findAll", query = "SELECT p FROM Prestamo p")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Prestamo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRSTMO_ID")
    private Long id;

    @Lob
    @Column(name = "PRSTMO_OBSERVACIONES")
    private String observaciones;

    @Column(name = "PRSTMO_TIPO_CONEXION")
    private String tipoConexion;

    @Column(name = "PRSTMO_UBICACION")
    private String ubicacion;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonInclude(Include.NON_NULL)
    @Column(name = "PRSTMO_FCH_CREACION")
    private Date fchCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonInclude(Include.NON_NULL)
    @Column(name = "PRSTMO_FCH_MODIFICACION")
    private Date fchModificacion;

    @Column(name = "PRSTMO_ACTIVO")
    private int activo;

    @JsonInclude(Include.NON_NULL)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PER_RUT")
    private Personal personal;

    @JsonInclude(Include.NON_NULL)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROD_SERIE")
    private Producto producto;
}
