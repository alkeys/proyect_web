package modulos;

/**
 *
 * @author Carito Flores
 */
public class Usuarios {

    private int id;
    private String descripcion,nombre,apellido,password,celular,direccion,createdBy,updatedBy,createdAt,updatedAt,correo;
    
 public Usuarios(int id,String descripcion,String password, String nombre,String apellido,String celular,String direccion, String createdBy,String updatedBy,String createdAt,String updatedAt,String correo){
     this.id=id;
     this.descripcion=descripcion;
     this.nombre=nombre;
     this.apellido=apellido;
     this.celular=celular;
     this.direccion=direccion;
     this.createdBy=createdBy;
     this.updatedBy=updatedBy;
     this.createdAt=createdAt;
     this.updatedAt=updatedAt;
     this.password=password;
     this.correo=correo;
     
     
 }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
 
 

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
 