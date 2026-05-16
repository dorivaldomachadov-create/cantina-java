import java.util.Scanner;
public class Produto {
    Scanner sc = new Scanner(System.in);
    private String nome;
    private String marca;
    private int id;
    private double preco;
    private int quantidade;


    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void Cadartrar(){
        System.out.println("Digite o nome do produto: ");
        setNome(sc.nextLine());
        System.out.println("Digite a marca desse produto: ");
        setMarca(sc.nextLine());
        System.out.println("Digite o id do produto: ");
        setId(sc.nextInt());
        System.out.println("Digite o preço do produto: ");
        setPreco(sc.nextDouble());
        System.out.println("Digite a quantidade do produto: ");
        setQuantidade(sc.nextInt());
    }
    public void Editar(){
        System.out.println("Selecione o que deseja editar : ");
        System.out.println("[ 1 ] - Nome");
        System.out.println("[ 2 ] - Marca");
        System.out.println("[ 3 ] - ID");
        System.out.println("[ 4 ] - Preço");
        System.out.println("[ 5 ] - Quantidade");
        int opcao;
        opcao = sc.nextInt();

        switch (opcao){
            case 1:
                System.out.println("Digite o Nome: ");
                setNome(sc.nextLine());
                break;
            case 2:
                System.out.println("Digite a Marca: ");
                setMarca(sc.nextLine());
                break;
            case 3:
                System.out.println("Digite o ID: ");
                setId(sc.nextInt());
                break;
            case 4:
                System.out.println("Digite o Preço");
                setPreco(sc.nextDouble());
                break;
            case 5:
                System.out.println("Digite a quantidade: ");
                setQuantidade(sc.nextInt());
                break;
        }

    }
    public void ExibirInfoEstoque(){
        System.out.println(getNome()+" "+getMarca()+" Preço: "+getPreco()+" Quantidade: "+getQuantidade());
    }
    public void ReduduzirQuatidade(int quantidad){
        if(getQuantidade()>=quantidad){
            this.quantidade = getQuantidade() - quantidad;
            ExibirInfoEstoque();
        }else {
            System.out.println("Quantidade não disponivel no estoque");
            ExibirInfoEstoque();
        }
    }



}
