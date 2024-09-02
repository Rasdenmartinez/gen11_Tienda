package ms.tienda.model;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PedidosDto {
    private Double idPedido;
    private LocalDateTime fechaPedido;
    private Double totalPedido;
    private Long clientesId;
    private String nombre;
    private String apellido;

}
