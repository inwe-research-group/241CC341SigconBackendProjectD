package uni.isw.sigconbackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uni.isw.sigconbackend.model.Contacto;

@Repository
public interface ContactoRepository extends CrudRepository<Contacto,Long>{
    
}
