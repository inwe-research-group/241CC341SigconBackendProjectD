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
import uni.isw.sigconbackend.model.Solicitante;
import uni.isw.sigconbackend.service.SolicitanteService;

@RestController
@RequestMapping(path="api/v1/solicitante")
public class SolicitanteController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private SolicitanteService solicitanteService;
    
    @RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Solicitante>> getSolicitante() {
            logger.info(">listar");

            List<Solicitante> listaSolicitantes = null;
            try {
                    listaSolicitantes = solicitanteService.getSolicitante();
            } catch (Exception e) {
                    logger.error("Unexpected Exception caught.", e);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            logger.info(">listar");            
            
            return new ResponseEntity<>(listaSolicitantes, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Solicitante> getSolicitante(@RequestBody Optional<Solicitante> solicitante) {
            logger.info(">search" +  solicitante.toString());
            try {
                    solicitante = solicitanteService.getSolicitante(solicitante.get().getId_solicitante());                    
                    
            } catch (Exception e) {
                    logger.error("Unexpected Exception caught.", e);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            logger.info(">search" +  solicitante.toString());
            return new ResponseEntity<>(solicitante.get(), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)	 																		  
    public ResponseEntity<Solicitante> agregar(@RequestBody Solicitante solicitante){

        logger.info(">agregar: " + solicitante.toString());        
        try{                  
            solicitanteService.saveOrUpdate(solicitante);
        } catch(Exception e){
            logger.error("Unexpected Exception caught. "+ e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.info(">agregar: " + solicitante.toString()); 
        return new ResponseEntity<>(solicitante, HttpStatus.OK);
    } 
    
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)	 																		  
    public ResponseEntity<Solicitante> actualizar(@RequestBody Solicitante solicitante){

        logger.info(">actualizar: " + solicitante.toString());                
        try{             
             solicitanteService.saveOrUpdate(solicitante);
        } catch(Exception e){
            logger.error("Unexpected Exception caught. "+ e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.info(">actualizar: " + solicitante.toString());                
        return new ResponseEntity<>(solicitante, HttpStatus.OK);
    } 
    
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)	 																		  
    public ResponseEntity<Solicitante> delete(@RequestBody Optional<Solicitante> solicitante){

        logger.info(">eliminar: " + solicitante.toString() );                
        try{
            solicitante = solicitanteService.getSolicitante(solicitante.get().getId_solicitante());            
            if (solicitante.isPresent())            
                solicitanteService.delete(solicitante.get().getId_solicitante());
        } catch(Exception e){
            logger.error("Unexpected Exception caught. "+ e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.info(">eliminar: " + solicitante.toString() );                
        return new ResponseEntity<>(solicitante.get(), HttpStatus.OK);
    } 
}
