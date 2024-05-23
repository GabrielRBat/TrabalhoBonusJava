package Models;
public class Pintura extends ObraArte
{
   
    private String tecnicaPintura;
    private String estiloPintura;
    
    public Pintura(String tituloObra, String nomeArtista, String tipoObra, int anoCriacao, String localizacao, String tecnicaPintura, String estiloPintura) 
    {
        super(tituloObra, nomeArtista, tipoObra, anoCriacao, localizacao);
        this.estiloPintura = estiloPintura;
        this.tecnicaPintura = tecnicaPintura;
    }

    public String getTecnicaPintura() {
        return tecnicaPintura;
    }

    public void setTecnicaPintura(String tecnicaPintura) {
        this.tecnicaPintura = tecnicaPintura;
    }

    public String getEstiloPintura() {
        return estiloPintura;
    }

    public void setEstiloPintura(String estiloPintura) {
        this.estiloPintura = estiloPintura;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + "ESTILO ARTÍSTICO: " + estiloPintura + ", " + "TÉCNICA DE PINTURA: " + tecnicaPintura;
    }
}
