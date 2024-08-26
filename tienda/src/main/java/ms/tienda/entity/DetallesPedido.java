package ms.tienda.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "detalles_pedido")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetallesPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "cantidad")
    private Double cantidad;
    @Column(name = "precio_unitario")
    private Double precioUnitario;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "creacion_fecha")
    private LocalDateTime fechaCreacion;
    @Column(name = "modificacion_fecha")
    private LocalDateTime modificacionFecha;

   //Join con Pedidos
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_id")
    private Pedidos idPedido;

    //Join con Producto
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "producto_id")
    private Productos producto;





}
