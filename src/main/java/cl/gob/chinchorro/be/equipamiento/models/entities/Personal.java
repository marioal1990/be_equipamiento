package cl.gob.chinchorro.be.equipamiento.models.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
 * Clase Personal La Clase entidad que representa a la tabla
 * CH_EQUIPAMIENTO.EQMTO_PERSONALES
 *
 * @author Vanessa Alejandra Duque Pereira
 */
@Entity
@Table(name = "eqmt_personales")
@NamedQuery(name = "Personal.findAll", query = "SELECT p FROM Personal p")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Personal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PER_RUT")
    private Long rut;

    @Column(name = "PER_NOMBRES")
    private String nombres;

    @Column(name = "PER_APELLIDOS")
    private String apellidos;

    @Column(name = "PER_AREA")
    private String area;

    @Column(name = "PER_EMAIL")
    private String email;

    @Column(name = "PER_FONO_CONTACTO")
    private String fonoContacto;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonInclude(Include.NON_NULL)
    @Column(name = "PER_FCH_CREACION")
    private Date fchCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonInclude(Include.NON_NULL)
    @Column(name = "PER_FCH_MODIFICACION")
    private Date fchModificacion;

    @Column(name = "PER_ACTIVO")
    private int activo;

    @JsonInclude(Include.NON_NULL)
    @OneToMany(mappedBy = "personal")
    private List<Prestamo> prestamos;
}
