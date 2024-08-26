package ms.tienda.entity;

<<<<<<< HEAD
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
=======
import jakarta.persistence.*;
>>>>>>> 3cc2d4a95c00c2da8af68465b8b3847d44cb7ad4
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
=======
import java.time.LocalDateTime;

>>>>>>> 3cc2d4a95c00c2da8af68465b8b3847d44cb7ad4
@Entity
@Table(name = "productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Productos {
<<<<<<< HEAD

    @Id
@Column(name="id")
    private Double id;
 @Column(name = "nombre_Producto")
    private String nombre_Producto;
 @Column(name = "descripcion_Producto")
    private String descripcion_Producto;
=======
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

@Column(name="id")
    private Double id;
 @Column(name = "nombre_producto")
    private String name;
 @Column(name = "descripcion_producto")
    private String descripcionProducto;
>>>>>>> 3cc2d4a95c00c2da8af68465b8b3847d44cb7ad4
 @Column(name = "precio")
    private Double precio;
 @Column(name = "categoria")
    private String categoria;
 @Column(name = "stock")
    private Double stock;
<<<<<<< HEAD
 @Column(name = "proveedor_id")
    private Integer proveedor_id;
    @Column(name = "is_Active")
    private Boolean is_Active;
=======

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "proveedor_id")
    private Proveedores proveedorId;

    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "creacion_fecha")
    private LocalDateTime fechaCreacion;
    @Column(name = "modificacion_fecha")
    private LocalDateTime modificacionFecha;
>>>>>>> 3cc2d4a95c00c2da8af68465b8b3847d44cb7ad4





}
