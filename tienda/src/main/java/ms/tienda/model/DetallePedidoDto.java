package ms.tienda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class DetallePedidoDto {

    private Integer pedido;//Pedido
    private LocalDateTime fechaPedido; //Pedidos
    private Double totalPedido; //Pedidos
    private Integer id; // de DetallesPedido
    private Double cantidad;//DetallesPedido
    private Integer producto;//Producctos
    private String name; //Productos
    private String descripcionProducto;//Productos
    private LocalDateTime fechaCreacion;//DetallesPedido
    private Double precio;//Prodcutos



}
