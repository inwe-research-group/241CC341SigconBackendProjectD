package uni.isw.sigconbackend.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.isw.sigconbackend.model.Predio;
import uni.isw.sigconbackend.repository.PredioRepository;

@Service
public class PredioService {
    @Autowired
    PredioRepository predioRepository;
    public List<Predio> getPredios(){
        return (List<Predio>)predioRepository.findAll();        
    }
    public Optional<Predio> getPredio(Long id){
        return predioRepository.findById(id);
    }
    public void saveOrUpdate(Predio predio){
        predioRepository.save(predio);
    }
    public void delete(Long id){
        predioRepository.deleteById(id);
    }
    public List<Predio> findByRuc(String ruc){
        return predioRepository.findByRuc(ruc);
    }
}
