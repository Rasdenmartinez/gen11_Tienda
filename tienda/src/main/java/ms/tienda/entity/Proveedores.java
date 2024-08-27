package ms.tienda.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
    @NotNull
    private String nombreEmpresa;
    @Column(name = "contacto")
    @NotNull
    private String contacto;
    @Column(name="correo")
    @NotNull
    @Email
    private String correo;
    @Column(name = "telefono")
    @NotNull
    @Pattern(regexp = "^\\d{10}$")
    private String telefono;
    @Column(name = "is_active")
    private Boolean isActive;

}
