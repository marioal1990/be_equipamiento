package cl.gob.chinchorro.be.equipamiento.models.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import cl.gob.chinchorro.be.equipamiento.models.entities.Personal;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Interfaz Repositorio que genera los CRUD con la 
 * tabla CH_EQUIPAMIENTO.EQMTO_PERSONALES en la base de datos CH_EQUIPAMIENTO
 * @author Vanessa Alejandra Duque Pereira
 */
public interface PersonalRepository extends PagingAndSortingRepository<Personal, Long> {

    /**
     * Actualiza el Estado del Personal por su ID
     * @param rut La Clave primaria de la tabla CH_EQUIPAMIENTO.EQMT_PERSONALES
     * @param activo El valor en bit si está activo o no. EJEM: Activo = 1, Desactivado = 0
     * @return Respuesta de la operación. Activo = 1, Desactivado = 0
     */
    @Modifying
    @Query("UPDATE Personal per SET per.activo = :activo WHERE per.rut = :rut")
    int updateActivo(@Param("rut") Long rut, @Param("activo") int activo);

}
