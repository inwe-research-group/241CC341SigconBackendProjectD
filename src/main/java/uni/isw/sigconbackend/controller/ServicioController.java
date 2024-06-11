package uni.isw.sigconbackend.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uni.isw.sigconbackend.model.Servicio;
import uni.isw.sigconbackend.service.ServicioService;

@RestController
@RequestMapping(path="api/v1/servicio")
public class ServicioController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ServicioService servicioService;
      
    @RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Servicio>> getServicios() {
            logger.info(">listar");

            List<Servicio> listaServicio = null;
            try {
                    listaServicio = servicioService.getServicios();
            } catch (Exception e) {
                    logger.error("Unexpected Exception caught.", e);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            logger.info(">listar");
            return new ResponseEntity<>(listaServicio, HttpStatus.OK);
    }
}
