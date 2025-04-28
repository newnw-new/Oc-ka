package SnackMachine;

import Product.Product;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class SnackMachineLogic {
    private int balance;
    private HashMap<Integer, AbstractMap.SimpleEntry<Product, Integer>> products =
            new HashMap<>();

    public SnackMachineLogic(HashMap<Product, Integer> productsAndQuantity) {
        this.balance = 0;
        int counter = 1;
        for (Map.Entry<Product, Integer> i : productsAndQuantity.entrySet()) {
            products.put(counter, new AbstractMap.SimpleEntry<>(i.getKey(), i.getValue()));
            counter++;
        }
    }

    public int getBalance() {
        return balance;
    }

    public void addBalance(int balance) {
        this.balance += balance;
    }

    public void returnChange() {
        balance = 0;
    }

    public HashMap<Integer, AbstractMap.SimpleEntry<Product, Integer>> getProducts() {
        return new HashMap<>(products);
    }

    public Product GiveProduct(int id) throws Exception {
        if (products.get(id) != null && products.get(id).getKey().getPrice() <= balance) {
            int quantity = products.get(id).getValue();
            Product product = new Product(products.get(id).getKey());
            balance -= product.getPrice();
            products.get(id).setValue(quantity - 1);
            if (products.get(id).getValue() == 0) {
                products.remove(id);
            }
            return product;
        } else if (products.get(id) == null)
            throw new Exception("Не найден товар");
        else
            throw new Exception("Недостаточно средств");
    }
}
