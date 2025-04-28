import Product.Product;
import SnackMachine.SnackMachine;

import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HashMap<Product, Integer> products = new HashMap<>();
        products.put(new Product("Соус", 3), 50);
        products.put(new Product("Масло", 2), 50);
        products.put(new Product("Сникерс", 70), 25);
        products.put(new Product("Чокопай", 65), 25);
        products.put(new Product("Вода", 50), 3);

        SnackMachine machine = new SnackMachine(products);
        machine.takeProducts();
    }
}