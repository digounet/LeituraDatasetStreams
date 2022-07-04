package mappers;

import model.DadosDengue;
import model.DadosOscar;

import java.time.LocalDate;
import java.util.function.Function;

import static java.lang.Integer.parseInt;

public class DadosOscarMapper implements Function<String, DadosOscar> {
    @Override
    public DadosOscar apply(String l) {
        var dadosLinha = l.split(";");
        var index = Long.parseLong(dadosLinha[0].strip());
        var year = parseInt(dadosLinha[1].strip());
        var age = Integer.parseInt(dadosLinha[2].strip());
        var name = dadosLinha[3].strip();
        var movie = dadosLinha[4].strip();

        return new DadosOscar(index, year, age, name, movie);
    }
}
