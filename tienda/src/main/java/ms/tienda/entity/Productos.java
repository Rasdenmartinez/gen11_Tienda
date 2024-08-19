package ms.tienda.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Productos {

    @Id
@Column(name="id")
    private Double id;
 @Column(name = "nombre_Producto")
    private String nombre_Producto;
 @Column(name = "descripcion_Producto")
    private String descripcion_Producto;
 @Column(name = "precio")
    private Double precio;
 @Column(name = "categoria")
    private String categoria;
 @Column(name = "stock")
    private Double stock;
 @Column(name = "proveedor_id")
    private Integer proveedor_id;
    @Column(name = "is_Active")
    private Boolean is_Active;





}
