package uni.isw.sigconbackend.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uni.isw.sigconbackend.model.Solicitante;
@Repository
public interface SolicitanteRepository extends CrudRepository<Solicitante,Long> {
    List<Solicitante> findByPersonaNdocumento(String dni);
}
