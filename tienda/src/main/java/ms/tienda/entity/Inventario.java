package ms.tienda.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "inventario")
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "producto_id")
    private Long productoId;
    @Column(name = "stock")
    private Double stock;

    public Inventario() {
    }

    public Inventario(Long id, Long productoId, Double stock) {
        this.id = id;
        this.productoId = productoId;
        this.stock = stock;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductoId() {
        return this.productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Double getStock() {
        return this.stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }
}
