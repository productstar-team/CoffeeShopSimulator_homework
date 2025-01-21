public class Tea extends MenuItem implements Preparable {
    private String type;

    public Tea(String name, double price, String type) {
        super(name, price);
        this.type = type;
    }

    @Override
    public void prepare() {
        System.out.println("Завариваем " + name + " (" + type + ")");
    }

    @Override
    public String getDescription() {
        return name + " (Тип: " + type + ")";
    }
}