package cl.gob.chinchorro.be.equipamiento.models.services;

import cl.gob.chinchorro.be.equipamiento.dtos.InsumoDTO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.gob.chinchorro.be.equipamiento.models.entities.Insumo;
import cl.gob.chinchorro.be.equipamiento.models.entities.Producto;
import cl.gob.chinchorro.be.equipamiento.models.entities.TpoProducto;
import cl.gob.chinchorro.be.equipamiento.models.repositories.InsumoRepository;
import java.util.Date;

/**
 * Clase que representa un DAO para las operaciones transaccionales
 * del objeto entidad de la tabla CH_EQUIPAMIENTO.EQMT_INSUMOS
 * @author Vanessa Alejandra Duque Pereira
 */
@Service
public class InsumoService {

    @Autowired
    private InsumoRepository repository;
    
    @Autowired
    private TpoProductoService tpoProductoService;
    
    @Autowired
    private ProductoService productoService;

    @Transactional(readOnly = true)
    public List<Insumo> findAll(){
        return (List<Insumo>) this.repository.findAll();
    }

    @Transactional(readOnly = true)
    public Insumo findById(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    @Transactional
    public Insumo create(InsumoDTO dto) {
        Insumo insumo = new Insumo();
        insumo.setFchCreacion(new Date());
        insumo.setActivo(1);
        this.setDtoToEntity(dto, insumo);
        return this.repository.save(insumo);
    }

    @Transactional
    public Insumo update(InsumoDTO dto) {
        Insumo insumo = this.findById(dto.getId());
        insumo.setCdg(dto.getCdg());
        insumo.setActivo(dto.getActivo());
        this.setDtoToEntity(dto, insumo);
        return this.repository.save(insumo);
    }

    private void setDtoToEntity(InsumoDTO dto, Insumo insumo) {
        insumo.setColor(dto.getColor());
        insumo.setStock(dto.getStock());
        insumo.setTamanoCantidad(dto.getTamanoCantidad());
        insumo.setFchModificacion(new Date());
        TpoProducto tpoProducto = this.tpoProductoService.findById(dto.getIdTpoProducto());
        insumo.setTpoProducto(tpoProducto);
        Producto producto = this.productoService.findById(dto.getSerieProducto());
        insumo.setProducto(producto);
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
