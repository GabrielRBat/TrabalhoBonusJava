package Models;
public class Fotografia extends ObraArte
{
    private String descricaoFotografia;
    
    public Fotografia(String tituloObra, String nomeArtista, String tipoObra, int anoCriacao, String localizacao, String descricaoFotografia) 
    {
        super(tituloObra, nomeArtista, tipoObra, anoCriacao, localizacao);
        this.descricaoFotografia = descricaoFotografia;
    }

    public String getDescricaoFotografia() {
        return descricaoFotografia;
    }

    public void setDescricaoFotografia(String descricaoFotografia) {
        this.descricaoFotografia = descricaoFotografia;
    }

    @Override
    public String toString() {
        
        return super.toString() + "DESCRIÇÃO: " + descricaoFotografia;
    }
}
