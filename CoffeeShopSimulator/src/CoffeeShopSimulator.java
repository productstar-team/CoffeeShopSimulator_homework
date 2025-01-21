public class CoffeeShopSimulator {
    public static void main(String[] args) {
        CoffeeShop shop = new CoffeeShop();

        shop.addMenuItem(new Coffee("Эспрессо", 80, 5));
        shop.addMenuItem(new Coffee("Капучино", 120, 3));
        shop.addMenuItem(new Tea("Зеленый чай", 70, "Зеленый"));
        shop.addMenuItem(new Tea("Черный чай", 70, "Черный"));
        shop.addMenuItem(new Pastry("Круассан", 60, true));

        shop.displayMenu();

        shop.placeOrder(0, Size.SMALL);
        CoffeeShop.CoffeeShopStats.addOrder(80);

        shop.placeOrder(1, Size.LARGE);
        CoffeeShop.CoffeeShopStats.addOrder(120 * 1.4);

        shop.placeOrder(4, Size.MEDIUM);
        CoffeeShop.CoffeeShopStats.addOrder(60 * 1.2);

        System.out.println("\nСтатистика кофейни:");
        System.out.println(CoffeeShop.CoffeeShopStats.getStats());
    }
}