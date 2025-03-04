package atividade2;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Scanner;

public class GerenciadorReservas {
    Scanner scan = new Scanner(System.in);
    HashMap<String, Reservas> reservas = new HashMap<>();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void adicionarReserva(){
        int quarto;
        LocalDate dataInicio, dataFim;

        System.out.print("Digite o nome do hospede: ");
        String hospede = scan.nextLine().toLowerCase();

        while(true){
            System.out.print("Digite o numero do quarto: ");

            if(!scan.hasNextInt()){
                System.out.println("Numero invalido! digite o numero no formato inteiro");
                scan.nextLine();
                continue;
            }
            quarto = scan.nextInt();
            scan.nextLine();

            System.out.print("Digite a data de inicio (dd/MM/yyyy): ");
            dataInicio = LocalDate.parse(scan.nextLine(), formatter);

            System.out.print("Digite a data de fim (dd/MM/yyyy): ");
            dataFim = LocalDate.parse(scan.nextLine(), formatter);
            System.out.println();

            if(dataFim.isBefore(dataInicio) || dataInicio.isEqual(dataFim)){
                System.out.println("Data invalida, tente novamente");
            }else{
                break;
            }
        }

        Reservas novaReserva = new Reservas(hospede, quarto, dataInicio, dataFim);

        reservas.put(hospede, novaReserva);
    }

    public void removerReserva(){
        if(reservas.isEmpty()){
            System.out.println("Nao ha reservas cadastradas!");
            System.out.println();
            return;
        }

        System.out.print("Digite o nome do hospede para remove-lo: ");
        String hospede = scan.nextLine().toLowerCase();

        if(reservas.containsKey(hospede)){
            reservas.remove(hospede);
            System.out.println("Reserva removida com sucesso!");
            System.out.println();
        }else{
            System.out.println("Reserva nao encontrada!");
        }
    }
    public void buscarHospede(){
        if(reservas.isEmpty()){
            System.out.println("Nao ha reservas cadastradas!");
            System.out.println();
            return;
        }

        System.out.print("Digite o nome do hospede para busca-lo: ");
        String hospede = scan.nextLine().toLowerCase();

        if(reservas.containsKey(hospede)){

            Reservas reservas = this.reservas.get(hospede);

            System.out.println("-------Dados da reservas-------");
            System.out.println("Hóspede: " + reservas.getHospede());
            System.out.println("Quarto: " + reservas.getQuarto());
            System.out.println("Data de Início: " + reservas.getDataInicio());
            System.out.println("Data de Fim: " + reservas.getDataFim());
            System.out.println();

        }else{
            System.out.println("Hospede nao encontrado!");
        }
    }
    public void listarHospedes(){
        if(reservas.isEmpty()){
            System.out.println("Nao ha reservas cadastradas!");
            System.out.println();
            return;
        }

        reservas.forEach((nome, reserva) -> System.out.println("Lista: " + reserva));
        System.out.println();
    }

    public void checarQuarto(){
        System.out.print("Digite o número do quarto: ");
        int quarto = scan.nextInt();
        scan.nextLine();

        boolean reservado = false;

        for (Reservas reserva : reservas.values()) {
            if (reserva.getQuarto() == quarto) {
                System.out.println("O quarto já está reservado para " + reserva.getHospede());
                System.out.println();
                reservado = true;
                break;
            }
        }
        if(!reservado){
            System.out.println("O quarto esta livre!");
            System.out.println();
        }
    }

    public void valorConta(){
        if(reservas.isEmpty()){
            System.out.println("Nao ha reservas cadastradas!");
            System.out.println();
            return;
        }

        System.out.print("Digite o valor do quarto por dia: ");
        double valorQuarto = scan.nextDouble();
        scan.nextLine();

        System.out.print("Digite o nome do hospede: ");
        String hospede = scan.nextLine().toLowerCase();

        if(reservas.containsKey(hospede)){
            Reservas reserva = reservas.get(hospede);
            long dias = ChronoUnit.DAYS.between(reserva.getDataInicio(), reserva.getDataFim());
            double total = valorQuarto * dias;
            System.out.println("O total da conta do hospede " + hospede + " e de: " + String.format("%.2f", total));
            System.out.println();
        }else{
            System.out.println("Hospede nao encontrado!");
            System.out.println();
        }

    }

}
