package types;

public class Tovar {

    private String name;
    private int kol;
    private double price;

    public Tovar(String name, int kol, double price) {
        this.name = name;
        this.kol = kol;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKol() {
        return kol;
    }

    public void setKol(int kol) {
        this.kol = kol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
