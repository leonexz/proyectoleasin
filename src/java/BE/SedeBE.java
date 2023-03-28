package BE;
public class SedeBE {
    private Integer id_Sede;
    private String direccion;
    private Integer id_distrito;
    private String id_empresa;

    public SedeBE() {
    }

    public SedeBE(Integer id_Sede, String direccion, Integer id_distrito, String id_empresa) {
        this.id_Sede = id_Sede;
        this.direccion = direccion;
        this.id_distrito = id_distrito;
        this.id_empresa = id_empresa;
    }

    public Integer getId_Sede() {
        return id_Sede;
    }

    public void setId_Sede(Integer id_Sede) {
        this.id_Sede = id_Sede;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getId_distrito() {
        return id_distrito;
    }

    public void setId_distrito(Integer id_distrito) {
        this.id_distrito = id_distrito;
    }

    public String getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(String id_empresa) {
        this.id_empresa = id_empresa;
    }
    
}
