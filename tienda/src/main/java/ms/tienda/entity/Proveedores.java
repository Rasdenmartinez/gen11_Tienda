package ms.tienda.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proveedores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Proveedores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Double id;
    @Column(name="nombre_empresa")
    private String nombreEmpresa;
    @Column(name = "contacto")
    private String contacto;
    @Column(name="correo")
    private String correo;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "is_active")
    private Boolean isActive;


}
