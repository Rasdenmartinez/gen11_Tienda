package ms.tienda.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedidos {
    @Id
    @Column(name = "id")
    private Double id;
    @Column(name = "fecha_Pedido")
    private LocalDateTime fecha_Pedido;
    @Column(name = "total_Pedido")
    private Double total_Pedido;
    @Column(name = "clientes_Id")
    private Integer clientes_Id;
    @Column(name = "is_Active")
    private Boolean is_Active;



}
