package uni.isw.sigconbackend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.isw.sigconbackend.model.TipoDocumento;
import uni.isw.sigconbackend.repository.TipoDocumentoRepository;

@Service
public class TipoDocumentoService {
    @Autowired
    TipoDocumentoRepository tipodocumentoRepository;
    public List<TipoDocumento> getTipoDocumento(){
        return (List<TipoDocumento>)tipodocumentoRepository.findAll();
    }
    
}
