package ms.tienda.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name ="empleados")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleados {
	
	   @Id 
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Long id;
	   
	   @Column(name ="nombre")
	   private String nombre;
	   
	   @Column(name ="apellido")
	   private String apellido;
	   
	   @Column(name ="puesto")
	   private String puesto;
	   
	   @Column(name ="salario")
	   private Double salario;
	   
	   @Column(name ="fecha_contratacion")
	   private LocalDateTime fechaContratacion;
	   
	   @Column(name ="is_active")
	   private Boolean isActive;
	   
	   @Column(name = "create_date")
	    private LocalDateTime createDate;

	    @Column(name = "update_date")
	    private LocalDateTime updateDate;
	    
	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "proveedor_id")
	    private Proveedores idProveedor;
	    
}
