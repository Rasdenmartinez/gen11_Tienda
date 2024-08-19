package ms.tienda.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "detalles_Pedido")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetallesPedido {
    @Id
    @Column(name = "id")
    private Double id;
    @Column(name = "cantidad")
    private Double cantidad;
    @Column(name = "precio_Unitario")
    private Double precio_Unitario;
    @Column(name = "pedido_Id")
    private Double pedido_Id;
    @Column(name = "producto_Id")
    private Double producto_Id;
    @Column(name = "is_Active")
    private Boolean is_Active;
}
