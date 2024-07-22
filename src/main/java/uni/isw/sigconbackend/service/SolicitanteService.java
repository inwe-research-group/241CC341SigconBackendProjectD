package uni.isw.sigconbackend.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.isw.sigconbackend.model.Solicitante;
import uni.isw.sigconbackend.repository.SolicitanteRepository;

@Service
public class SolicitanteService {
    @Autowired
    SolicitanteRepository solicitanteRepository;
    
    public List<Solicitante> getSolicitante(){
        return (List<Solicitante>)solicitanteRepository.findAll();        
    }
    
    public Optional<Solicitante> getSolicitante(Long id){
        return solicitanteRepository.findById(id);
    }
    public Solicitante save(Solicitante solicitante){
        return solicitanteRepository.save(solicitante);
    }
    public Solicitante Update(Solicitante solicitante){
        return solicitanteRepository.save(solicitante);
    }
    public void delete(Long id){
        solicitanteRepository.deleteById(id);
    }
    public List<Solicitante> findByPersonaNdocumento(String ndocumento){
        return solicitanteRepository.findByPersonaNdocumento(ndocumento);
    }
}
