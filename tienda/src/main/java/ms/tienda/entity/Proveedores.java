package ms.tienda.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "proveedores")
public class Proveedores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="nombre_empresa")
    private String nombreEmpresa;
    @Column(name = "contacto")
    private String contacto;
    @Column(name="correo")
    private String correo;
    @Column(name = "telefono")
    private String telefono;

    public Proveedores() {
    }

    public Proveedores(Long id, String nombreEmpresa, String contacto, String correo, String telefono) {
        this.id = id;
        this.nombreEmpresa = nombreEmpresa;
        this.contacto = contacto;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreEmpresa() {
        return this.nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getContacto() {
        return this.contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
