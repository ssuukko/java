package extends1.ex5;

public class Movie extends Item{
    private String director;
    private String actor;

    public Movie(String name, int price, String director, String actor) {
        super(name, price);
    }
}
