import java.util.ArrayList;
import java.util.List;

public class CoffeeShop {
    private List<MenuItem> menu;
    private List<Order> orders;

    public CoffeeShop() {
        this.menu = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    public void displayMenu() {
        System.out.println("Меню:");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i).getDescription() + " - " + menu.get(i).getPrice() + " руб.");
        }
    }

    public void placeOrder(int itemIndex, Size size) {
        if (itemIndex >= 0 && itemIndex < menu.size()) {
            MenuItem item = menu.get(itemIndex);
            Order order = new Order(item, size);
            orders.add(order);
            System.out.println("Заказ принят: " + order.getDescription());
            if (item instanceof Preparable) {
                ((Preparable) item).prepare();
            }
        } else {
            System.out.println("Неверный номер пункта меню");
        }
    }


    private class Order {
        private MenuItem item;
        private Size size;

        public Order(MenuItem item, Size size) {
            this.item = item;
            this.size = size;
        }

        public String getDescription() {
            return item.getDescription() + " (" + size + ")";
        }

        public double getPrice() {
            double basePrice = item.getPrice();
            switch (size) {
                case SMALL:
                    return basePrice;
                case MEDIUM:
                    return basePrice * 1.2;
                case LARGE:
                    return basePrice * 1.4;
                default:
                    return basePrice;
            }
        }
    }

    public static class CoffeeShopStats {
        private static int totalOrders = 0;
        private static double totalRevenue = 0;

        public static void addOrder(double price) {
            totalOrders++;
            totalRevenue += price;
        }

        public static String getStats() {
            return "Всего заказов: " + totalOrders + ", Общая выручка: " + totalRevenue + " руб.";
        }
    }
}