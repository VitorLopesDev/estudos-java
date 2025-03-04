package atividade2;
import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        GerenciadorReservas gerenciador = new GerenciadorReservas();
        boolean loop = true;

        while(loop){
            System.out.println("1 adicionar uma reserva");
            System.out.println("2 buscar um hospede");
            System.out.println("3 listar todos os hospedes");
            System.out.println("4 remover uma reserva");
            System.out.println("5 checar um quarto");
            System.out.println("6 ver o valor da conta");
            System.out.println("7 sair\n");
            System.out.print("Digite uma opçao: ");

            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao){
                case 1:
                    gerenciador.adicionarReserva();
                    break;
                case 2:
                    gerenciador.buscarHospede();
                    break;
                case 3:
                    gerenciador.listarHospedes();
                    break;
                case 4:
                    gerenciador.removerReserva();
                    break;
                case 5:
                    gerenciador.checarQuarto();
                    break;
                case 6:
                    gerenciador.valorConta();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    loop = false;
                    break;
                default:
                    System.out.println("Digite uma opcao valida!");
            }
        }

    }
}
