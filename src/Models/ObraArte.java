package Models;
public class ObraArte
{   
    private String tituloObra;
    private String NomeArtista;
    private String tipoObra;
    private int anoCriacao;
    private String localizacao;

    public ObraArte(String tituloObra, String nomeArtista, String tipoObra, int anoCriacao,  String localizacao) 
    {
        this.anoCriacao = anoCriacao;
        this.tituloObra = tituloObra;
        NomeArtista = nomeArtista;
        this.tipoObra = tipoObra;
        this.localizacao = localizacao;
    }

    public int getAnoCriacao() {
        return anoCriacao;
    }

    public String getTituloObra() {
        return tituloObra;
    }

    public String getNomeArtista() {
        return NomeArtista;
    }

    public String getTipoObra() {
        return tipoObra;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    
    public void setTituloObra(String tituloObra) {
        this.tituloObra = tituloObra;
    }

    public void setNomeArtista(String nomeArtista) {
        NomeArtista = nomeArtista;
    }

    public void setTipoObra(String tipoObra) {
        this.tipoObra = tipoObra;
    }

    public void setAnoCriacao(int anoCriacao) {
        this.anoCriacao = anoCriacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        
        return "TÍTULO: " + tituloObra + ", " + "ARTISTA: " + NomeArtista + ", " 
        + "TIPO DA OBRA: " + tipoObra + ", " + "ANO: " + anoCriacao + ", " + "LOCALIZAÇÃO: " + localizacao + ", ";
    }

    public static ObraArte fromString(String linha)
    {
        String[] informacoesObra = linha.split(", ");

        return new ObraArte(informacoesObra[0], informacoesObra[1] , informacoesObra[2], Integer.parseInt(informacoesObra[3]), informacoesObra[4]);
    }
    
}