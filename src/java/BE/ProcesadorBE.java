package BE;
public class ProcesadorBE {
    private Integer id_procesador;
    private String tipo_procesador;

    public ProcesadorBE() {
    }

    public ProcesadorBE(Integer id_procesador, String tipo_procesador) {
        this.id_procesador = id_procesador;
        this.tipo_procesador = tipo_procesador;
    }

    public Integer getId_procesador() {
        return id_procesador;
    }

    public void setId_procesador(Integer id_procesador) {
        this.id_procesador = id_procesador;
    }

    public String getTipo_procesador() {
        return tipo_procesador;
    }

    public void setTipo_procesador(String tipo_procesador) {
        this.tipo_procesador = tipo_procesador;
    }
    
}
