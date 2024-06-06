package uni.isw.sigconbackend.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.isw.sigconbackend.model.Contacto;
import uni.isw.sigconbackend.repository.ContactoRepository;

@Service
public class ContactoService {
    @Autowired
    ContactoRepository contactoRepository;
    public List<Contacto> getContactos(){
        return (List<Contacto>)contactoRepository.findAll();
    }
    public Optional<Contacto> getContacto(Long id){
        return contactoRepository.findById(id);
    }
    public void saveOrUpdate(Contacto contacto){
        contactoRepository.save(contacto);
    }
    public void delete(Long id){
        contactoRepository.deleteById(id);
    }
    
}
