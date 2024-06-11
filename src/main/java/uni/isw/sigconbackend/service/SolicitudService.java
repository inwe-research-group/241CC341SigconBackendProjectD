package uni.isw.sigconbackend.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.isw.sigconbackend.model.Solicitud;
import uni.isw.sigconbackend.repository.SolicitudRepository;

@Service
public class SolicitudService {
    @Autowired
    SolicitudRepository solicitudRepository;
    public List<Solicitud> getSolicitudes(){
        return (List<Solicitud>)solicitudRepository.findAll();        
    }
    public Optional<Solicitud> getSolicitud(Long id){
        return solicitudRepository.findById(id);
    }
    public void saveOrUpdate(Solicitud solicitud){
        solicitudRepository.save(solicitud);
    }
    public void delete(Long id){
        solicitudRepository.deleteById(id);
    }
    
}
