package BE;
public class EmpresaBE {
    private String id_empresa,razonSocial,ruc;

    public EmpresaBE() {
    }

    public EmpresaBE(String id_empresa, String razonSocial, String ruc) {
        this.id_empresa = id_empresa;
        this.razonSocial = razonSocial;
        this.ruc = ruc;
    }

    public String getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(String id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    
}
