package atividade2;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

public class GerenciadorReservas {
    Scanner scan = new Scanner(System.in);
    HashMap<String, Reservas> reservas = new HashMap<>();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void adicionarReserva(){
        System.out.print("Digite o nome do hospede: ");
        String hospede = scan.nextLine().toLowerCase();

        System.out.print("Digite o numero do quarto: ");
        int quarto = scan.nextInt();
        scan.nextLine();

        System.out.print("Digite a data de inicio (dd/MM/yyyy): ");
        LocalDate dataInicio = LocalDate.parse(scan.nextLine(), formatter);

        System.out.print("Digite a data de fim (dd/MM/yyyy):");
        LocalDate dataFim = LocalDate.parse(scan.nextLine(), formatter);

        Reservas novaReserva = new Reservas(hospede, quarto, dataInicio, dataFim);

        reservas.put(hospede, novaReserva);
    }

    public void removerReserva(){
        if(reservas.isEmpty()){
            System.out.println("Sem reservas adicionadas!");
        }

        System.out.println("Digite o nome do hospede para remove-lo: ");
        String hospede = scan.nextLine().toLowerCase();

        if(reservas.containsKey(hospede)){
            reservas.remove(hospede);
            System.out.println("Reserva removida com sucesso!");
        }else{
            System.out.println("Reserva nao encontrada!");
        }
    }
    public void buscarHospede(){
        if(reservas.isEmpty()){
            System.out.println("Sem reservas adicionadas!");
        }

        System.out.println("Digite o nome do hospede para busca-lo: ");
        String hospede = scan.nextLine().toLowerCase();

        if(reservas.containsKey(hospede)){

            Reservas reserva = reservas.get(hospede);

            System.out.println("-------Dados da reserva-------");
            System.out.println("Hóspede: " + reserva.hospede);
            System.out.println("Quarto: " + reserva.quarto);
            System.out.println("Data de Início: " + reserva.dataInicio);
            System.out.println("Data de Fim: " + reserva.dataFim);

        }else{
            System.out.println("Reserva nao encontrada!");
        }
    }

    public void checarQuarto(){
        System.out.print("Digite o número do quarto: ");
        int quarto = scan.nextInt();
        scan.nextLine();

        boolean reservado = false;

        // Percorrer todas as reservas e verificar se algum quarto corresponde ao que foi digitado
        for (Reservas reserva : reservas.values()) {
            if (reserva.getQuarto() == quarto) {
                System.out.println("O quarto já está reservado para " + reserva.getHospede());
                reservado = true;
                break;
            }
        }
    }

}
