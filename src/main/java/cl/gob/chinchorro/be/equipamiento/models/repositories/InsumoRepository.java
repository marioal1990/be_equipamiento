package cl.gob.chinchorro.be.equipamiento.models.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import cl.gob.chinchorro.be.equipamiento.models.entities.Insumo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Interfaz Repositorio que genera los CRUD con la 
 * tabla CH_EQUIPAMIENTO.EQMT_INSUMOS en la base de datos CH_EQUIPAMIENTO
 * @author Vanessa Alejandra Duque Pereira
 */
public interface InsumoRepository extends PagingAndSortingRepository<Insumo, Long> {

    /**
     * Actualiza el Estado del Insumo por su ID
     * @param activo El valor en bit si está activo o no. EJEM: Activo = 1, Desactivado = 0
     * @param id La Clave primaria de la tabla CH_EQUIPAMIENTO.EQMT_INSUMOS
     * @return Respuesta de la operación. Activo = 1, Desactivado = 0
     */
    @Modifying
    @Query("UPDATE Insumo i SET i.activo = :activo WHERE i.id = :id")
    int updateActivo(@Param("id") Long id, @Param("activo") int activo);
}
