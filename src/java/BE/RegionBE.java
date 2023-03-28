package BE;
public class RegionBE {
    private Integer id_region;
    private String nom_region;

    public RegionBE() {
    }

    public RegionBE(Integer id_region, String nom_region) {
        this.id_region = id_region;
        this.nom_region = nom_region;
    }
    
    public Integer getId_region() {
        return id_region;
    }

    public void setId_region(Integer id_region) {
        this.id_region = id_region;
    }

    public String getNom_region() {
        return nom_region;
    }

    public void setNom_region(String nom_region) {
        this.nom_region = nom_region;
    }
    
}
