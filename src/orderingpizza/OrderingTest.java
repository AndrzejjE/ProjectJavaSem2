package orderingpizza;

import java.util.Scanner;


public class OrderingTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean change = true;
        int toPay = 0;

        Pizza vegetarian = new Pizza("Wegańska","łagodna");
        vegetarian.setIngredients("szpikan");
        vegetarian.setIngredients("pomidor");
        vegetarian.setIngredients("sos");
        vegetarian.setIngredients("ser");
        vegetarian.setPricesize("mała",25);
        vegetarian.setPricesize("średnia",30);
        vegetarian.setPricesize("duża",35);

        Pizza capriciosa = new Pizza("Capriciosa", "ostra");
        capriciosa.setIngredients("pieczarki");
        capriciosa.setIngredients("szynka");
        capriciosa.setIngredients("sos");
        capriciosa.setIngredients("ser");
        capriciosa.setPricesize("mała",28);
        capriciosa.setPricesize("średnia",33);
        capriciosa.setPricesize("duża",38);

        Pizza pepperoni = new Pizza("Pepperoni","bardzo ostra");
        pepperoni.setIngredients("salami, papryka, sos, ser");
        pepperoni.setPricesize("mała",30);
        pepperoni.setPricesize("średnia",35);
        pepperoni.setPricesize("duża",40);
        while (change) {
        System.out.println("MENU");
            System.out.println("1. " + vegetarian + "\n2. " + capriciosa + "\n3. " + pepperoni);
            System.out.println("Wybierz numer pizzy: ");
        int num = scanner.nextInt();
            if (num == 1) {
                toPay = getToPay(scanner, toPay, vegetarian);
            }else if (num == 2) {
                toPay = getToPay(scanner, toPay, capriciosa);
            } else if (num == 3) {
                toPay = getToPay(scanner, toPay, pepperoni);
            }else {
                System.out.println("Podałeś zły numer pizzy!!! Spróbuj jeszcze raz.");
            continue;
            }
            boolean yesn = true;
        while (yesn) {
            System.out.println("Aktualnie do zapłaty: " + toPay + " zł");
            System.out.println("Czy chcesz dodać kolejną pizze?\n" + "1. Tak " + "2. Nie");
            int next = scanner.nextInt();
            switch (next) {
                case 1 -> {
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    yesn = false;
                }
                case 2 -> {
                    change = false;
                    yesn = false;
                }
                default -> System.out.println("Podałeś zły numer!!! Spróbuj jeszcze raz.");
            }
        }
        }
        boolean yesno = true;
        while (yesno) {
            System.out.println("Rodzaj zamówienia: 1. Dostawa(10zł)  2. odbiór osobisty");
            int delivery = scanner.nextInt();

            switch (delivery) {
                case 1 -> {
                    scanner.nextLine();
                    System.out.println("Podaj adres dostawy: ");
                   String s = scanner.nextLine();
                    toPay += 10;
                    System.out.println("-> Twoje zamówienie będzie dostarczone pod adres: " + s + " za ok. 1.5h");
                    System.out.println("-> Za to zamówienie zapłacisz " + toPay + " zł");
                    yesno = false;
                }
                case 2 -> {
                    System.out.println("-> Za to zamówienie zapłacisz " + toPay + " zł\n -> Twoje zamówienie będzie gotowe do odbioru za ok. 1h");
                    yesno = false;
                }
                default -> System.out.println("-> Podałeś zły numer!!! Spróbuj jeszcze raz.");
            }
        }


    }

    private static int getToPay(Scanner scanner, int toPay, Pizza pizza) {
        System.out.println("Wybrałeś pizze " + pizza.getName());
        while (true) {
        System.out.println("Wybierz jej rozmiar");
        pizza.Size();
        int size = scanner.nextInt();
        pizza.Price(size,toPay);
            if (size >= 1 && size <= 3) {
                break;
            }
        }

        toPay += pizza.getPay();
        return toPay;
    }
}

