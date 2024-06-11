
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
import uni.isw.sigconbackend.model.Solicitud;
import uni.isw.sigconbackend.service.SolicitudService;

@RestController
@RequestMapping(path="api/v1/solicitud")
public class SolicitudController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SolicitudService solicitudService;
      
    @RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Solicitud>> getSolicitudes() {
            logger.info(">listar");

            List<Solicitud> listaSolicitudes = null;
            try {
                    listaSolicitudes = solicitudService.getSolicitudes();
            } catch (Exception e) {
                    logger.error("Unexpected Exception caught.", e);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            logger.info(">listar");            
            
            return new ResponseEntity<>(listaSolicitudes, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Solicitud> getSolicitud(@RequestBody Optional<Solicitud> solicitud) {
            logger.info(">search" +  solicitud.toString());
            try {
                    solicitud = solicitudService.getSolicitud(solicitud.get().getId_solicitud());                    
                    
            } catch (Exception e) {
                    logger.error("Unexpected Exception caught.", e);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            logger.info(">search" +  solicitud.toString());
            return new ResponseEntity<>(solicitud.get(), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)	 																		  
    public ResponseEntity<Solicitud> agregar(@RequestBody Solicitud solicitud){

        logger.info(">agregar: " + solicitud.toString());        
        try{                  
            solicitudService.saveOrUpdate(solicitud);
        } catch(Exception e){
            logger.error("Unexpected Exception caught. "+ e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.info(">agregar: " + solicitud.toString()); 
        return new ResponseEntity<>(solicitud, HttpStatus.OK);
    } 
    
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)	 																		  
    public ResponseEntity<Solicitud> actualizar(@RequestBody Solicitud solicitud){

        logger.info(">actualizar: " + solicitud.toString());                
        try{             
             solicitudService.saveOrUpdate(solicitud);
        } catch(Exception e){
            logger.error("Unexpected Exception caught. "+ e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.info(">actualizar: " + solicitud.toString());                
        return new ResponseEntity<>(solicitud, HttpStatus.OK);
    } 
    
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)	 																		  
    public ResponseEntity<Solicitud> delete(@RequestBody Optional<Solicitud> solicitud){

        logger.info(">eliminar: " + solicitud.toString() );                
        try{
            solicitud = solicitudService.getSolicitud(solicitud.get().getId_solicitud());            
            if (solicitud.isPresent())            
                solicitudService.delete(solicitud.get().getId_solicitud());
        } catch(Exception e){
            logger.error("Unexpected Exception caught. "+ e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.info(">eliminar: " + solicitud.toString() );                
        return new ResponseEntity<>(solicitud.get(), HttpStatus.OK);
    } 
}
