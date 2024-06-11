package uni.isw.sigconbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="predio")
public class Predio {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long id_predio;
   private String descripcion;
   private String ruc;
   private String telefono;
   private String correo;
   private String direccion;
   private String idubigeo;
   private Integer total_mdu;
   
    @ManyToOne
    @JoinColumn(name = "idubigeo", referencedColumnName = "idubigeo",insertable=false, updatable=false)    
    private Ubigeo ubigeo;   
}
