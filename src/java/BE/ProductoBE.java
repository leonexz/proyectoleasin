package BE;
public class ProductoBE {
    private String id_pro,nom_pro,foto,sku;
    private Float valor_referencial;
    private String color;
    private Integer id_modelo,id_marca,id_procesador,id_sistema_operativo,id_memoria_ram;

    public ProductoBE() {
    }

    public ProductoBE(String id_pro, String nom_pro, String foto, String sku, Float valor_referencial, String color, Integer id_modelo, Integer id_marca, Integer id_procesador, Integer id_sistema_operativo, Integer id_memoria_ram) {
        this.id_pro = id_pro;
        this.nom_pro = nom_pro;
        this.foto = foto;
        this.sku = sku;
        this.valor_referencial = valor_referencial;
        this.color = color;
        this.id_modelo = id_modelo;
        this.id_marca = id_marca;
        this.id_procesador = id_procesador;
        this.id_sistema_operativo = id_sistema_operativo;
        this.id_memoria_ram = id_memoria_ram;
    }

    public String getId_pro() {
        return id_pro;
    }

    public void setId_pro(String id_pro) {
        this.id_pro = id_pro;
    }

    public String getNom_pro() {
        return nom_pro;
    }

    public void setNom_pro(String nom_pro) {
        this.nom_pro = nom_pro;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Float getValor_referencial() {
        return valor_referencial;
    }

    public void setValor_referencial(Float valor_referencial) {
        this.valor_referencial = valor_referencial;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getId_modelo() {
        return id_modelo;
    }

    public void setId_modelo(Integer id_modelo) {
        this.id_modelo = id_modelo;
    }

    public Integer getId_marca() {
        return id_marca;
    }

    public void setId_marca(Integer id_marca) {
        this.id_marca = id_marca;
    }

    public Integer getId_procesador() {
        return id_procesador;
    }

    public void setId_procesador(Integer id_procesador) {
        this.id_procesador = id_procesador;
    }

    public Integer getId_sistema_operativo() {
        return id_sistema_operativo;
    }

    public void setId_sistema_operativo(Integer id_sistema_operativo) {
        this.id_sistema_operativo = id_sistema_operativo;
    }

    public Integer getId_memoria_ram() {
        return id_memoria_ram;
    }

    public void setId_memoria_ram(Integer id_memoria_ram) {
        this.id_memoria_ram = id_memoria_ram;
    }
        
}
