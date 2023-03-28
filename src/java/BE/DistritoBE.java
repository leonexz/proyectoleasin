package BE;
public class DistritoBE {
    private Integer id_distrito;
    private String nom_distrito;
    private Integer id_provincia;

    public DistritoBE() {
    }

    public DistritoBE(Integer id_distrito, String nom_distrito, Integer id_provincia) {
        this.id_distrito = id_distrito;
        this.nom_distrito = nom_distrito;
        this.id_provincia = id_provincia;
    }

    public Integer getId_distrito() {
        return id_distrito;
    }

    public void setId_distrito(Integer id_distrito) {
        this.id_distrito = id_distrito;
    }

    public String getNom_distrito() {
        return nom_distrito;
    }

    public void setNom_distrito(String nom_distrito) {
        this.nom_distrito = nom_distrito;
    }

    public Integer getId_provincia() {
        return id_provincia;
    }

    public void setId_provincia(Integer id_provincia) {
        this.id_provincia = id_provincia;
    }
    
}
