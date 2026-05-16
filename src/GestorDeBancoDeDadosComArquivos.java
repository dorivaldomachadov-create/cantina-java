import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class GestorDeBancoDeDadosComArquivos extends Estoque{
    //guarda dados em arquivos
    String caminho = "C:\\Users\\flejo\\OneDrive\\Documentos\\Escola\\11ª\\2º trimestre\\S.I\\Projectos\\Exercícios\\Sistema_De_gestao_de_Cantina\\src\\DadosDeProdutos.txt";

    String linha;
    BufferedWriter escritor = null;

    public void GuardarDados(Estoque r){
        try {
            FileWriter escrever = new FileWriter(caminho);
            escritor = new BufferedWriter(escrever);
            for (int f =0; f<r.produtos.size(); f++){
                escritor.write(r.produtos.get(f).getNome() + ";" + r.produtos.get(f).getMarca() +";"+ r.produtos.get(f).getId() + ";" + r.produtos.get(f).getPreco() + ";" + r.produtos.get(f).getQuantidade());
                escritor.write("\n");
            }
            escritor.close();
        } catch (Exception erro) {
            System.out.println("erro");
            System.out.println(erro.getMessage());
        }
    }
    BufferedReader leitor = null;
    public void LerDados(Estoque t){
        try{
            FileReader fi = new FileReader(caminho);
            leitor = new BufferedReader(fi);
            int num = 0;
            linha = leitor.readLine();
            while (linha != null) {
                String[] dados = linha.split(";");
                t.produtos.add(new Produto());
                t.produtos.get(num).setNome(dados[0]);
                t.produtos.get(num).setMarca(dados[1]);
                t.produtos.get(num).setId(Integer.parseInt(dados[2]));
                t.produtos.get(num).setPreco(Double.parseDouble(dados[3]));
                t.produtos.get(num).setQuantidade(Integer.parseInt(dados[4]));
                num++;
                linha = leitor.readLine();
            }
        }catch (Exception Erro){
            System.out.println("erro");
            System.out.println(Erro.getMessage());

        }
    }
}
