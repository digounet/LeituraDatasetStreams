import mappers.DadosDengueMapper;
import mappers.DadosOscarMapper;
import model.DadosDengue;
import model.DadosOscar;
import model.DengueSummary;
import service.DengueService;
import service.OscarService;
import util.FileUtil;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) throws IOException {
        // exercicios

        // 1 - Importar dataset
        // 2 - Criar model que represente os dados
        var fileUtilOscarMale = new FileUtil<DadosOscar>("oscar_age_male.csv");
        var dadosOscarMale = fileUtilOscarMale.readFile(new DadosOscarMapper());
        dadosOscarMale.forEach(data -> data.setSex("male"));

        var fileUtilOscarFemale = new FileUtil<DadosOscar>("oscar_age_female.csv");
        var dadosOscarFemale = fileUtilOscarFemale.readFile(new DadosOscarMapper());
        dadosOscarFemale.forEach(data -> data.setSex("female"));

        // 3 - Transformar os dois arquivos em apenas 1 stream
        List<DadosOscar> dadosOscar = Stream.concat(dadosOscarFemale.stream(), dadosOscarMale.stream())
                .sorted(Comparator.comparing(DadosOscar::getYear))
                .collect(Collectors.toList());

        var oscarService = new OscarService(dadosOscar);

        // 4 - Ator mais jovem a ser premiado
        oscarService.printYoungestActor();

        // 5 - Ator com maior qtd de prêmios
        oscarService.printMostAwardedActor();

        // 6 - Quem foi o jovem mais premiado (entre 18 e 24 anos)?
        oscarService.printMostAwardedYoungActor();
    }
}
