package ms.tienda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ms.tienda.entity.Productos;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseInventario {
    private Double id;
    private Double productoId;
    private String nombreProducto;
    private String categoria;
    private Integer stock;
}
