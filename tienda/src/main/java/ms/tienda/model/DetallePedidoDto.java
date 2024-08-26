package ms.tienda.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data

public class DetallePedidoDto {

    private Double id;
    private String name;
    private String descripcionProducto;
    private Double precio;
    private LocalDateTime fechaPedido;
    private Double totalPedido;
    //  private Clientes clientesId;

}
