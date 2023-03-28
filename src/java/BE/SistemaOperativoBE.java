package BE;
public class SistemaOperativoBE {
    private Integer id_sistema_operativo;
    private String tipo_sistema_operativo;

    public SistemaOperativoBE() {
    }

    public SistemaOperativoBE(Integer id_sistema_operativo, String tipo_sistema_operativo) {
        this.id_sistema_operativo = id_sistema_operativo;
        this.tipo_sistema_operativo = tipo_sistema_operativo;
    }

    public Integer getId_sistema_operativo() {
        return id_sistema_operativo;
    }

    public void setId_sistema_operativo(Integer id_sistema_operativo) {
        this.id_sistema_operativo = id_sistema_operativo;
    }

    public String getTipo_sistema_operativo() {
        return tipo_sistema_operativo;
    }

    public void setTipo_sistema_operativo(String tipo_sistema_operativo) {
        this.tipo_sistema_operativo = tipo_sistema_operativo;
    }

    
}
