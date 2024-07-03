package uni.isw.sigconbackend.model;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@Table(name="tipo_documento")
public class TipoDocumento {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id_tipo_documento;    
    private String descripcion;   

    public TipoDocumento() {
    }
    
    public TipoDocumento(int id_tipo_documento, String descripcion) {
        this.id_tipo_documento = id_tipo_documento;
        this.descripcion = descripcion;
    }
    
    
}
