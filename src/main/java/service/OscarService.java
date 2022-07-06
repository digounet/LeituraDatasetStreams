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
        youngestActor.ifPresent(actor -> System.out.printf("Nome: %s, Idade: %d %n", actor.getName(), actor.getAge()));
        System.out.println();
    }


    public void printMostAwardedActor() {
        System.out.println("Ator/atriz com maior quantidade de premios");
        dadosOscar.stream()
                .collect(Collectors.groupingBy(DadosOscar::getName, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue))
                .entrySet().stream()
                .max(Map.Entry.comparingByKey())
                .get()
                .getValue()
                .forEach(a -> System.out.printf("Nome: %-18s Qtd de prêmios: %d%n", a.getKey(), a.getValue()));
        System.out.println();
    }
    public void printMostAwardedYoungActor() {
        System.out.println("Ator/atriz jovem mais premiado (entre 18 e 24 anos)");
        dadosOscar.stream()
                .filter(a -> a.getAge() >= 18 && a.getAge() <= 24)
                .collect(Collectors.groupingBy(DadosOscar::getName, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue))
                .entrySet().stream()
                .max(Map.Entry.comparingByKey())
                .get()
                .getValue()
                .forEach(a -> System.out.printf("Nome: %-18s Qtd de prêmios: %d%n", a.getKey(), a.getValue()));
        System.out.println();
    }
}
