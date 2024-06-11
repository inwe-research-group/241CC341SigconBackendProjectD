package uni.isw.sigconbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="servicio")
public class Servicio {   
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id_servicio;
    private String descripcion;
    private double precio;
    
}
