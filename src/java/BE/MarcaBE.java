package BE;
public class MarcaBE {
    private Integer id_marca;
    private String tipo_marca;

    public MarcaBE() {
    }

    public MarcaBE(Integer id_marca, String tipo_marca) {
        this.id_marca = id_marca;
        this.tipo_marca = tipo_marca;
    }

    public Integer getId_marca() {
        return id_marca;
    }

    public void setId_marca(Integer id_marca) {
        this.id_marca = id_marca;
    }

    public String getTipo_marca() {
        return tipo_marca;
    }

    public void setTipo_marca(String tipo_marca) {
        this.tipo_marca = tipo_marca;
    }
    
}
