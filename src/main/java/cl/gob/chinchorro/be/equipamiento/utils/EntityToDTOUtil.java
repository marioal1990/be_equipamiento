package cl.gob.chinchorro.be.equipamiento.utils;

import cl.gob.chinchorro.be.equipamiento.dtos.InsumoDTO;
import cl.gob.chinchorro.be.equipamiento.dtos.PersonalDTO;
import cl.gob.chinchorro.be.equipamiento.dtos.PrestamoDTO;
import cl.gob.chinchorro.be.equipamiento.dtos.ProductoDTO;
import cl.gob.chinchorro.be.equipamiento.dtos.TpoProductoDTO;
import cl.gob.chinchorro.be.equipamiento.models.entities.Insumo;
import cl.gob.chinchorro.be.equipamiento.models.entities.Personal;
import cl.gob.chinchorro.be.equipamiento.models.entities.Prestamo;
import cl.gob.chinchorro.be.equipamiento.models.entities.Producto;
import cl.gob.chinchorro.be.equipamiento.models.entities.TpoProducto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * Clase que parsea la entidad a DTO para pasarla a Front-End
 * @author Vanessa Alejandra Duque Pereira
 */
@Component
public class EntityToDTOUtil {
    
    private EntityToDTOUtil(){
    }
    
    //**********************
    //INSUMO
    //**********************
    
    /**
     * Parsea la clase entidad CH_EQUIPAMIENTO.EQMT_INSUMOS a DTO
     * @param entity Clase Entidad que representa a la tabla CH_EQUIPAMIENTO.EQMT_INSUMOS
     * @return Objeto de clase DTO
     */
    public static InsumoDTO entityToDTO(Insumo entity){
        InsumoDTO dto = new InsumoDTO();
        dto.setId(entity.getId());
        dto.setCdg(entity.getCdg());
        dto.setColor(entity.getColor());
        dto.setStock(entity.getStock());
        dto.setTamanoCantidad(entity.getTamanoCantidad());
        dto.setFchCreacion(DateUtil.dateToString(entity.getFchCreacion()));
        dto.setFchModificacion(DateUtil.dateToString(entity.getFchModificacion()));
        dto.setActivo(entity.getActivo());
        return dto;
    }
    
    /**
     * Parsea una lista entidad CH_EQUIPAMIENTO.EQMT_INSUMOS a lista DTO
     * @param entities Lista de objeto entidad que representa a la tabla CH_EQUIPAMIENTO.EQMT_INSUMOS
     * @return Lista de objeto de clase DTO
     */
    public static List<InsumoDTO> insumosToDTO(List<Insumo> entities){
        List<InsumoDTO> insumosDTO = new ArrayList<>();
        entities.stream().map(entity -> entityToDTO(entity)).forEachOrdered(dto -> {
            insumosDTO.add(dto);
        });
        return insumosDTO;
    }
    
    //**********************
    //PERSONAL
    //**********************
    
    /**
     * Parsea la clase entidad CH_EQUIPAMIENTO.EQMT_PERSONALES a DTO
     * @param entity Clase Entidad que representa a la tabla CH_EQUIPAMIENTO.EQMT_PERSONALES
     * @return Objeto de clase DTO
     */
    public static PersonalDTO entityToDTO(Personal entity){
        PersonalDTO dto = new PersonalDTO();
        dto.setRut(entity.getRut());
        dto.setNombres(entity.getNombres());
        dto.setApellidos(entity.getApellidos());
        dto.setArea(entity.getArea());
        dto.setEmail(entity.getEmail());
        dto.setFonoContacto(entity.getFonoContacto());
        dto.setFchCreacion(DateUtil.dateToString(entity.getFchCreacion()));
        dto.setFchModificacion(DateUtil.dateToString(entity.getFchModificacion()));
        dto.setActivo(entity.getActivo());
        return dto;
    }
    
    /**
     * Parsea una lista entidad CH_EQUIPAMIENTO.EQMT_PERSONALES a lista DTO
     * @param entities Lista de objeto entidad que representa a la tabla CH_EQUIPAMIENTO.EQMT_PERSONALES
     * @return Lista de objeto de clase DTO
     */
    public static List<PersonalDTO> personalesToDTO(List<Personal> entities) {
        List<PersonalDTO> dtos = new ArrayList<>();
        entities.stream().map(entity -> entityToDTO(entity)).forEachOrdered(dto -> {
            dtos.add(dto);
        });
        return dtos;
    }
    
    //**********************
    //TIPO PRODUCTO
    //**********************
    
    /**
     * Parsea la clase entidad CH_EQUIPAMIENTO.EQMT_TPO_PRODUCTOS a DTO
     * @param entity Clase Entidad que representa a la tabla CH_EQUIPAMIENTO.EQMT_TPO_PRODUCTOS
     * @return Objeto de clase DTO
     */
    public static TpoProductoDTO entityToDTO(TpoProducto entity){
        TpoProductoDTO dto = new TpoProductoDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setFchCreacion(DateUtil.dateToString(entity.getFchCreacion()));
        dto.setFchModificacion(DateUtil.dateToString(entity.getFchModificacion()));
        dto.setActivo(entity.getActivo());
        return dto;
    }
    
    /**
     * Parsea una lista entidad CH_EQUIPAMIENTO.EQMT_TPO_PRODUCTOS a lista DTO
     * @param entities Lista de objeto entidad que representa a la tabla CH_EQUIPAMIENTO.EQMT_TPO_PRODUCTOS
     * @return Lista de objeto de clase DTO
     */
    public static List<TpoProductoDTO> tpoProductosToDTO(List<TpoProducto> entities) {
        List<TpoProductoDTO> dtos = new ArrayList<>();
        entities.stream().map(entity -> entityToDTO(entity)).forEachOrdered(dto -> {
            dtos.add(dto);
        });
        return dtos;
    }
    
    //**********************
    //PRODUCTO
    //**********************
    
    /**
     * Parsea la clase entidad CH_EQUIPAMIENTO.EQMT_PRODUCTOS a DTO
     * @param entity Clase Entidad que representa a la tabla CH_EQUIPAMIENTO.EQMT_PRODUCTOS
     * @return Objeto de clase DTO
     */
    public static ProductoDTO entityToDTO(Producto entity){
        ProductoDTO dto = new ProductoDTO();
        dto.setSerie(entity.getSerie());
        dto.setModelo(entity.getModelo());
        dto.setMarca(entity.getMarca());
        dto.setNroInventario(entity.getNroInventario());
        dto.setObservaciones(entity.getObservaciones());
        dto.setEstado(entity.getEstado());
        dto.setFchCreacion(DateUtil.dateToString(entity.getFchCreacion()));
        dto.setFchModificacion(DateUtil.dateToString(entity.getFchModificacion()));
        dto.setActivo(entity.getActivo());
        return dto;
    }
    
    /**
     * Parsea una lista entidad CH_EQUIPAMIENTO.EQMT_PRODUCTOS a lista DTO
     * @param entities Lista de objeto entidad que representa a la tabla CH_EQUIPAMIENTO.EQMT_PRODUCTOS
     * @return Lista de objeto de clase DTO
     */
    public static List<ProductoDTO> productosToDTO(List<Producto> entities) {
        List<ProductoDTO> dtos = new ArrayList<>();
        entities.stream().map(entity -> entityToDTO(entity)).forEachOrdered(dto -> {
            dtos.add(dto);
        });
        return dtos;
    }
    
    //**********************
    //PRESTAMO
    //**********************
    
    /**
     * Parsea la clase entidad CH_EQUIPAMIENTO.EQMT_PRESTAMOS a DTO
     * @param entity Clase Entidad que representa a la tabla CH_EQUIPAMIENTO.EQMT_PRESTAMOS
     * @return Objeto de clase DTO
     */
    public static PrestamoDTO entityToDTO(Prestamo entity){
        PrestamoDTO dto = new PrestamoDTO();
        dto.setId(entity.getId());
        dto.setRutPersonal(entity.getPersonal().getRut());
        dto.setSerieProducto(entity.getProducto().getSerie());
        dto.setObservaciones(entity.getObservaciones());
        dto.setTipoConexion(entity.getTipoConexion());
        dto.setUbicacion(entity.getUbicacion());
        dto.setFchCreacion(DateUtil.dateToString(entity.getFchCreacion()));
        dto.setFchModificacion(DateUtil.dateToString(entity.getFchModificacion()));
        dto.setActivo(entity.getActivo());
        return dto;
    }
    
    /**
     * Parsea una lista entidad CH_EQUIPAMIENTO.EQMT_PRESTAMOS a lista DTO
     * @param entities Lista de objeto entidad que representa a la tabla CH_EQUIPAMIENTO.EQMT_PRESTAMOS
     * @return Lista de objeto de clase DTO
     */
    public static List<PrestamoDTO> prestamosToDTO(List<Prestamo> entities) {
        List<PrestamoDTO> dtos = new ArrayList<>();
        entities.stream().map(entity -> entityToDTO(entity)).forEachOrdered(dto -> {
            dtos.add(dto);
        });
        return dtos;
    }
}
