package org.example;

import java.util.*;
import java.text.NumberFormat;
import java.util.Locale;

public class App {
    private static final int[] priser = new int[24];



    public static void main(String[] args) {
        Locale.setDefault(Locale.forLanguageTag("sv-SE"));
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        while (running) {
            displayMenu();

            String anvInput = scanner.nextLine().trim();

            switch (anvInput.toLowerCase()) {
                case "1":
                    inputPrices(scanner);
                    System.out.print("Inmatning\n");
                    break;

                case "2":
                    calcMinMaxAvg();
                    System.out.print("Min, Max och Medel\n");
                    break;

                case "3":
                    sorteraPriser();
                    System.out.print("Sortera\n");
                    break;

                case "4":
                    chargeHours();
                    System.out.print("Bästa laddningstid (4h)\n");
                    break;

                case "e":
                    running = false;
                    System.out.print("Avslutar programmet\n");
                    break;

                default:
                    System.out.print("Ogiltig inmatning, börja om.\n");
                    break;
            }
        }
    }

    private static void displayMenu() {
        String[] meny = {"""
                Elpriser
                ========
                1. Inmatning
                2. Min, Max och Medel
                3. Sortera
                4. Bästa Laddningstid (4h)
                5. Visualisering
                e. Avsluta
                """};

        for (String menyVal : meny) { //
            System.out.print(menyVal);
        }
    }

    private static void inputPrices(Scanner scanner) {
        System.out.print("Ange priser för för 24 timmar (öre/kWh):  \n");

        for (int i = 0; i < 24; i++) {
            int nextHour = (i + 1) % 24;
            System.out.printf("%02d - %02d\n", i, nextHour == 0 ? 24 : nextHour);
            priser[i] = scanner.nextInt();

        }
        scanner.nextLine();

    }

    private static void calcMinMaxAvg() {
        int min = priser[0];
        int max = priser[0];
        int sum = 0;
        int minHour = 0;
        int maxHour = 0;

        for (int i = 0; i < priser.length; i++) {
            if (priser[i] < min) {
                min = priser[i];
                minHour = i;

            }
            if (priser[i] > max) {
                max = priser[i];
                maxHour = i;
            }
            sum += priser[i];
        }

        double medel = (double) sum / priser.length;

        System.out.printf("Lägsta pris: %02d-%02d, %d öre/kWh\n", minHour, (minHour + 1) % 24 == 0 ? 24 : (minHour + 1) % 24, min);
        System.out.printf("Högsta pris: %02d-%02d, %d öre/kWh\n", maxHour, (maxHour + 1) % 24 == 0 ? 24 : (maxHour + 1) % 24, max);
        System.out.printf("Medelpris: %.2f öre/kWh\n", medel);


    }

    private static void sorteraPriser() {
        List<Integer> priserList = new ArrayList<>();
        for (int i = 0; i < priser.length; i++) {
            priserList.add(i);
        }
        priserList.sort((i1, i2) -> Integer.compare(priser[i2], priser[i1]));

        for (int i : priserList) {
            int nextHour = (i + 1) % 24;
            System.out.printf("%02d-%02d %d öre\n", i, nextHour == 0 ? 24 : nextHour, priser[i]);
        }



    }
    private static void chargeHours(){
        int starBilTim = 0;
        int billigastPris = Integer.MAX_VALUE;

        for (int i = 0; i < priser.length - 3; i++) {
            int bilSum = priser[i] + priser[i + 1] + priser[i + 2] + priser[i + 3];
            if (bilSum < billigastPris) {
                billigastPris = bilSum;
                starBilTim = i;

            }
        }
        double medelBat = (double) billigastPris / 4.0;

        NumberFormat commaForce = NumberFormat.getNumberInstance(Locale.forLanguageTag("sv-SE"));
        System.out.printf("Påbörja laddning klockan " + starBilTim + "\n");
        System.out.printf("Medelpris 4h: %s öre/kWh\n", commaForce.format(medelBat) );



    }


}






