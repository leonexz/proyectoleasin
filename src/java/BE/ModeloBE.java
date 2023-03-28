package BE;
public class ModeloBE {
    private Integer id_modelo;
    private String tipo_modelo;

    public ModeloBE() {
    }

    public ModeloBE(Integer id_modelo, String tipo_modelo) {
        this.id_modelo = id_modelo;
        this.tipo_modelo = tipo_modelo;
    }

    public Integer getId_modelo() {
        return id_modelo;
    }

    public void setId_modelo(Integer id_modelo) {
        this.id_modelo = id_modelo;
    }

    public String getTipo_modelo() {
        return tipo_modelo;
    }

    public void setTipo_modelo(String tipo_modelo) {
        this.tipo_modelo = tipo_modelo;
    }
    
}
