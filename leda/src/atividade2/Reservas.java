package atividade2;

import java.time.LocalDate;

public class Reservas {
    public String hospede;
    public int quarto;
    public LocalDate dataInicio;
    public LocalDate dataFim;

    public Reservas(String hospede, int quarto, LocalDate dataInicio, LocalDate dataFim) {
        this.hospede = hospede;
        this.quarto = quarto;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public String getHospede() {
        return hospede;
    }

    public int getQuarto() {
        return quarto;
    }

    @Override
    public String toString() {
        return "Reservas{" +
                "hospede='" + hospede + '\'' +
                ", quarto=" + quarto +
                ", dataInicio='" + dataInicio + '\'' +
                ", dataFim='" + dataFim + '\'' +
                '}';
    }
}
