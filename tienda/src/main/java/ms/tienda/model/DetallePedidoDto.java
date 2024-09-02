package ms.tienda.model;

import lombok.*;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class DetallePedidoDto {

    private Double pedido;//Pedido
    private LocalDateTime fechaPedido; //Pedidos
    private Double totalPedido; //Pedidos
    private Double documento; // de DetallesPedido
    private Double codigo;//Producctos
    private String name; //Productos
    private String descripcionProducto;//Productos
    private LocalDateTime fechaCreacion;//DetallesPedido
    private Double precio;//Prodcutos



}
