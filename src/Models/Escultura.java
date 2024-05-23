package Models;
public class Escultura extends ObraArte
{

    private String material;

    public Escultura(String tituloObra, String nomeArtista, String tipoObra, int anoCriacao, String localizacao, String material) 
    {
        super(tituloObra, nomeArtista, tipoObra, anoCriacao, localizacao);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        
        return super.toString() + "MATERIAL: " + material;
    }
    
}
