package SnackMachine;

import Product.Product;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class Display {
    public static void displayMessage(String message) {
        System.out.println(message);
    }

    public static void displayMenu(HashMap<Integer, AbstractMap.SimpleEntry<Product, Integer>>
                                           products) {
        System.out.println("Меню:");
        for (Map.Entry<Integer, AbstractMap.SimpleEntry<Product, Integer>> i :
                products.entrySet()) {
            System.out.println("Id: " + i.getKey() + " " +
                    i.getValue().getKey().Description() +
                    " Количество: " + i.getValue().getValue());
        }
    }

    public static void displayBalance(int balance) {
        System.out.println("Баланс: " + balance);
    }

    public static void displayBuying(Product product) {
        System.out.println("Пружина толкает '" + product.getName() + "'");
        System.out.println("Товар упал");
    }

    public static int enterInt(String message) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(message);
            if (sc.hasNextInt())
                return sc.nextInt();
            else {
                System.out.println("Некорректные данные. Попробуйте снова");
                sc.nextLine();
            }
        }
    }
}
