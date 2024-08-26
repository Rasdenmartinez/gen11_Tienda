package ms.tienda.entity;

<<<<<<< HEAD
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
=======
import jakarta.persistence.*;
>>>>>>> 3cc2d4a95c00c2da8af68465b8b3847d44cb7ad4
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
@Entity
@Table(name = "detalles_Pedido")
=======
import java.time.LocalDateTime;

@Entity
@Table(name = "detalles_pedido")
>>>>>>> 3cc2d4a95c00c2da8af68465b8b3847d44cb7ad4
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetallesPedido {
    @Id
<<<<<<< HEAD
=======
    @GeneratedValue(strategy = GenerationType.IDENTITY)
>>>>>>> 3cc2d4a95c00c2da8af68465b8b3847d44cb7ad4
    @Column(name = "id")
    private Double id;
    @Column(name = "cantidad")
    private Double cantidad;
<<<<<<< HEAD
    @Column(name = "precio_Unitario")
    private Double precio_Unitario;
    @Column(name = "pedido_Id")
    private Double pedido_Id;
    @Column(name = "producto_Id")
    private Double producto_Id;
    @Column(name = "is_Active")
    private Boolean is_Active;
=======
    @Column(name = "precio_unitario")
    private Double precioUnitario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_id")
    private Pedidos pedidoId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "producto_id")
    private Productos productoId;

    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "creacion_fecha")
    private LocalDateTime fechaCreacion;
    @Column(name = "modificacion_fecha")
    private LocalDateTime modificacionFecha;
>>>>>>> 3cc2d4a95c00c2da8af68465b8b3847d44cb7ad4
}
