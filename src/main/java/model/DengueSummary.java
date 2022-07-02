package model;

public class DengueSummary {
    private int ano;
    private int qtdCasos;
    private double totalChuva;

    public DengueSummary(int ano, int qtdCasos, double totalChuva) {
        this.ano = ano;
        this.qtdCasos = qtdCasos;
        this.totalChuva = totalChuva;
    }

    public int getAno() {
        return ano;
    }

    public int getQtdCasos() {
        return qtdCasos;
    }

    public double getTotalChuva() {
        return totalChuva;
    }
}
