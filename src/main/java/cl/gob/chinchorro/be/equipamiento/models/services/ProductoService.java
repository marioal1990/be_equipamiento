/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.gob.chinchorro.be.equipamiento.models.services;

import cl.gob.chinchorro.be.equipamiento.dtos.ProductoDTO;
import cl.gob.chinchorro.be.equipamiento.models.entities.Producto;
import cl.gob.chinchorro.be.equipamiento.models.entities.TpoProducto;
import cl.gob.chinchorro.be.equipamiento.models.repositories.ProductoRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase que representa un DAO para las operaciones transaccionales
 * del objeto entidad de la tabla CH_EQUIPAMIENTO.EQMT_PRODUCTOS
 * @author Vanessa Alejandra Duque Pereira
 */
@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repository;
    
    @Autowired
    private TpoProductoService tpoProductoService;

    @Transactional(readOnly = true)
    public List<Producto> findAll(){
        return (List<Producto>) this.repository.findAll();
    }

    @Transactional(readOnly = true)
    public Producto findById(String serie) {
        return this.repository.findById(serie).orElse(null);
    }

    @Transactional
    public Producto create(ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setSerie(productoDTO.getSerie());
        this.setDtoToEntity(producto, productoDTO);
        producto.setFchCreacion(new Date());
        producto.setActivo(1);
        return this.repository.save(producto);
    }

    @Transactional
    public Producto update(ProductoDTO productoDTO) {
        Producto producto = this.findById(productoDTO.getSerie());
        this.setDtoToEntity(producto, productoDTO);
        producto.setActivo(productoDTO.getActivo());
        return this.repository.save(producto);
    }

    private void setDtoToEntity(Producto producto, ProductoDTO productoDTO) {
        producto.setMarca(productoDTO.getMarca());
        producto.setModelo(productoDTO.getModelo());
        producto.setNroInventario(productoDTO.getNroInventario());
        producto.setObservaciones(productoDTO.getObservaciones());
        producto.setEstado(productoDTO.getEstado());
        producto.setFchModificacion(new Date());
        
        TpoProducto tpoProducto = this.tpoProductoService.findById(productoDTO.getIdTpoProducto());
        producto.setTpoProducto(tpoProducto);
    }
    
    @Transactional
    public void updateActivo(String serie, int activo){
        this.repository.updateActivo(serie, activo);
    }
    
    @Transactional
    public void delete(String serie){
        this.repository.deleteById(serie);
    }
}
