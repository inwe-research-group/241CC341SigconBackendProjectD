package uni.isw.sigconbackend.controller;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uni.isw.sigconbackend.model.Contacto;
import uni.isw.sigconbackend.service.ContactoService;

@RestController
@RequestMapping(path="api/v1/contacto")
public class ContactoController {    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ContactoService contactoService;
      
    @RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Contacto>> getContactos() {
            logger.info(">listar");

            List<Contacto> contactos = null;
            try {
                    contactos = contactoService.getContactos();
            } catch (Exception e) {
                    logger.error("Unexpected Exception caught.", e);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            logger.info(">listar" + contactos.toString());
            return new ResponseEntity<>(contactos, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Contacto> getContacto(@RequestBody Optional<Contacto> contacto) {
            logger.info(">search" +  contacto.toString());
            try {
                    contacto = contactoService.getContacto(contacto.get().getId());                    
                    
            } catch (Exception e) {
                    logger.error("Unexpected Exception caught.", e);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            logger.info(">search" +  contacto.toString());
            return new ResponseEntity<>(contacto.get(), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/agregar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)	 																		  
    public ResponseEntity<Contacto> agregar(@RequestBody Contacto contacto){

        logger.info(">agregar: " + contacto.toString());        
        try{             
             contactoService.saveOrUpdate(contacto);
        } catch(Exception e){
            logger.error("Unexpected Exception caught. "+ e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.info(">agregar: " + contacto.toString()); 
        return new ResponseEntity<>(contacto, HttpStatus.OK);
    } 
    
    @RequestMapping(value = "/actualizar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)	 																		  
    public ResponseEntity<Contacto> actualizar(@RequestBody Contacto contacto){

        logger.info(">actualizar: " + contacto.toString());                
        try{             
             contactoService.saveOrUpdate(contacto);
        } catch(Exception e){
            logger.error("Unexpected Exception caught. "+ e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.info(">actualizar: " + contacto.toString());                
        return new ResponseEntity<>(contacto, HttpStatus.OK);
    } 
    
    @RequestMapping(value = "/eliminar", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)	 																		  
    public ResponseEntity<Contacto> delete(@RequestBody Optional<Contacto> contacto){

        logger.info(">eliminar: " + contacto.toString() );                
        try{
            contacto = contactoService.getContacto(contacto.get().getId());
            if (contacto.isPresent())            
                contactoService.delete(contacto.get().getId());
        } catch(Exception e){
            logger.error("Unexpected Exception caught. "+ e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.info(">eliminar: " + contacto.toString() );                
        return new ResponseEntity<>(contacto.get(), HttpStatus.OK);
    } 
}
