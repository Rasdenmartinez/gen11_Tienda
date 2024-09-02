package ms.tienda.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "detalles_pedido")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data

public class DetallesPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Double id;
    @Column(name = "precio_unitario")
    private Double precioUnitario;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "creacion_fecha")
    private LocalDateTime fechaCreacion;
    @Column(name = "modificacion_fecha")
    private LocalDateTime modificacionFecha;

   //Join con Pedidos
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_id")
    private Pedidos pedido;

    //Join con Producto
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "producto_id")
    private Productos producto;





}
