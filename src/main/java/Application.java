import mappers.DadosDengueMapper;
import mappers.DadosOscarMapper;
import model.DadosDengue;
import model.DadosOscar;
import model.DengueSummary;
import service.DengueService;
import util.FileUtil;

import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) throws IOException {
        //var fileUtil = new FileUtil<DadosDengue>("dengue-dataset.csv");

        //var dadosDengue = fileUtil.readFile(new DadosDengueMapper());
        //var dengueService = new DengueService(dadosDengue);

        //dengueService.printAnoMaiorQtdCasos();
        //dengueService.printSumarioCasos();

        // exercicios
        // 1 - Importar dataset
        // 2 - Criar model que represente os dados
        var fileUtilOscarMale = new FileUtil<DadosOscar>("oscar_age_male.csv");
        var dadosOscarMale = fileUtilOscarMale.readFile(new DadosOscarMapper());
        dadosOscarMale.forEach(data -> data.setSex("male"));

        var fileUtilOscarFemale = new FileUtil<DadosOscar>("oscar_age_female.csv");
        var dadosOscarFemale = fileUtilOscarFemale.readFile(new DadosOscarMapper());
        dadosOscarFemale.forEach(data -> data.setSex("female"));

//        dadosOscarFemale.forEach(System.out::println);
//        dadosOscarMale.forEach(System.out::println);

        // 3 - Transformar os dois arquivos em apenas 1 stream
        // 4 - Ator mais jovem a ser premiado
        var youngestActor = Stream.concat(dadosOscarFemale.stream(), dadosOscarMale.stream())
                .min(Comparator.comparing(DadosOscar::getAge));
        System.out.println("Ator/atriz mais jovem a ser premiado:");
        youngestActor.ifPresent(actor -> System.out.println(actor));

        // 5 - Ator com maior qtd de prêmios
        System.out.println("\nAtor com maior quantidade de premios");
        Stream.concat(dadosOscarFemale.stream(), dadosOscarMale.stream())
                .collect(Collectors.groupingBy(DadosOscar::getName, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(e -> System.out.printf("%s com %d oscars.", e.getKey(), e.getValue()));
    }
}
