package BE;
public class MemoriaRamBE {
    private Integer id_memoria_ram;
    private String tipo_memoria_ram;

    public MemoriaRamBE() {
    }

    public MemoriaRamBE(Integer id_memoria_ram, String tipo_memoria_ram) {
        this.id_memoria_ram = id_memoria_ram;
        this.tipo_memoria_ram = tipo_memoria_ram;
    }

    public Integer getId_memoria_ram() {
        return id_memoria_ram;
    }

    public void setId_memoria_ram(Integer id_memoria_ram) {
        this.id_memoria_ram = id_memoria_ram;
    }

    public String getTipo_memoria_ram() {
        return tipo_memoria_ram;
    }

    public void setTipo_memoria_ram(String tipo_memoria_ram) {
        this.tipo_memoria_ram = tipo_memoria_ram;
    }
    
}
