package orderingpizza;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Pizza {
    private String name;
    private String sharpness;
    private int pay;
    private ArrayList<String> ingredients = new ArrayList<>();
    private Map<String,Integer> pricesize = new HashMap<>();
    public Pizza(String name, String sharpness) {
        this.name = name;
        this.sharpness = sharpness;
    }

    public Pizza(String name) {
        this.name = name;
    }

    public void setIngredients(String ingredient) {
        this.ingredients.add(ingredient);
    }
    public void setPricesize(String size, Integer price) {
        this.pricesize.put(size,price);
    }

    public Map<String, Integer> getPricesize() {
        return pricesize;
    }

    public String getName() {
        return name;
    }
    public void Size(){
        int i = 1;
        for (Map.Entry<String,Integer> ps : pricesize.entrySet()) {
            final String size = ps.getKey();
            final Integer price = ps.getValue();

                System.out.println(i + ". " + size + " " + price + " zł");
            i++;
        }
    }
    @Override
    public String toString() {
        return  name  +
                ingredients +
                "\n-> ostrość: " + sharpness +
                "\n-> cena w złotówkach: " + pricesize + ".";
    }

    public void Price(int sizeNum , int pay) {

            switch (sizeNum) {
                case 1 -> {
                    System.out.println("Mała pizza została dodana do zamówienia");
                    this.pay += pricesize.get("mała");
                }
                case 2 -> {
                    System.out.println("Średnia pizza została dodana do zamówienia");
                    this.pay += pricesize.get("średnia");;
                }
                case 3 -> {
                    System.out.println("Duża pizza została dodana do zamówienia");
                    this.pay += pricesize.get("duża");
                }
                default -> System.out.println("-> Podałeś zły numer!!! Spróbuj jeszcze raz.");
            }}

    public int getPay() {
        return this.pay;
    }



}
