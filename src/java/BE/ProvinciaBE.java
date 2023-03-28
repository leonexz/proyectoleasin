package BE;
public class ProvinciaBE {
    private Integer id_provincia;
    private String nom_provincia;
    private Integer id_region;

    public ProvinciaBE() {
    }

    public ProvinciaBE(Integer id_provincia, String nom_provincia, Integer id_region) {
        this.id_provincia = id_provincia;
        this.nom_provincia = nom_provincia;
        this.id_region = id_region;
    }

    public Integer getId_provincia() {
        return id_provincia;
    }

    public void setId_provincia(Integer id_provincia) {
        this.id_provincia = id_provincia;
    }

    public String getNom_provincia() {
        return nom_provincia;
    }

    public void setNom_provincia(String nom_provincia) {
        this.nom_provincia = nom_provincia;
    }

    public Integer getId_region() {
        return id_region;
    }

    public void setId_region(Integer id_region) {
        this.id_region = id_region;
    }
    
}
