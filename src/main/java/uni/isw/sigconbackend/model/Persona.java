package uni.isw.sigconbackend.model;
import jakarta.persistence.*;
import java.sql.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@Table(name="persona")
public class Persona {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id_persona;    
    private String apellido_paterno;
    private String apellido_materno;
    private String nombres;    
    private Date fecha_nacimiento;
    private int id_tipo_documento;
    private String ndocumento;
    private String direccion;
    private String idubigeo;
    
    @ManyToOne
    @JoinColumn(name = "id_tipo_documento", referencedColumnName = "id_tipo_documento",insertable=false, updatable=false )    
    private TipoDocumento tipo_documento;
    
    @ManyToOne
    @JoinColumn(name = "idubigeo", referencedColumnName = "idubigeo",insertable=false, updatable=false)    
    private Ubigeo ubigeo;   

    public Persona() {
    }

    public Persona(Long id_persona, String apellido_paterno, String apellido_materno, String nombres, Date fecha_nacimiento, int id_tipo_documento, String ndocumento, String direccion, String idubigeo, TipoDocumento tipo_documento, Ubigeo ubigeo) {
    this.id_persona = id_persona;
    this.apellido_paterno = apellido_paterno;
    this.apellido_materno = apellido_materno;
    this.nombres = nombres;
    this.fecha_nacimiento = fecha_nacimiento;
    this.id_tipo_documento = id_tipo_documento;
    this.ndocumento = ndocumento;
    this.direccion = direccion;
    this.idubigeo = idubigeo;
    this.tipo_documento = tipo_documento;
    this.ubigeo = ubigeo;
    }
    
    
}
