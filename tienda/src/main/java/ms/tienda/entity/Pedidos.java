package ms.tienda.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data

public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Double idPedido;
    @Column(name = "fecha_pedido")
    private LocalDateTime fechaPedido;
    @Column(name = "cantidad")
    Double cantidad;
    @Column(name = "total_pedido")
    private Double totalPedido;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "modificacion_fecha")
    private LocalDateTime modificacionFecha;


    //Join Clientes
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_Id")
    private Clientes cliente;




}
