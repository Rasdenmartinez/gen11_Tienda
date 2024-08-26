package ms.tienda.entity;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idPedido;
    @Column(name = "fecha_pedido")
    private LocalDateTime fechaPedido;
    @Column(name = "total_pedido")
    private Double totalPedido;
    //Join Clientes
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_Id")
    private Clientes clientesId;

    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "creacion_fecha")
    private LocalDateTime fechaCreacion;
    @Column(name = "modificacion_fecha")
    private LocalDateTime modificacionFecha;



}
