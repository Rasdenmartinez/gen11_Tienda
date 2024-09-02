package ms.tienda.model;

import jakarta.persistence.Column;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductosDto {

    private Double codigo;
    private String producto;
    private String descripcionProducto;
    private Double precio;
    private String categoria;
    private Double stock;
}
