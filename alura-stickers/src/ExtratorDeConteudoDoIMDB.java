import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDoIMDB implements ExtratorDeConteudos {

  


        public List<Conteudo> extraiConteudos(String json){

            // Extrair só os dados que interessam (Titulo, poster, classificação)
            var parser = new JsonParser();
           List<Map<String,String>> listaDeAtributos = parser.parse(json);
   
   
           List<Conteudo> conteudos = new ArrayList<>();
   
           // popular a lista de conteudos
           for (Map<String,String> atributos : listaDeAtributos) {
               String titulo = atributos.get("title");
               String urlImagem = atributos.get("image")
               .replaceAll("(@+)(.*).jpgs", "$1.jpg");;
              var conteudo = new Conteudo(titulo, urlImagem);
   
              conteudos.add(conteudo);
           }
   
           return conteudos;
   
    }

    
    
}
