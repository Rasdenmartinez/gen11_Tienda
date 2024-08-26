package ms.tienda.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidosDto {
    private Integer idPedido;
    private LocalDateTime fechaPedido;
    private Double totalPedido;
    private Long clientesId;
    private Long id;
    private String nombre;
    private String apellido;

}
