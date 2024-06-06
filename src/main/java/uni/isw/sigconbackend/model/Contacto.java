package uni.isw.sigconbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="contact")
public class Contacto {  
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;    
    private String fullname;
    private String email;
    private String phone;

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Contacto{" + "id=" + id + ", fullname=" + fullname + ", email=" + email + ", phone=" + phone + '}';
    }
    
}
