package ms.tienda.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="clientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clientes {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    @Column(name = "telefono")
    private Long telefono;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empleado_id")
    private Empleados idEmpleado;
    
    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

	
}
