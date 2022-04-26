package Pacote;

import java.util.Scanner;

public class MapaPr00g1 {

     public static void main(String[] args) {
         
        Menu menu1 = new Menu();
        Menu menu2 = new Menu();
        Menu menu3 = new Menu();
        EmpresaCadastro almoxarifado = new EmpresaCadastro();

        do {
            menu1.menuP();
            Scanner opcao = new Scanner(System.in);
            int op = opcao.nextInt();
            menu1.setpcao(op);
            switch (menu1.getpcao()) {

                case 1:
                     do {
                         menu2.menuI();
                         Scanner opcao1 = new Scanner(System.in);
                         int op1 = opcao1.nextInt();
                         menu2.setpcao(op1);
                         switch (menu2.getpcao()) {
                             case 1:
                                 almoxarifado.Inclusao();
                                 break;
                             case 2:
                                 almoxarifado.Alteracao();
                                 break;
                             case 3:
                                 almoxarifado.Pesquisa();
                                 break;
                             case 4:
                                 almoxarifado.Exclusao();
                                 break;
                             case 0:
                                 break;
                             default:
                                 System.out.println("Selecione uma opção");
                         }
                    } while (menu2.getpcao() != 0);
                    break;

                case 2:

                    do {
                        menu3.menuM();
                        Scanner opcao2 = new Scanner(System.in);
                        int op2 = opcao2.nextInt();
                        menu3.setpcao(op2);
                        switch (menu3.getpcao()) {
                            case 1:
                            almoxarifado.Entrada();
                                break;
                            case 2:
                            almoxarifado.saida();
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Seleciona uma opção");
                        }
                    } while (menu3.getpcao()!= 0);
                    break;

                case 3:
                    almoxarifado.mudaValor();
                    break;

                case 4:
                    almoxarifado.impressao();
                    break;

                case 0:


                    break;
                default:
                    System.out.println("Selecione uma opção");
            }

        } while (menu1.getpcao() != 0);

     }
}
