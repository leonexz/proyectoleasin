package BE;
public class RolBE {
    private Integer id_rol;
    private String nom_rol;

    public RolBE() {
    }

    public RolBE(Integer id_rol, String nom_rol) {
        this.id_rol = id_rol;
        this.nom_rol = nom_rol;
    }

    public Integer getId_rol() {
        return id_rol;
    }

    public void setId_rol(Integer id_rol) {
        this.id_rol = id_rol;
    }

    public String getNom_rol() {
        return nom_rol;
    }

    public void setNom_rol(String nom_rol) {
        this.nom_rol = nom_rol;
    }
    
}
