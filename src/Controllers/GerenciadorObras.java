package Controllers;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Models.ObraArte;

public abstract class GerenciadorObras
{
    private static final String FILE = "Obras.txt";


    public static void salvarObraArte(ObraArte obra) throws IOException
    {
        try(FileWriter fw = new FileWriter(FILE, true); BufferedWriter bw = new BufferedWriter(fw))
        {
            bw.write(obra + "\n");
        }     
    }

    public static ArrayList<ObraArte> listarObrasArte() throws IOException, Exception
    {

        ArrayList<ObraArte> listaObras = new ArrayList<>();

        try(FileReader fr = new FileReader(FILE); BufferedReader br = new BufferedReader(fr))
        {
            String linha;
            while((linha = br.readLine()) != null)
            {
                ObraArte obra = ObraArte.fromString(linha);
                listaObras.add(obra);
            }
        }

        if(listaObras.isEmpty())
        {
            throw new Exception("\nNão há obras de arte cadastradas.");
        }

        return listaObras;
    }

    private static ArrayList<ObraArte> apagarObraArteLista(String nomeObra) throws IOException, Exception
    {
        ArrayList<ObraArte> listaObrasArteTemp = listarObrasArte();
        for(ObraArte ObraTemp : listaObrasArteTemp)
        {
            if(ObraTemp.getTituloObra().equals(nomeObra))
            {
                listaObrasArteTemp.remove(ObraTemp);
                return listaObrasArteTemp;            
            }
             
        }

        throw new Exception("\nObraArte não presente na lista ou lista está vazia.");
    }

    public static void apagarObraArte(String nomeObra) throws IOException, Exception
    {
        ArrayList<ObraArte> novaLista = apagarObraArteLista(nomeObra);

        try(FileWriter fw = new FileWriter(FILE); BufferedWriter bw = new BufferedWriter(fw))
        {
            for(ObraArte tempObraArte : novaLista)
            {
                bw.write(tempObraArte + "\n");
            }
        }
    }

    public static ObraArte buscarObraArte(int filtro, String chaveBusca) throws Exception
    {
        ArrayList<ObraArte> listaObrasArte = listarObrasArte();

        switch (filtro) 
        {
            case 1:
                //Efetua a busca com base no título da obra
                ArrayList<ObraArte> obrasEncontradas = new ArrayList<>();
                for (ObraArte tempObraArte : listaObrasArte)
                {
                    if(tempObraArte.getTituloObra().equals(chaveBusca))
                    {
                        obrasEncontradas.add(tempObraArte);
                        return tempObraArte;
                    }
                }
                break;

            case 2:
                //Efetua a busca com base no nome do artista
                for (ObraArte tempObraArte : listaObrasArte)
                {
                    if(tempObraArte.getNomeArtista().equals(chaveBusca))
                    {
                        return tempObraArte;
                    }
                }
                break;
                
            case 3:
                //Efetua a busca com base na localização da obra
                for (ObraArte tempObraArte : listaObrasArte)
                {
                    if(tempObraArte.getLocalizacao().equals(chaveBusca))
                    {
                        return tempObraArte;
                    }
                }
                break;    
            case 0:
                break;
            default:
                throw new Exception("\nO número "+filtro+" não corresponde a nenhuma opção.");
                
        }
        throw new Exception("\nNão encontramos nenhuma obra com a chave de busca '" + chaveBusca + "'");
    }

    public static void alterarObraArte(int filtroAlteracao , String nomeObra, String dadoAlterado) throws Exception
    {
        switch (filtroAlteracao) {
            case 1:
                try
                {
                    ObraArte obraEncontrada = buscarObraArte(1, nomeObra);
                    obraEncontrada.setTituloObra(dadoAlterado);
                    System.out.println("Título da obra alterado com sucesso!");

                } catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                try
                {
                    ObraArte obraEncontrada = buscarObraArte(1, nomeObra);
                    obraEncontrada.setNomeArtista(dadoAlterado);
                    System.out.println("Nome do artista alterado com sucesso!");
        
                } catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                try
                {
                    ObraArte obraEncontrada = buscarObraArte(1, nomeObra);
                    obraEncontrada.setLocalizacao(dadoAlterado);
                    System.out.println("Localização da obra alterada com sucesso!");

                } catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
                break;
            case 4:
                try
                {
                    ObraArte obraEncontrada = buscarObraArte(1, nomeObra);
                    obraEncontrada.setAnoCriacao(Integer.parseInt(dadoAlterado));
                    System.out.println("Ano de criação da obra alterado com sucesso!");
                    
                } catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
                break;
            
            case 0:
                break;
            default:
                throw new Exception("\n"+filtroAlteracao+" não é uma opção válida!");
        }
    }
}
