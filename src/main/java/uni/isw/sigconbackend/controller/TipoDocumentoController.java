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
import uni.isw.sigconbackend.model.TipoDocumento;
import uni.isw.sigconbackend.service.TipoDocumentoService;

@RestController
@RequestMapping(path="api/v1/tipodocumento")
public class TipoDocumentoController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TipoDocumentoService tipoDocumentoService;
      
    @RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TipoDocumento>> getTipoDocumento() {
            logger.info(">listar");

            List<TipoDocumento> listaTipoDocumento = null;
            try {
                    listaTipoDocumento = tipoDocumentoService.getTipoDocumento();
            } catch (Exception e) {
                    logger.error("Unexpected Exception caught.", e);
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            logger.info(">listar");
            return new ResponseEntity<>(listaTipoDocumento, HttpStatus.OK);
    }
}
