package uni.isw.sigconbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Date;
import lombok.Data;
@Data
@Entity
@Table(name="solicitud")
public class Solicitud {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id_solicitud;
    private Long id_predio;
    private Long id_solicitante;
    private Integer id_servicio;
    private double area_predio;
    private Integer num_casas;
    private Integer cant_acomunes;
    private Integer area_acomunes;
    private Integer cant_vigilantes;
    private Integer cant_plimpieza;
    private Integer cant_administracion;
    private Integer cant_jardineria;
    private Date fecha_solicitud;
    @ManyToOne
    @JoinColumn(name = "id_predio", referencedColumnName = "id_predio",insertable=false, updatable=false )    
    private Predio predio;
    
    @ManyToOne
    @JoinColumn(name = "id_solicitante", referencedColumnName = "id_solicitante",insertable=false, updatable=false )    
    private Solicitante solicitante;
    
    @ManyToOne
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio",insertable=false, updatable=false )    
    private Servicio servicio;
    
}
