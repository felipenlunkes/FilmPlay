import com.google.gson.annotations.SerializedName;

public class FilmsEntity {

    @SerializedName("Title")
    private String filmName;
    @SerializedName("Year")
    private int releaseYear;
    @SerializedName("Released")
    private String releasedTime;
    @SerializedName("Runtime")
    private String runtime;
    @SerializedName("Plot")
    private String plot;
    @SerializedName("Genre")
    private String genre;
    @SerializedName("Director")
    private String director;

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {

        return "Nome do filme: " + this.filmName + "\n" +
                "Gênero: " + this.genre + "\n" +
                "Ano de lançamento: " + this.releaseYear + "\n" +
                "Data de lançamento: " + this.releasedTime + "\n" +
                "Diretor: " + this.director + "\n" +
                "Duração (minutos): " + this.runtime + "\n" +
                "Resumo: " + this.plot;

    }
}
