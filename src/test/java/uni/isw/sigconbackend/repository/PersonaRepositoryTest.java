package uni.isw.sigconbackend.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import uni.isw.sigconbackend.model.TipoDocumento;
import uni.isw.sigconbackend.model.Persona;
import uni.isw.sigconbackend.model.Ubigeo;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PersonaRepositoryTest {
    
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;
    @Autowired
    private UbigeoRepository ubigeoRepository;
    private TipoDocumento tipodocumento;
    private Ubigeo ubigeo1;
    private Ubigeo ubigeo2;
    
    @BeforeEach
    public void init() {  
        tipodocumento = TipoDocumento.builder()
                .descripcion("DNI").build();       
        
        tipoDocumentoRepository.save(tipodocumento);        
        
        ubigeo1=Ubigeo.builder()
                .idubigeo("070104")
                .departamento("Callao")
                .provincia("La Perla")
                .distrito("La Perla").build();
        
        ubigeo2=Ubigeo.builder()
                .idubigeo("150114")
                .departamento("Lima")
                .provincia("Lima")
                .distrito("La Molina").build();               
                
        ubigeoRepository.save(ubigeo1);    
        ubigeoRepository.save(ubigeo2);  
    }    
    
    @Test
    public void PersonaRepository_SaveAll_ReturnSavedPersona() {     
        int id_tipo_documento=tipodocumento.getId_tipo_documento();  
        String idubigeo=ubigeo1.getIdubigeo();

        //Arrange
        Persona persona = Persona.builder()
                .apellido_paterno("Chirinos")
                .apellido_materno("Soto")
                .nombres("Patricia")
                .fecha_nacimiento(new Date(1992-04-05))
                .id_tipo_documento(id_tipo_documento)
                .ndocumento("998887766")
                .direccion("Av. Guardia Chalaca 526")
                .idubigeo(idubigeo).build();   

        //Act
        Persona newPersona = personaRepository.save(persona);

        //Assert
        Assertions.assertThat(newPersona).isNotNull();
        Assertions.assertThat(newPersona.getId_persona()).isGreaterThan(0);
    }
    
    @Test
    public void PersonaRepository_GetAll_ReturnMoreThenOnePersona() {       
        int id_tipo_documento=tipodocumento.getId_tipo_documento();      
        String idubigeo1=ubigeo1.getIdubigeo();
        String idubigeo2=ubigeo2.getIdubigeo();
        
        Persona persona1 = Persona.builder()
                .apellido_paterno("Chirinos")
                .apellido_materno("Soto")
                .nombres("Patricia")
                .fecha_nacimiento(new Date(1992-04-05))
                .id_tipo_documento(id_tipo_documento)
                .ndocumento("998887766")
                .direccion("Av. Guardia Chalaca 526")
                .idubigeo(idubigeo1).build();        
        Persona persona2 = Persona.builder()
                .apellido_paterno("Cavero")
                .apellido_materno("Alva")
                .nombres("Alejandro")
                .fecha_nacimiento(new Date(2000-04-05))
                .id_tipo_documento(id_tipo_documento)
                .ndocumento("993337766")
                .direccion("Av. Los Fresnos 351")
                .idubigeo(idubigeo2).build();              
        
        personaRepository.save(persona1);
        personaRepository.save(persona2);

        List<Persona> personaList = (List<Persona>)personaRepository.findAll();

        Assertions.assertThat(personaList).isNotNull();
        Assertions.assertThat(personaList.size()).isEqualTo(2);
       
    }
    @Test
    public void PersonaRepository_FindById_ReturnPersona() {
        int id_tipo_documento=tipodocumento.getId_tipo_documento();      
        String idubigeo=ubigeo1.getIdubigeo();
        Persona persona = Persona.builder()
                .apellido_paterno("Chirinos")
                .apellido_materno("Soto")
                .nombres("Patricia")
                .fecha_nacimiento(new Date(1992-04-05))
                .id_tipo_documento(id_tipo_documento)
                .ndocumento("998887766")
                .direccion("Av. Guardia Chalaca 526")
                .idubigeo(idubigeo).build();    

        personaRepository.save(persona);

        Persona personaList = personaRepository.findById(persona.getId_persona()).get();

        Assertions.assertThat(personaList).isNotNull();
    }
    
    @Test
    public void PersonaRepository_UpdatePersona_ReturnPersonaNotNull() {
        int id_tipo_documento=tipodocumento.getId_tipo_documento();      
        String idubigeo1=ubigeo1.getIdubigeo();
        String idubigeo2=ubigeo2.getIdubigeo();
        Persona persona = Persona.builder()
                .apellido_paterno("Chirinos")
                .apellido_materno("Soto")
                .nombres("Patricia")
                .fecha_nacimiento(new Date(1992-04-05))
                .id_tipo_documento(id_tipo_documento)
                .ndocumento("998887766")
                .direccion("Av. Guardia Chalaca 526")
                .idubigeo(idubigeo1).build();    

        personaRepository.save(persona);

        Persona personaSave = personaRepository.findById(persona.getId_persona()).get();
        personaSave.setNombres("Patricia Roxana");
        personaSave.setIdubigeo(idubigeo2);

        Persona updatedPersona = personaRepository.save(personaSave);

        Assertions.assertThat(updatedPersona.getNombres()).isNotNull();
        Assertions.assertThat(updatedPersona.getIdubigeo()).isNotNull();
    }
    
    @Test
    public void PersonaRepository_PersonaDelete_ReturnPersonaIsEmpty() {
        int id_tipo_documento=tipodocumento.getId_tipo_documento();      
        String idubigeo1=ubigeo1.getIdubigeo();        
        Persona persona = Persona.builder()
                .apellido_paterno("Chirinos")
                .apellido_materno("Soto")
                .nombres("Patricia")
                .fecha_nacimiento(new Date(1992-04-05))
                .id_tipo_documento(id_tipo_documento)
                .ndocumento("998887766")
                .direccion("Av. Guardia Chalaca 526")
                .idubigeo(idubigeo1).build();   

        personaRepository.save(persona);

        personaRepository.deleteById(persona.getId_persona());
        Optional<Persona> personaReturn = personaRepository.findById(persona.getId_persona());

        Assertions.assertThat(personaReturn).isEmpty();
    }

}
