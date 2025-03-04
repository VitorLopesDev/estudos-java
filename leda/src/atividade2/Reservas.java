package atividade2;

import java.time.LocalDate;

public class Reservas {
    private String hospede;
    private int quarto;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public Reservas(String hospede, int quarto, LocalDate dataInicio, LocalDate dataFim) {
        this.hospede = hospede;
        this.quarto = quarto;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public String getHospede() {
        return hospede;
    }

    public void setHospede(String hospede) {
        this.hospede = hospede;
    }

    public int getQuarto() {
        return quarto;
    }

    public void setQuarto(int quarto) {
        this.quarto = quarto;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    @Override
    public String toString() {
        return "{" +
                "hospede: '" + hospede + '\'' +
                ", quarto: " + quarto +
                ", dataInicio: '" + dataInicio + '\'' +
                ", dataFim: '" + dataFim + '\'' +
                '}';
    }
}
