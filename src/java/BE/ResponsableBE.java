package BE;
public class ResponsableBE {
    private Integer id_responsable;
    private String nombre,apellido,dni,id_empresa;

    public ResponsableBE() {
    }

    public ResponsableBE(Integer id_responsable, String nombre, String apellido, String dni, String id_empresa) {
        this.id_responsable = id_responsable;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.id_empresa = id_empresa;
    }

    public Integer getId_responsable() {
        return id_responsable;
    }

    public void setId_responsable(Integer id_responsable) {
        this.id_responsable = id_responsable;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(String id_empresa) {
        this.id_empresa = id_empresa;
    }

    
    
}
