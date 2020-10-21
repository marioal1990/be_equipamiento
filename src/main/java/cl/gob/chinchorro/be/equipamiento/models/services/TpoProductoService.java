/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.gob.chinchorro.be.equipamiento.models.services;

import cl.gob.chinchorro.be.equipamiento.dtos.TpoProductoDTO;
import cl.gob.chinchorro.be.equipamiento.models.entities.TpoProducto;
import cl.gob.chinchorro.be.equipamiento.models.repositories.TpoProductoRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase que representa un DAO para las operaciones transaccionales
 * del objeto entidad de la tabla CH_EQUIPAMIENTO.EQMT_TPO_PRODUCTOS
 * @author Vanessa Alejandra Duque Pereira
 */
@Service
public class TpoProductoService {

    @Autowired
    private TpoProductoRepository repository;

    @Transactional(readOnly = true)
    public List<TpoProducto> findAll(){
        return (List<TpoProducto>) this.repository.findAll();
    }

    @Transactional(readOnly = true)
    public TpoProducto findById(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    @Transactional
    public TpoProducto create(TpoProductoDTO tpoProductoDTO) {
        TpoProducto tpoProducto = new TpoProducto();
        tpoProducto.setName(tpoProductoDTO.getName());
        tpoProducto.setFchCreacion(new Date());
        tpoProducto.setFchModificacion(new Date());
        tpoProducto.setActivo(1);
        return this.repository.save(tpoProducto);
    }

    @Transactional
    public TpoProducto update(TpoProductoDTO tpoProductoDTO) {
        TpoProducto tpoProducto = this.findById(tpoProductoDTO.getId());
        tpoProducto.setName(tpoProductoDTO.getName());
        tpoProducto.setFchModificacion(new Date());
        return this.repository.save(tpoProducto);
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
