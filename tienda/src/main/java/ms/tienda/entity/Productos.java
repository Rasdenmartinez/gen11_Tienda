package ms.tienda.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "productos")
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Double id;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "stock")
    private Double stock;

    @Column(name = "creacion_fecha")
    private Date creacionFecha;

    @Column(name = "modificacion_fecha")
    private Date modificacionFecha;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "proveedor_id")
    private Double proveedorId;
}
