package ms.tienda.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inventario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Double id;
    @Column(name = "producto_id")
    @NotNull
    private Double productoId;
    @Column(name = "stock")
    @NotNull
    private Integer stock;
    @Column(name = "is_active")
    private Boolean isActive;
}

