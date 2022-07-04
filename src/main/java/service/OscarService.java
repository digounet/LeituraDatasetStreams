package service;

import model.DadosDengue;
import model.DadosOscar;
import model.DengueSummary;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OscarService {

    private final List<DadosOscar> dadosOscar;

    public OscarService(List<DadosOscar> dadosOscar) {
        this.dadosOscar = dadosOscar;
    }

    public void printYoungestActor() {
        var youngestActor = dadosOscar.stream()
                .min(Comparator.comparing(DadosOscar::getAge));
        System.out.println("Ator/atriz mais jovem a ser premiado:");
        youngestActor.ifPresent(actor -> System.out.println(actor));
        System.out.println();
    }


    public void printMostAwardedActor() {
        System.out.println("Ator/atriz com maior quantidade de premios");
        dadosOscar.stream()
                .collect(Collectors.groupingBy(DadosOscar::getName, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(e -> System.out.printf("%s com %d oscars.", e.getKey(), e.getValue()));
        System.out.println();
    }
}
