package cl.gob.chinchorro.be.equipamiento.controllers;

import cl.gob.chinchorro.be.equipamiento.dtos.ProductoDTO;
import cl.gob.chinchorro.be.equipamiento.models.services.ProductoService;
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
 * tabla CH_EQUIPAMIENTO.EQMT_PRODUCTOS en este API.
 * @author Vanessa Alejandra Duque Pereira
 */
@Controller
@CrossOrigin
@Slf4j
@RequestMapping("/producto")
public class ProductoController {
    
    @Autowired
    private ProductoService service;
    
    @Operation(summary = "Obtiene lista JSON de todos los Producto", 
            responses = {
                @ApiResponse(description = "Operacion Exitosa", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
                @ApiResponse(responseCode = "404", description = "URL No encontrado", content = @Content) 
            }
    )
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String findAll(){
        log.info("cl.gob.chinchorro.be.equipamiento.controllers.ProductoController.findAll()");
        List<ProductoDTO> list = EntityToDTOUtil.productosToDTO(this.service.findAll());
        return new Gson().toJson(list);
    }
    
    @Operation(summary = "Obtiene objeto JSON de un Producto por su SERIE", 
            responses = {
                @ApiResponse(description = "Operacion Exitosa", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
                @ApiResponse(responseCode = "404", description = "URL No encontrado", content = @Content) 
            }
    )
    @GetMapping(value = "/{serie}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String findById(@Parameter(description = "Serie del Producto") @PathVariable("serie") String serie){
        log.info("cl.gob.chinchorro.be.equipamiento.controllers.ProductoController.findById()");
        ProductoDTO entity = EntityToDTOUtil.entityToDTO(this.service.findById(serie));
        return new Gson().toJson(entity);
    }
    
    @Operation(summary = "Crea un nuevo registro de la tabla CH_EQUIPAMIENTO.EQMT_PRODUCTOS", 
            responses = {
                @ApiResponse(description = "Operacion Exitosa", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
                @ApiResponse(responseCode = "404", description = "URL No encontrado", content = @Content) 
            }
    )
    @PostMapping()
    public @ResponseBody String create(@RequestBody @Valid ProductoDTO producto){
        log.info("cl.gob.chinchorro.be.equipamiento.controllers.ProductoController.create");
        ProductoDTO productoDTO = EntityToDTOUtil.entityToDTO(this.service.create(producto));
        return new Gson().toJson(productoDTO);
    }
    
    @Operation(summary = "Actualiza un registro existente en la tabla CH_EQUIPAMIENTO.EQMT_PRODUCTOS", 
            responses = {
                @ApiResponse(description = "Operacion Exitosa", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
                @ApiResponse(responseCode = "404", description = "URL No encontrado", content = @Content) 
            }
    )
    @PutMapping()
    public @ResponseBody String update(@RequestBody @Valid ProductoDTO producto){
        log.info("cl.gob.chinchorro.be.equipamiento.controllers.ProductoController.update");
        ProductoDTO productoDTO = EntityToDTOUtil.entityToDTO(this.service.update(producto));
        return new Gson().toJson(productoDTO);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/deleteLogical/{serie}/{activo}")
    public void deleteLogical(@Parameter(description = "Serie del Producto") @PathVariable("serie") String serie, 
            @Parameter(description = "Estado del Producto") @PathVariable("activo") int activo){
        log.info("cl.gob.chinchorro.be.equipamiento.controllers.ProductoController.deleteLogical");
        this.service.updateActivo(serie, activo);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/deletePhysical/{serie}")
    public void deletePhysical(@Parameter(description = "Serie del Producto") @PathVariable("serie") String serie){
        log.info("cl.gob.chinchorro.be.equipamiento.controllers.ProductoController.deletePhysical");
        this.service.delete(serie);
    }
}
