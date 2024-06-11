package uni.isw.sigconbackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uni.isw.sigconbackend.model.Servicio;

@Repository
public interface ServicioRepository extends CrudRepository<Servicio,Long> {
    
}
