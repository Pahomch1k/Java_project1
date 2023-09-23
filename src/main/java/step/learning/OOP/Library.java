package step.learning.OOP;

import java.util.ArrayList;
import java.util.List;
import step.learning.OOP.Lirerature;

public class Library {
    private List<Lirerature> items = new ArrayList<>();

    public void add(Lirerature item) {
        items.add(item);
    }

    public void printAllCards() {
        for (Lirerature item : items) {
            System.out.println(item.getCard());
        }
    }
}