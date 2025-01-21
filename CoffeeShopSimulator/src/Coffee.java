public class Coffee extends MenuItem implements Preparable {
    private int strength;

    public Coffee(String name, double price, int strength) {
        super(name, price);
        this.strength = strength;
    }

    @Override
    public void prepare() {
        System.out.println("Готовим " + name + " крепостью " + strength);
    }

    @Override
    public String getDescription() {
        return name + " (Крепость: " + strength + ")";
    }
}