package cl.gob.chinchorro.be.equipamiento.controllers;

import cl.gob.chinchorro.be.equipamiento.dtos.PersonalDTO;
import cl.gob.chinchorro.be.equipamiento.models.services.PersonalService;
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
 * tabla CH_EQUIPAMIENTO.EQMT_PERSONALES en este API.
 * @author Vanessa Alejandra Duque Pereira
 */
@Controller
@CrossOrigin
@Slf4j
@RequestMapping("/personal")
public class PersonalController {
    
    @Autowired
    private PersonalService service;
    
    @Operation(summary = "Obtiene lista JSON de todos los Personal", 
            responses = {
                @ApiResponse(description = "Operacion Exitosa", responseCode = "200", 
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
                @ApiResponse(responseCode = "404", description = "URL No encontrado", content = @Content) 
            }
    )
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String findAll(){
        log.info("cl.gob.chinchorro.be.equipamiento.controllers.PersonalController.findAll()");
        List<PersonalDTO> list = EntityToDTOUtil.personalesToDTO(this.service.findAll());
        return new Gson().toJson(list);
    }
    
    @Operation(summary = "Obtiene objeto JSON de un Personal por su RUT", 
            responses = {
                @ApiResponse(description = "Operacion Exitosa", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
                @ApiResponse(responseCode = "404", description = "URL No encontrado", content = @Content) 
            }
    )
    @GetMapping(value = "/{rut}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String findById(@Parameter(description = "Rut del Personal") @PathVariable("rut") Long rut){
        log.info("cl.gob.chinchorro.be.equipamiento.controllers.PersonalController.findById()");
        PersonalDTO personal = EntityToDTOUtil.entityToDTO(this.service.findById(rut));
        return new Gson().toJson(personal);
    }
    
    @Operation(summary = "Crea un nuevo registro de la tabla CH_EQUIPAMIENTO.EQMT_PERSONALES", 
            responses = {
                @ApiResponse(description = "Operacion Exitosa", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
                @ApiResponse(responseCode = "404", description = "URL No encontrado", content = @Content) 
            }
    )
    @PostMapping()
    public @ResponseBody String create(@RequestBody @Valid PersonalDTO personal){
        log.info("cl.gob.chinchorro.be.equipamiento.controllers.PersonalController.create");
        PersonalDTO personalDTO = EntityToDTOUtil.entityToDTO(this.service.create(personal));
        return new Gson().toJson(personalDTO);
    }
    
    @Operation(summary = "Actualiza un registro existente en la tabla CH_EQUIPAMIENTO.EQMT_PERSONALES", 
            responses = {
                @ApiResponse(description = "Operacion Exitosa", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
                @ApiResponse(responseCode = "404", description = "URL No encontrado", content = @Content) 
            }
    )
    @PutMapping()
    public @ResponseBody String update(@RequestBody @Valid PersonalDTO personal){
        log.info("cl.gob.chinchorro.be.equipamiento.controllers.PersonalController.update");
        PersonalDTO personalDTO = EntityToDTOUtil.entityToDTO(this.service.update(personal));
        return new Gson().toJson(personalDTO);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/deleteLogical/{rut}/{activo}")
    public void deleteLogical(@Parameter(description = "Rut del Personal") @PathVariable("rut") Long rut, 
            @Parameter(description = "Estado del Personal") @PathVariable("activo") int activo){
        log.info("cl.gob.chinchorro.be.equipamiento.controllers.PersonalController.deleteLogical");
        this.service.updateActivo(rut, activo);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/deletePhysical/{rut}")
    public void deletePhysical(@Parameter(description = "Rut del Personal") @PathVariable("rut") Long rut){
        log.info("cl.gob.chinchorro.be.equipamiento.controllers.PersonalController.deletePhysical");
        this.service.delete(rut);
    }
}
