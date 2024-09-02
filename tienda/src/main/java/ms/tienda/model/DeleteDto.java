package ms.tienda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteDto {

    private String mensajeProducto = "/n El 'Id' del producto se ah eliminado correctamente! ";
    private  String mensajePedido = "/n El 'Id' del pedido se ah eliminado correctamente! ";
    private  String mensajeDetalle = "/n El 'Id' del detalle se ah eliminado correctamente! ";
}
