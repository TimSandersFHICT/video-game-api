package api.requestbodies;

public class GenreRequestBody {

    private String name;

    private GenreRequestBody() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
