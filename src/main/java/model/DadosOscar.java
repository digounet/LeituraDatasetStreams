package model;

public class DadosOscar {

    private static Long classIndex = 1l;
    private Long index;
    private Integer year;
    private Integer age;
    private String name;
    private String movie;
    private String sex;

    public DadosOscar(Long index, int year, int age, String name, String movie) {
        this.index = index;
        this.year = year;
        this.age = age;
        this.name = name;
        this.movie = movie;
    }

    public Long getIndex() {
        return index;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getMovie() {
        return movie;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "DadosOscar{" +
                "index=" + index +
                ", year=" + year +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", movie='" + movie + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
