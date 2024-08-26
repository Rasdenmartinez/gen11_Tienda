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

import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedidos {
    @Id
<<<<<<< HEAD
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
=======
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Double id;
    @Column(name = "fecha_pedido")
    private LocalDateTime fechaPedido;
    @Column(name = "total_pedido")
    private Double totalPedido;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clientes_Id")
  //  private Clientes clientesId;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "creacion_fecha")
    private LocalDateTime fechaCreacion;
    @Column(name = "modificacion_fecha")
    private LocalDateTime modificacionFecha;
>>>>>>> 3cc2d4a95c00c2da8af68465b8b3847d44cb7ad4



}
