package ch.bbcag.datoria;

/**
 * Created by bbetti on 02.05.2017.
 */

public class Debt {

    private String title;
    private double value;


    public Debt() {
        title = "";
        value = 0d;
    }

    public Debt(String title, double value) {
        this.title = title;
        this.value = value;
    }


    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
