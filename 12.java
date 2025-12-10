//Варіант 4
//Управління інвентарем магазину
import java.util.HashMap;

public class Main {

    static class Product {
        String productCode;
        String name;
        int quantity;

        public Product(String productCode, String name, int quantity) {
            this.productCode = productCode;
            this.name = name;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return productCode + " | " + name + " | Кількість: " + quantity;
        }
    }

    static class Inventory {
        HashMap<String, Product> products = new HashMap<>();

        void addProduct(Product p) {
            products.put(p.productCode, p);
        }

        void removeProduct(String code) {
            products.remove(code);
        }

        Product findProduct(String code) {
            return products.get(code);
        }

        void printAllProducts() {
            for (Product p : products.values()) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addProduct(new Product("A01", "Телефон", 10));
        inventory.addProduct(new Product("B15", "Навушники", 25));
        inventory.addProduct(new Product("C33", "Ноутбук", 5));

        System.out.println("Усі товари:");
        inventory.printAllProducts();

        System.out.println("\nПошук C33:");
        Product found = inventory.findProduct("C33");
        if (found != null) System.out.println(found);
        else System.out.println("Не знайдено");

        System.out.println("\nВидалення B15...");
        inventory.removeProduct("B15");

        System.out.println("\nОновлений список:");
        inventory.printAllProducts();
    }
}
