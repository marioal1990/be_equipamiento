package cl.gob.chinchorro.be.equipamiento.controllers;

import cl.gob.chinchorro.be.equipamiento.dtos.InsumoDTO;
import cl.gob.chinchorro.be.equipamiento.models.entities.Insumo;
import cl.gob.chinchorro.be.equipamiento.models.services.InsumoService;
import cl.gob.chinchorro.be.equipamiento.utils.EntityToDTOUtil;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test Unitarios para el controlador de Insumos
 * @author Mario Araya Lecaros - marioal1990@gmail.com
 */
@SpringBootTest
public class InsumoControllerTest {
    
    private static final String JSON_FIND_ALL = "[\\r\\n    {\\r\\n        \\\"id\\\": 1,\\r\\n        \\\"cdg\\\": \\\"TN-1060\\\",\\r\\n        \\\"color\\\": \\\"BLACK\\\",\\r\\n        \\\"stock\\\": 2,\\r\\n        \\\"tamanoCantidad\\\": \\\"100 ml\\\",\\r\\n        \\\"fchCreacion\\\": \\\"17-oct-2020 16:49:11\\\",\\r\\n        \\\"fchModificacion\\\": \\\"17-oct-2020 16:49:11\\\",\\r\\n        \\\"activo\\\": 1\\r\\n    }\\r\\n]";
    
    @Autowired
    private InsumoController controller;
    
    @Autowired
    private InsumoService service;
    
    @Test
    public void findAllTest(){
        List<Insumo> outputEntity = this.service.findAll();
        Assert.assertEquals(getFindAllEntity(), outputEntity);
        List<InsumoDTO> outputDTO = EntityToDTOUtil.insumosToDTO(outputEntity);
        Assert.assertEquals(getFindAllDTO(), outputDTO);
        String response = this.controller.findAll();
        Assert.assertEquals(JSON_FIND_ALL, response);
    }
    
    @Test
    public void findByIdTest(){
        InsumoDTO outputDTO = EntityToDTOUtil.entityToDTO(this.service.findById(Mockito.anyLong()));
        Assert.assertEquals(getFindByIdDTO(Mockito.anyLong()), outputDTO);
    }
    
    private InsumoDTO getFindByIdDTO(Long id){
        InsumoDTO output = new InsumoDTO();
        output.setId(id);
        output.setCdg(Mockito.anyString());
        output.setColor(Mockito.anyString());
        output.setStock(Mockito.anyInt());
        output.setTamanoCantidad(Mockito.anyString());
        output.setActivo(Mockito.anyInt());
        output.setFchCreacion(Mockito.anyString());
        output.setFchModificacion(Mockito.anyString());
        return output;
    }
    
    private Insumo getFindByIdEntity(Long id){
        Insumo output = new Insumo();
        output.setId(id);
        output.setCdg(Mockito.anyString());
        output.setColor(Mockito.anyString());
        output.setStock(Mockito.anyInt());
        output.setTamanoCantidad(Mockito.anyString());
        output.setActivo(Mockito.anyInt());
        output.setFchCreacion(Mockito.any());
        output.setFchModificacion(Mockito.any());
        return output;
    }
    
    private List<Insumo> getFindAllEntity(){
        List<Insumo> lists = new ArrayList();
        lists.add(getFindByIdEntity(Mockito.anyLong()));
        return lists;
    }
    
    private List<InsumoDTO> getFindAllDTO(){
        List<InsumoDTO> lists = new ArrayList();
        lists.add(getFindByIdDTO(Mockito.anyLong()));
        return lists;
    }
}
