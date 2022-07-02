import mappers.DadosDengueMapper;
import model.DadosDengue;
import model.DengueSummary;
import service.DengueService;
import util.FileUtil;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        var fileUtil = new FileUtil<DadosDengue>("dengue-dataset.csv");

        var dadosDengue = fileUtil.readFile(new DadosDengueMapper());
        var dengueService = new DengueService(dadosDengue);

        dengueService.printAnoMaiorQtdCasos();
        dengueService.printSumarioCasos();

        // exercicios
        // 1 - Importar dataset
        // 2 - Criar model que represente os dados
        // 3 - Transformar os dois arquivos em apenas 1 stream
        // 4 - Ator mais jovem a ser premiado
        // 5 - Ator com maior qtd de prêmios
    }
}
