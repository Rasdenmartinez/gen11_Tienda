package ms.tienda.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

@Column(name="id")
    private Integer id;
 @Column(name = "nombre_producto")
    private String name;
 @Column(name = "descripcion_producto")
    private String descripcionProducto;
 @Column(name = "precio")
    private Double precio;
 @Column(name = "categoria")
    private String categoria;
 @Column(name = "stock")
    private Double stock;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "proveedor_id")
    private Proveedores proveedorId;

    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "creacion_fecha")
    private LocalDateTime fechaCreacion;
    @Column(name = "modificacion_fecha")
    private LocalDateTime modificacionFecha;





}
