package uni.isw.sigconbackend.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="ubigeo")
public class Ubigeo {
    @Id
    private String idubigeo;
    private String departamento;
    private String provincia;
    private String distrito;        
}
