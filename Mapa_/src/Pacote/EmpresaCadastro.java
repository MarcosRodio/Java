package Pacote;
import java.util.ArrayList;
import java.util.Scanner;

public class EmpresaCadastro {
    

    ArrayList<Produt0> centroCusto = new ArrayList<>();

    void impressao(String nome) {
        System.out.println("\n ~~~~   (EMPRESA DICKMANN)  ~~~~  \n"   +
                "\n ~imprime \n");
        centroCusto.stream().filter(prod -> (prod.getNome().equalsIgnoreCase(nome))).map(prod -> {
            System.out.println("Nome: " + prod.getNome());
            return prod;
        }).map(prod -> {
            System.out.println("Unidade: " + prod.getUnidade());
            return prod;
        }).map(prod -> {
            System.out.println("Preço: R$ " + prod.getPreco());
            return prod;
        }).forEachOrdered(prod -> {
            System.out.println("Quantidade: " + prod.getQuantidadeEmEstoque());
        });
    }

    void impressao() {
        System.out.println("\n ~~~~   (EMPRESA DICKMANN)  ~~~~  \n"   +                
                "\n ~imprime \n");
        centroCusto.stream().map(prod -> {
            System.out.println("Numero: " + (centroCusto.indexOf(prod) + 1));
            return prod;
        }).map(prod -> {
            System.out.println("Nome: " + prod.getNome());
            return prod;
        }).map(prod -> {
            System.out.println("Unidade: " + prod.getUnidade());
            return prod;
        }).map(prod -> {
            System.out.println("Preço: R$ " + prod.getPreco());
            return prod;
        }).forEachOrdered(prod -> {
            System.out.println("Quantidade: " + prod.getQuantidadeEmEstoque());
        });
        if (centroCusto.isEmpty()) {
            System.out.println("Nenhum produto cadastrado \n");
        }
    }

    private boolean temNome(String nome) {
        Boolean encontrado = false;
        for (Produt0 item : centroCusto) {
            if (item.getNome().equalsIgnoreCase(nome)) encontrado = true;
        }
        return encontrado;
    }

    private boolean temPreco(double preco) {
        Boolean valor = false;
        if (preco > 0) valor = true;
        return valor;
    }

    private boolean temquantidadeEmEstoque(int qtde) {
        Boolean quantidade = false;
        if (qtde > 0) quantidade = true;
        return quantidade;
    }

    public void Inclusao() {
        double preco;
        int quantidadeEmEstoque;
        System.out.println("\n ~~~~   (EMPRESA DICKMANN)  ~~~~  \n"   +               
                "     ~incluir *\n");
        System.out.print("Nome do produto: ");
        Scanner entrada = new Scanner(System.in);
        String nome = entrada.nextLine();
        if (temNome(nome)) {
            System.out.println("Produto já está cadastrado !\n");
        } else {
            do {
                System.out.print("Preço do produto: ");
                preco = entrada.nextDouble();
                if (preco <= 0) System.out.println("Preço deverá ser maior que 0 ");
            } while (!temPreco(preco));
            //do {
                System.out.print("Quantidade: ");
                quantidadeEmEstoque = entrada.nextInt();
               // if (quantidadeEmEstoque <= 0) System.out.println("Quantidade deverá ser maior que 0 ");
            //} while (!temQuantidadeEmEstoque(quantidadeEmEstoque));
            System.out.print("Unidade: ");
            String unidade = entrada.next();
            Produt0 prod = new Produt0();
            Scanner ent = new Scanner(System.in);
            System.out.print("\n Continuar? - S/N: ");
            String continua = ent.next();
            if (continua.equalsIgnoreCase("s")) {
                this.centroCusto.add(prod);
                prod.setNome(nome);
                prod.setPreco(preco);
                prod.setQuantidadeEmEstoque(quantidadeEmEstoque);
                prod.setUnidade(unidade);
            }
        } 
    }
    
    public void Alteracao() {
        int quantidadeEmEstoque = 0;
        double preco = 0;
        System.out.println("\n ~~~~   (EMPRESA DICKMANN)  ~~~~  \n"   +              
                " ~Alteração  \n");

        System.out.print("Nome do produto:");
        Scanner entrada = new Scanner(System.in);
        String nome = entrada.nextLine();
        if (temNome(nome)) {
            for (Produt0 prod : centroCusto) {
                if (prod.getNome().equalsIgnoreCase(nome)) {
                    System.out.println("Produto: " + prod.getNome());
                    System.out.println("Quantidade: " + prod.getQuantidadeEmEstoque());
                    System.out.println("Preço: " + prod.getPreco());
                    System.out.println("Unidade: " + prod.getUnidade());

                    do {
                        System.out.print("Nova quantidade: ");
                        quantidadeEmEstoque = entrada.nextInt();
                        if (quantidadeEmEstoque <= 0) System.out.println("Quantidade deverá ser maior que 0 ");
                    } while (!temQuantidadeEmEstoque(quantidadeEmEstoque));
                    do {
                        System.out.print("Novo valor: ");
                        preco = entrada.nextDouble();
                        if (preco <= 0) System.out.println("Preço deverá ser maior que 0");
                    } while (!temPreco(preco));
                    System.out.print("Nova unidade: ");
                    String unidade = entrada.next();
                    System.out.println("Continuar: " + " S/N");
                    String continua = entrada.next();
                    if (continua.equalsIgnoreCase("s")) {
                        prod.setQuantidadeEmEstoque(quantidadeEmEstoque);
                        prod.setUnidade(unidade);
                        prod.setPreco(preco);
                    } else {
                        System.out.println("Saindo..\n");
                    }
                }
            }
        } 
    }

    public void mudaValor() {
        boolean correto = false;
        double precoN = 0;
        System.out.println("\n ~~~~   (EMPRESA DICKMANN)  ~~~~  \n"   +                
                "            * REAJUSTE *\n");
        System.out.print("Digite o nome do produto: ");
        Scanner entrada = new Scanner(System.in);
        String nome = entrada.nextLine();
        for (Produt0 produto : centroCusto) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                correto = true;
                System.out.println("Nome: " + produto.getNome());
                System.out.println("Preço: " + produto.getPreco());
                do {
                    System.out.print("Novo preço: ");
                    precoN = entrada.nextDouble();
                    if (precoN <= 0) System.out.println("Preço deverá ser maior 0.");
                } while (!temPreco(precoN));
                System.out.print("Continuar S/N: ");
                String continua = entrada.next();
                if (continua.equalsIgnoreCase("s")) produto.setPreco(precoN);
            }
        }
        if (correto == false) {
            System.out.println("\n Não foi possível encontrar =( ");
        }
    }

    public void Pesquisa() {
        boolean correto = false;
        String continua = "N";
        System.out.println("\n ~~~~   (EMPRESA DICKMANN)  ~~~~  \n"   +             
                " \n    ~Consulta \n");
        do {
            System.out.print("Nome do Produto: ");
            Scanner entrada = new Scanner(System.in);
            String nome = entrada.nextLine();
            for (Produt0 produto : centroCusto) {
                if (produto.getNome().equalsIgnoreCase(nome)) {
                    correto = true;
                    impressao(nome);
                }
            }
            if (correto == false) {
                System.out.println("\n Não foi possível encontrar =( ");
            }

        } while (continua.equalsIgnoreCase("s"));
    }

    private void RemoveItem(String prod) {
        String nome = prod;
        centroCusto.removeIf(item -> item.getNome().equalsIgnoreCase(nome));
    }

    public void Exclusao() {
        System.out.println("\n ~~~~   (EMPRESA DICKMANN)  ~~~~  \n"   +   
                "  ~excluir  \n");

        System.out.print("Nome do produto: ");
        Scanner entrada = new Scanner(System.in);
        String nome = entrada.nextLine();
        impressao(nome);
        System.out.print("\n Excluir?  S/N: ");
        String continua = entrada.nextLine();
        if (continua.equalsIgnoreCase("s")) RemoveItem(nome);
    }

  
    public void Entrada() {
        boolean correto = false;
        int adiciona = 0;
        System.out.println("\n ~~~~   (EMPRESA DICKMANN)  ~~~~  \n"   +   
                "  ~entrada *\n");

        System.out.print("Informe o produto para dar entrada ");

        Scanner entrada = new Scanner(System.in);
        String nome = entrada.nextLine();
        for (Produt0 item : centroCusto) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                //do {
                    System.out.println("Nome: " + item.getNome());
                    System.out.println("Quantidade:" + item.getQuantidadeEmEstoque());
                    System.out.print("Adicionar: ");
                    adiciona = entrada.nextInt();
                    if (adiciona <= 0) System.out.println("Quantidade deverá  ser maior que 0.");
               // } while (!temQuantidadeEmEstoque(adiciona));
                correto = true;
                int total = item.getQuantidadeEmEstoque() + adiciona;
                System.out.print("\n Continuar? S/N: ");
                String continua = entrada.next();
                if (continua.equalsIgnoreCase("s")) item.setQuantidadeEmEstoque(total);
            }
        }
        if (correto == false) {
            System.out.println("\n Produto não cadastrado ");
        }
    }

    public void saida() {
        boolean correto = false;
        int remove = 0;
        System.out.println("\n ~~~~   (EMPRESA DICKMANN)  ~~~~  \n"   +   
                "  ~saída   \n");

        System.out.print("Digite o nome do produto para saída: ");
        Scanner entrada = new Scanner(System.in);
        Scanner entrada2 = new Scanner(System.in);
        String nome = entrada.nextLine();
        for (Produt0 item : centroCusto) {

            if (item.getNome().equalsIgnoreCase(nome)) {
                do {
                    System.out.println("Nome: " + item.getNome());
                    System.out.println("Quantidade: " + item.getQuantidadeEmEstoque());
                    System.out.print("Diminuir: ");
                    remove = entrada2.nextInt();
                    if (remove <= 0) System.out.println("Quantidade deverá ser maior 0.");
                } while (!temQuantidadeEmEstoque(remove));
                correto = true;
                int total = item.getQuantidadeEmEstoque() - remove;
                System.out.print("\n\n Continuar?  S/N: ");
                Scanner ler = new Scanner(System.in);
                String continua = ler.next();
                if (continua.equalsIgnoreCase("s")) item.setQuantidadeEmEstoque(total);
            }
        }
        if (correto == false) {
            System.out.println("\n\n Produto não cadastrado ");
        }
    }

    private boolean temQuantidadeEmEstoque(int remove) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}

