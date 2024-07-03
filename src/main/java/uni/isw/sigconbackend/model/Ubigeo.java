package uni.isw.sigconbackend.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Builder;

@Data
@Entity
@Builder
@Table(name="ubigeo")
public class Ubigeo {
    @Id
    private String idubigeo;
    private String departamento;
    private String provincia;
    private String distrito;        

    public Ubigeo() {
    }   

    public Ubigeo(String idubigeo, String departamento, String provincia, String distrito) {
        this.idubigeo = idubigeo;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
    }   
    
    
}
