package uni.isw.sigconbackend.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uni.isw.sigconbackend.model.TipoDocumento;
@Repository
public interface TipoDocumentoRepository extends CrudRepository<TipoDocumento,Long>{
    
}
