package uni.isw.sigconbackend.model;
import jakarta.persistence.*;
import java.sql.Date;
import lombok.Data;

@Data
@Entity
@Table(name="persona")
public class Persona {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id_persona;    
    private String apellido_paterno;
    private String apellido_materno;
    private String nombres;    
    private Date fecha_nacimiento;
    private Long id_tipo_documento;
    private String ndocumento;
    private String direccion;
    private String idubigeo;
    
    @ManyToOne
    @JoinColumn(name = "id_tipo_documento", referencedColumnName = "id_tipo_documento",insertable=false, updatable=false )    
    private TipoDocumento tipo_documento;
    
    @ManyToOne
    @JoinColumn(name = "idubigeo", referencedColumnName = "idubigeo",insertable=false, updatable=false)    
    private Ubigeo ubigeo;    
}
