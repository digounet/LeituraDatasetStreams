package mappers;

import model.DadosDengue;

import java.time.LocalDate;
import java.util.function.Function;

import static java.lang.Integer.parseInt;

public class DadosDengueMapper implements Function<String, DadosDengue> {
    @Override
    public DadosDengue apply(String l) {
        var dadosLinha = l.split(",");
        var data = LocalDate.parse(dadosLinha[0]);
        var qtdCasos = parseInt(dadosLinha[1]);
        var qtdChuva = Double.parseDouble(dadosLinha[2]);
        var tempMedia = Double.parseDouble(dadosLinha[3]);
        var tempMinima = Double.parseDouble(dadosLinha[4]);
        var tempMax = Double.parseDouble(dadosLinha[5]);

        return new DadosDengue(data, qtdCasos, qtdChuva, tempMedia, tempMinima, tempMax);
    }
}
