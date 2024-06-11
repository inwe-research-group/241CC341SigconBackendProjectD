package uni.isw.sigconbackend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.isw.sigconbackend.model.Servicio;
import uni.isw.sigconbackend.repository.ServicioRepository;

@Service
public class ServicioService {
    @Autowired
    ServicioRepository servicioRepository;
    public List<Servicio> getServicios(){
        return (List<Servicio>)servicioRepository.findAll();
    }
}
