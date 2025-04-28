package SnackMachine;

import Product.Product;

import java.util.HashMap;

public class SnackMachine {
    SnackMachineLogic machine;

    public SnackMachine(HashMap<Product, Integer> productsAndQuantity) {
        machine = new SnackMachineLogic(productsAndQuantity);
    }

    private void returnProduct(int id) {
        try {
            Product product = machine.GiveProduct(id);
            Display.displayBuying(product);
            Display.displayBalance(machine.getBalance());
            Display.displayMenu(machine.getProducts());
        } catch (Exception e) {
            Display.displayMessage(e.getMessage());
        }
    }

    public void takeProducts() {
        machine.addBalance(Display.enterInt("Введите сумму для покупок: "));
        Display.displayBalance(machine.getBalance());
        Display.displayMenu(machine.getProducts());
        int id = Display.enterInt("Введите Id товара или 0 для выхода: ");
        while (id != 0) {
            returnProduct(id);
            id = Display.enterInt("Введите Id товара или 0 для выхода: ");
        }
        Display.displayMessage("Спасибо за покупки");
        machine.returnChange();
    }

}
