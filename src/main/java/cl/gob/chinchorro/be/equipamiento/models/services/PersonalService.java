package cl.gob.chinchorro.be.equipamiento.models.services;

import cl.gob.chinchorro.be.equipamiento.dtos.PersonalDTO;
import cl.gob.chinchorro.be.equipamiento.models.entities.Personal;
import cl.gob.chinchorro.be.equipamiento.models.repositories.PersonalRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase que representa un DAO para las operaciones transaccionales
 * del objeto entidad de la tabla CH_EQUIPAMIENTO.EQMTO_PERSONALES
 * @author Vanessa Alejandra Duque Pereira
 */
@Service
public class PersonalService {

    @Autowired
    private PersonalRepository repository;

    @Transactional(readOnly = true)
    public List<Personal> findAll(){
        return (List<Personal>) this.repository.findAll();
    }

    @Transactional(readOnly = true)
    public Personal findById(Long rut) {
        return this.repository.findById(rut).orElse(null);
    }

    @Transactional
    public Personal create(PersonalDTO personalDTO) {
        Personal personal = new Personal();
        this.setDtoToEntity(personal, personalDTO);
        personal.setFchCreacion(new Date());
        personal.setActivo(1);
        return this.repository.save(personal);
    }

    @Transactional
    public Personal update(PersonalDTO personalDTO) {
        Personal personal = this.findById(personalDTO.getRut());
        this.setDtoToEntity(personal, personalDTO);
        personal.setActivo(personalDTO.getActivo());
        return this.repository.save(personal);
    }

    private void setDtoToEntity(Personal personal, PersonalDTO personalDTO) {
        personal.setRut(personalDTO.getRut());
        personal.setNombres(personalDTO.getNombres());
        personal.setApellidos(personalDTO.getApellidos());
        personal.setArea(personalDTO.getArea());
        personal.setEmail(personalDTO.getEmail());
        personal.setFonoContacto(personalDTO.getFonoContacto());
        personal.setFchModificacion(new Date());
    }
    
    @Transactional
    public void updateActivo(Long rut, int activo){
        this.repository.updateActivo(rut, activo);
    }
    
    @Transactional
    public void delete(Long rut){
        this.repository.deleteById(rut);
    }
}
