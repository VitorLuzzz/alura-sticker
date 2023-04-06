import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
      

        // Fazer conexão http e buscar os top 250 filmes
       // String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
       // ExtratorDeConteudos extrator = new ExtratorDeConteudoDoIMDB();

        //String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&Start_date";
       // ExtratorDeConteudos extrator = new ExtratorDeConteudoDaNasa();
        
       String url = "http://localhost:8080/linguagens";
       ExtratorDeConteudos extrator = new ExtratorDeConteudoDoIMDB();

       var http = new ClienteHttp();
       String json = http.buscaDados(url);

        
        //Exibir e manipular dados
        
        List<Conteudo> conteudos = extrator.extraiConteudos(json);
        var geradora =  new GeradoraDeFigurinha();

        for (int i = 0; i < 3; i++){

            Conteudo conteudo = conteudos.get(i);

          /*  String urlImagem = filme.get("image");
            String titulo = filme.get("title");
            InputStream inputStream = new URL(urlImagem).openStream();
            
            String nomeArquivo = titulo + ".png"; */

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

           geradora.cria(inputStream, nomeArquivo);  
        
            System.out.println(conteudo.getTitulo());
            System.out.println();
        
        }

    }
}
