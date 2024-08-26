package ms.tienda.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductosDto {

    private Integer id;
    private String name;
    private String descripcionProducto;
    private Double precio;
    private String categoria;
    private Double stock;
}
