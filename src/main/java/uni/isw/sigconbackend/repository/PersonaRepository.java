package uni.isw.sigconbackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uni.isw.sigconbackend.model.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona,Long>{
    
}
