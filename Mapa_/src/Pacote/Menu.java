package Pacote;
public class Menu {
   
private int opcao;

    public void menuP(){
        System.out.println("\n ~~~~   (EMPRESA DICKMANN)  ~~~~  \n" +
                "\n   ~~~~      MENU PRINCIPAL        ~~~~     \n");
        System.out.println("[1] - Cadastro de Produtos ");
        System.out.println("[2] - Movimentação ");
        System.out.println("[3] - Reajuste de preços ");
        System.out.println("[4] - Relatórios ");
        System.out.println("[0] - Finalizar \n");
        System.out.print("Opção: ");
    }

    public void menuI(){
        System.out.println("\n ~~~~   (EMPRESA DICKMANN)  ~~~~  \n"   +                
                           "\n~~~~      CADASTRO DE PRODUTOS        ~~~~   \n");
        System.out.println("[1] - Inclusão ");
        System.out.println("[2] - Alteração ");
        System.out.println("[3] - Consulta ");
        System.out.println("[4] - Exclusão ");
        System.out.println("[0] - Retornar \n");
        System.out.print("Opção: ");
    }

    public void menuM(){
        System.out.println("\n ~~~~   (EMPRESA DICKMANN)  ~~~~  \n"   + 
                           "\n~~~~      MOVIMENTAÇÃO        ~~~~      \n");
        System.out.println("[1] - Entrada ");
        System.out.println("[2] - Saída ");
        System.out.println("[0] - Retornar \n");
        System.out.print("Opção: ");
    }

    public int getpcao() {
        return opcao;
    }

    public void setpcao(int opcao) {
        this.opcao = opcao;
    }
}
