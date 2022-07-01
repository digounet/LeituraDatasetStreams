import mappers.DadosDengueMapper;
import model.DadosDengue;
import util.FileUtil;

import java.io.IOException;
import java.time.LocalDate;
import java.util.function.Function;

import static java.lang.Integer.parseInt;

public class Application {
    public static void main(String[] args) throws IOException {
        var fileUtil = new FileUtil<DadosDengue>("dengue-dataset.csv");
        var dadosDengue = fileUtil.readFile(new DadosDengueMapper());

        dadosDengue.stream().forEach(System.out::println);
    }
}
