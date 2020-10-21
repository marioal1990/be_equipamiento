package cl.gob.chinchorro.be.equipamiento.models.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import cl.gob.chinchorro.be.equipamiento.models.entities.Prestamo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PrestamoRepository extends PagingAndSortingRepository<Prestamo, Long> {

    /**
     * Actualiza el Estado del Prestamo por su ID
     * @param activo El valor en bit si está activo o no. EJEM: Activo = 1, Desactivado = 0
     * @param id La Clave primaria de la tabla CH_EQUIPAMIENTO.EQMT_PRESTAMOS
     * @return Respuesta de la operación. Activo = 1, Desactivado = 0
     */
    @Modifying
    @Query("UPDATE Prestamo p SET p.activo = :activo WHERE p.id = :id")
    int updateActivo(@Param("id") Long id, @Param("activo") int activo);
}
