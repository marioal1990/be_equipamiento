package cl.gob.chinchorro.be.equipamiento.models.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import cl.gob.chinchorro.be.equipamiento.models.entities.Producto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Interfaz Repositorio que genera los CRUD con la 
 * tabla CH_EQUIPAMIENTO.EQMT_PRODUCTOS en la base de datos CH_EQUIPAMIENTO
 * @author Vanessa Alejandra Duque Pereira
 */
public interface ProductoRepository extends PagingAndSortingRepository<Producto, String> {

    /**
     * Actualiza el Estado del Productos por su SERIE
     * @param serie La Clave primaria de la tabla CH_EQUIPAMIENTO.EQMT_PRODUCTOS
     * @param activo El valor en bit si está activo o no. EJEM: Activo = 1, Desactivado = 0
     * @return Respuesta de la operación. Activo = 1, Desactivado = 0
     */
    @Modifying
    @Query("UPDATE Producto pro SET pro.activo = :activo WHERE pro.serie = :serie")
    int updateActivo(@Param("serie") String serie, @Param("activo") int activo);
}
