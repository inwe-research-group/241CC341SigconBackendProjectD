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
import uni.isw.sigconbackend.model.Predio;
import uni.isw.sigconbackend.service.PredioService;
@RestController
@RequestMapping(path="api/v1/predio")
public class PredioController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PredioService predioService;
      
    @RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Predio>> getPredios() {
            logger.info(">listar");

            List<Predio> listaPredios = null;
            try {
                    listaPredios = predioService.getPredios();
            } catch (Exception e) {
                    logger.error("Unexpected Exception caught.", e);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            logger.info(">listar");            
            
            return new ResponseEntity<>(listaPredios, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Predio> getPredio(@RequestBody Optional<Predio> predio) {
            logger.info(">search" +  predio.toString());
            try {
                    predio = predioService.getPredio(predio.get().getId_predio());                    
                    
            } catch (Exception e) {
                    logger.error("Unexpected Exception caught.", e);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            logger.info(">search" +  predio.toString());
            return new ResponseEntity<>(predio.get(), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)	 																		  
    public ResponseEntity<Predio> agregar(@RequestBody Predio predio){

        logger.info(">agregar: " + predio.toString());        
        try{                  
            predioService.saveOrUpdate(predio);
        } catch(Exception e){
            logger.error("Unexpected Exception caught. "+ e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.info(">agregar: " + predio.toString()); 
        return new ResponseEntity<>(predio, HttpStatus.OK);
    } 
    
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)	 																		  
    public ResponseEntity<Predio> actualizar(@RequestBody Predio predio){

        logger.info(">actualizar: " + predio.toString());                
        try{             
             predioService.saveOrUpdate(predio);
        } catch(Exception e){
            logger.error("Unexpected Exception caught. "+ e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.info(">actualizar: " + predio.toString());                
        return new ResponseEntity<>(predio, HttpStatus.OK);
    } 
    
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)	 																		  
    public ResponseEntity<Predio> delete(@RequestBody Optional<Predio> predio){

        logger.info(">eliminar: " + predio.toString() );                
        try{
            predio = predioService.getPredio(predio.get().getId_predio());            
            if (predio.isPresent())            
                predioService.delete(predio.get().getId_predio());
        } catch(Exception e){
            logger.error("Unexpected Exception caught. "+ e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.info(">eliminar: " + predio.toString() );                
        return new ResponseEntity<>(predio.get(), HttpStatus.OK);
    } 
}
