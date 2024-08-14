package ms.tienda.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "inventario")
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Double id;
    @Column(name = "producto_id")
    private Double productoId;
    @Column(name = "stock")
    private Integer stock;

    public Inventario() {
    }

    public Inventario(Double id, Double productoId, Integer stock) {
        this.id = id;
        this.productoId = productoId;
        this.stock = stock;
    }

    public Double getId() {
        return this.id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public Double getProductoId() {
        return this.productoId;
    }

    public void setProductoId(Double productoId) {
        this.productoId = productoId;
    }

    public Integer getStock() {
        return this.stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
