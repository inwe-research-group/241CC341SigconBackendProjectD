package uni.isw.sigconbackend.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="tipo_documento")
public class TipoDocumento {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id_tipo_documento;    
    private String descripcion;    
}
