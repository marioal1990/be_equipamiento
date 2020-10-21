package cl.gob.chinchorro.be.equipamiento.controllers;

import cl.gob.chinchorro.be.equipamiento.dtos.TpoProductoDTO;
import cl.gob.chinchorro.be.equipamiento.models.services.TpoProductoService;
import cl.gob.chinchorro.be.equipamiento.utils.EntityToDTOUtil;
import com.google.gson.Gson;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Clase controlador que sirve para exponer las operaciones CRUD de la 
 * tabla CH_EQUIPAMIENTO.EQMT_TPO_PRODUCTOS en este API.
 * @author Vanessa Alejandra Duque Pereira
 */
@Controller
@CrossOrigin
@Slf4j
@RequestMapping("/tpo-producto")
public class TpoProductoController {
    
    @Autowired
    private TpoProductoService service;
    
    @Operation(summary = "Obtiene lista JSON de todos los Tipo de Producto", 
            responses = {
                @ApiResponse(description = "Operacion Exitosa", responseCode = "200", 
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
                @ApiResponse(responseCode = "404", description = "URL No encontrado", content = @Content) 
            }
    )
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String findAll(){
        log.info("cl.gob.chinchorro.be.equipamiento.controllers.TpoProductoController.findAll()");
        List<TpoProductoDTO> list = EntityToDTOUtil.tpoProductosToDTO(this.service.findAll());
        return new Gson().toJson(list);
    }
    
    @Operation(summary = "Obtiene objeto JSON de un Tipo Producto por su ID", 
            responses = {
                @ApiResponse(description = "Operacion Exitosa", responseCode = "200", 
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
                @ApiResponse(responseCode = "404", description = "URL No encontrado", content = @Content) 
            }
    )
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String findById(@Parameter(description = "ID del Tipo Producto") @PathVariable("id") Long id){
        log.info("cl.gob.chinchorro.be.equipamiento.controllers.TpoProductoController.findById()");
        TpoProductoDTO entity = EntityToDTOUtil.entityToDTO(this.service.findById(id));
        return new Gson().toJson(entity);
    }
    
    @Operation(summary = "Crea un nuevo registro de la tabla CH_EQUIPAMIENTO.EQMT_TPO_PRODUCTOS", 
            responses = {
                @ApiResponse(description = "Operacion Exitosa", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
                @ApiResponse(responseCode = "404", description = "URL No encontrado", content = @Content) 
            }
    )
    @PostMapping()
    public @ResponseBody String create(@RequestBody @Valid TpoProductoDTO tpoProducto){
        log.info("cl.gob.chinchorro.be.equipamiento.controllers.TpoProductoController.create");
        TpoProductoDTO tpoProductoDTO = EntityToDTOUtil.entityToDTO(this.service.create(tpoProducto));
        return new Gson().toJson(tpoProductoDTO);
    }
    
    @Operation(summary = "Actualiza un registro existente en la tabla CH_EQUIPAMIENTO.EQMT_TPO_PRODUCTOS", 
            responses = {
                @ApiResponse(description = "Operacion Exitosa", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
                @ApiResponse(responseCode = "404", description = "URL No encontrado", content = @Content) 
            }
    )
    @PutMapping()
    public @ResponseBody String update(@RequestBody @Valid TpoProductoDTO tpoProducto){
        log.info("cl.gob.chinchorro.be.equipamiento.controllers.TpoProductoController.update");
        TpoProductoDTO tpoProductoDTO = EntityToDTOUtil.entityToDTO(this.service.update(tpoProducto));
        return new Gson().toJson(tpoProductoDTO);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/deleteLogical/{id}/{activo}")
    public void deleteLogical(@Parameter(description = "Identificador del Tipo de Producto") @PathVariable("id") Long id, 
            @Parameter(description = "Estado del Tipo de Producto") @PathVariable("activo") int activo){
        log.info("cl.gob.chinchorro.be.equipamiento.controllers.TpoProductoController.deleteLogical");
        this.service.updateActivo(id, activo);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/deletePhysical/{id}")
    public void deletePhysical(@Parameter(description = "Identificador del Tipo de Producto") @PathVariable("id") Long id){
        log.info("cl.gob.chinchorro.be.equipamiento.controllers.TpoProductoController.deletePhysical");
        this.service.delete(id);
    }
}
