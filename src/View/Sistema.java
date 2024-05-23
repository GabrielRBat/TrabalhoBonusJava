package View;
import java.io.IOException;  
import Controllers.GerenciadorObras;
import Models.Escultura;
import Models.Fotografia;
import Models.ObraArte;
import Models.Pintura;

public class Sistema
{
    private static void exibirMenu()
    {
        System.out.println("\n GERENCIADOR DE OBRAS: ");
        System.out.println("1) Cadastrar escultura");
        System.out.println("2) Cadastrar Pintura");
        System.out.println("3) Cadastrar Fotografia");
        System.out.println("4) Buscar obra");
        System.out.println("5) Listar obras");
        System.out.println("6) Apagar obra");
        System.out.println("7) Alterar obra");
        System.out.println("0) Sair");
        System.out.println("Sua opção: ");

    }

    private static void verificarOpcao(int op)
    {
        switch (op) 
        {
            case 1:
                salvarEscultura();
                break;
            
            case 2:
                salvarPintura();
                break;

            case 3:
                salvarFotografia();
                break;

            case 4:
                buscarObra();
                break;

            case 5:
                listarObras();
                break;

            case 6:
                apagarObra();
                break;

            case 7:
                alterarObra();
                break;

            case 0:
                System.out.println("O programa foi finalizado.");
                break;
            default:
                System.out.println("Opção inválida, digite novamente.");
                break;
        }
    }

    public static void sistema()
    {
        int op;
        do
        {
            exibirMenu();
            op = Console.lerInt();
            verificarOpcao(op);

        }while(op != 0);
    }

    private static void salvarEscultura()
    {//String tituloObra, String nomeArtista, String tipoObra, int anoCriacao, String localizacao, String material
        System.out.println("\nNova escultura: ");
        String tipoObra = "Escultura";

        System.out.println("Digite o título da obra: ");
        String tituloEscultura = Console.lerString();

        System.out.println("Digite o ano de criação da obra: ");
        int anoObra = Console.lerInt();

        System.out.println("Informe a localização da obra: ");
        String localizacao = Console.lerString();

        System.out.println("Informe o material da escultura: ");
        String material = Console.lerString();

        Escultura e1 = new Escultura(tituloEscultura, tituloEscultura, tipoObra, anoObra, localizacao, material);

        try
        {
            GerenciadorObras.salvarObraArte(e1);

        } catch(IOException e)
        {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void salvarPintura()
    {//String tituloObra, String nomeArtista, String tipoObra, int anoCriacao, String localizacao, String material
        System.out.println("\nNova pintura: ");
        String tipoObra = "Escultura";

        System.out.println("Digite o título da obra: ");
        String tituloEscultura = Console.lerString();

        System.out.println("Digite o ano de criação da obra: ");
        int anoObra = Console.lerInt();

        System.out.println("Informe a localização da obra: ");
        String localizacao = Console.lerString();

        System.out.println("Informe a técnica utilizada na pintura: ");
        String tecnicaPintura = Console.lerString();

        System.out.println("Informe o estilo da obra: ");
        String estiloPintura = Console.lerString();

        Pintura p1 = new Pintura(tituloEscultura, tituloEscultura, tipoObra, anoObra, localizacao, tecnicaPintura, estiloPintura);
        try
        {
            GerenciadorObras.salvarObraArte(p1);

        } catch(IOException e)
        {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void salvarFotografia()
    {//String tituloObra, String nomeArtista, String tipoObra, int anoCriacao, String localizacao, String material
        System.out.println("\nNova fotografia: ");
        String tipoObra = "Escultura";

        System.out.println("Digite o título da obra: ");
        String tituloEscultura = Console.lerString();

        System.out.println("Digite o ano de criação da obra: ");
        int anoObra = Console.lerInt();

        System.out.println("Informe a localização da obra: ");
        String localizacao = Console.lerString();

        System.out.println("Informe a descrição da fotografia: ");
        String descricaoFotografia = Console.lerString();

        Fotografia f1 = new Fotografia(tituloEscultura, tituloEscultura, tipoObra, anoObra, localizacao, descricaoFotografia);

        try
        {
            GerenciadorObras.salvarObraArte(f1);

        } catch(IOException e)
        {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void buscarObra()
    {
        System.out.println("Digite um número referente ao filtro de pesquisa desejado: ");
        System.out.println("1) Filtrar por título de obra");
        System.out.println("2) Filtrar por artista");
        System.out.println("3) Filtrar pela localização da obra");
        int filtro = Console.lerInt();

        System.out.println("Qual obra, artista ou localização deseja filtrar?");
        String chaveBusca = Console.lerString();

        try
        {
            ObraArte obra = GerenciadorObras.buscarObraArte(filtro, chaveBusca);
          
            System.out.println(obra.toString());
            
        } catch (Exception e)
        {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void listarObras()
    {
        System.out.println("\nObras cadastradas");

        try 
        {
            for(ObraArte obra : GerenciadorObras.listarObrasArte())
            {
                System.out.println(obra.toString());
            }
        } catch(Exception e)
        {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void apagarObra()
    {
        System.out.println("Informe o nome da obra que deseja apagar: ");
        String nomeObra = Console.lerString();

        try
        {
            GerenciadorObras.apagarObraArte(nomeObra);

            for(ObraArte obra : GerenciadorObras.listarObrasArte())
            {
                System.out.println(obra.toString());
            }
            
        } catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    private static void alterarObra()
    {
        System.out.println("Informe o nome da obra que deseja alterar: ");
        String nomeObra = Console.lerString();

        System.out.println("Oque deseja alterar na obra?");
        System.out.println("1) Titulo da obra");
        System.out.println("2) Nome do artista");
        System.out.println("3) Localização da obra");
        System.out.println("4) Ano de criação da obra");
        int filtroAlteracao = Console.lerInt();

        System.out.println("Digite o dado que deseja inserir no lugar do antigo: ");
        String dadoAlterado = Console.lerString();

        try
        {
            GerenciadorObras.alterarObraArte(filtroAlteracao, nomeObra, dadoAlterado);
        } catch(Exception e)
        {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}