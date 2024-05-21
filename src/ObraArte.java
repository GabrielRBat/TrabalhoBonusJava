public class ObraArte
{
    private int anoCriacao;
    private String tituloObra;
    private String NomeArtista;
    private String tipoObra;
    private String localizacao;

    public ObraArte(int anoCriacao, String tituloObra, String nomeArtista, String tipoObra, String localizacao) {
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
    
}