package uni.isw.sigconbackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uni.isw.sigconbackend.model.Predio;

@Repository
public interface PredioRepository extends CrudRepository<Predio,Long>{
    
}
