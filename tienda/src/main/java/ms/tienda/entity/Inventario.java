package ms.tienda.entity;

import jakarta.persistence.*;
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
    private Double productoId;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "is_active")
    private Boolean isActive;
}

