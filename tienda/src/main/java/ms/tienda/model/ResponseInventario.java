package ms.tienda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseInventario {
    private Double id;
    private Double productoId;
    private Integer stock;
}
