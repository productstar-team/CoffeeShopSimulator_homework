public class Pastry extends MenuItem {
    private boolean isWarm;

    public Pastry(String name, double price, boolean isWarm) {
        super(name, price);
        this.isWarm = isWarm;
    }

    @Override
    public String getDescription() {
        return name + (isWarm ? " (Теплая)" : " (Холодная)");
    }
}