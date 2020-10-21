/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.gob.chinchorro.be.equipamiento.models.services;

import cl.gob.chinchorro.be.equipamiento.dtos.PrestamoDTO;
import cl.gob.chinchorro.be.equipamiento.models.entities.Personal;
import cl.gob.chinchorro.be.equipamiento.models.entities.Prestamo;
import cl.gob.chinchorro.be.equipamiento.models.entities.Producto;
import cl.gob.chinchorro.be.equipamiento.models.repositories.PrestamoRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase que representa un DAO para las operaciones transaccionales
 * del objeto entidad de la tabla CH_EQUIPAMIENTO.EQMT_PRESTAMOS
 * @author Vanessa Alejandra Duque Pereira
 */
@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository repository;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private PersonalService personalService;

    @Transactional(readOnly = true)
    public List<Prestamo> findAll(){
        return (List<Prestamo>) this.repository.findAll();
    }

    @Transactional(readOnly = true)
    public Prestamo findById(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    @Transactional
    public Prestamo create(PrestamoDTO dto) {
        Prestamo prestamo = new Prestamo();
        this.setDtoToEntity(dto, prestamo);
        prestamo.setFchCreacion(new Date());
        prestamo.setActivo(dto.getActivo());
        return this.repository.save(prestamo);
    }

    @Transactional
    public Prestamo update(PrestamoDTO dto) {
        Prestamo prestamo = this.findById(dto.getId());
        this.setDtoToEntity(dto, prestamo);
        prestamo.setActivo(dto.getActivo());
        return this.repository.save(prestamo);
    }

    private void setDtoToEntity(PrestamoDTO dto, Prestamo prestamo) {
        prestamo.setTipoConexion(dto.getTipoConexion());
        prestamo.setUbicacion(dto.getUbicacion());
        prestamo.setObservaciones(dto.getObservaciones());
        prestamo.setFchModificacion(new Date());
        Personal personal = this.personalService.findById(dto.getRutPersonal());
        prestamo.setPersonal(personal);
        Producto producto = this.productoService.findById(dto.getSerieProducto());
        prestamo.setProducto(producto);
    }
    
    @Transactional
    public void updateActivo(Long id, int activo){
        this.repository.updateActivo(id, activo);
    }
    
    @Transactional
    public void delete(Long id){
        this.repository.deleteById(id);
    }
}
