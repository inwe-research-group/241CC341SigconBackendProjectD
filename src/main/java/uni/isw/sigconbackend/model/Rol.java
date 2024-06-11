package uni.isw.sigconbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="rol")
public class Rol {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id_rol;
    private String descripcion;
}
