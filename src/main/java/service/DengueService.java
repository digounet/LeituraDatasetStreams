package service;

import model.DadosDengue;
import model.DengueSummary;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DengueService {

    private final List<DadosDengue> dadosDengue;

    public DengueService(List<DadosDengue> dadosDengue) {
        this.dadosDengue = dadosDengue;
    }

    public void printAnoMaiorQtdCasos() {

        var maiorQtdCasos = dadosDengue.stream()
                .collect(
                        Collectors.groupingBy(d ->
                                        d.getData().getYear(),
                                        Collectors.summingInt(DadosDengue::getQtdCasos)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());

        maiorQtdCasos.ifPresent(c ->  System.out.printf("%d é o ano com maior casos de dengue: %d", c.getKey(), c.getValue()));
    }


    public void printSumarioCasos() {
        dadosDengue.stream()
                .collect(Collectors.groupingBy(d -> d.getData().getYear()))
                .entrySet().stream()
                .collect(Collectors.toMap(x -> {
                    int qtdCasos = x.getValue().stream().mapToInt(DadosDengue::getQtdCasos).sum();
                    double totalChuva = x.getValue().stream().mapToDouble(DadosDengue::getTotalChuva).sum();
                    return new DengueSummary(x.getKey(), qtdCasos, totalChuva);
                }, Map.Entry::getValue))
                .keySet().stream()
                //.sorted((s1, s2) -> Integer.valueOf(s1.getAno()).compareTo(s2.getAno()))
                .sorted(Comparator.comparingInt(DengueSummary::getAno))
                .forEach(i -> System.out.printf("%d - Casos: %5d - Chuva: %8.2f\n", i.getAno(), i.getQtdCasos(), i.getTotalChuva()));
    }
}
