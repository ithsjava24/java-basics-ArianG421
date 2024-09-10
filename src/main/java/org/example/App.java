package org.example;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class App {
    private static int[] priser = new int[24];


    public static void main(String[] args) {
        boolean running = true;
        Scanner scanner = new Scanner(System.in);



        while (running) {
            displayMenu();

            String anvInput = scnr.nextLine().trim();

            switch (anvInput.toLowerCase()) {
                case "1":
                    // håll
                    System.out.print("Inmatning\n");
                    break;

                case "2":
                    // Håll
                    System.out.print("Min, Max och Medel\n");
                    break;

                case "3":
                    // Håll
                    System.out.print("Sortera\n");
                    break;

                case "4":
                    // Håll
                    System.out.print("Bästa laddningstid (4h)\n");
                    break;

                case "e" , "E":
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
        Scanner scanner = new Scanner(System.in);

            prices.clear();
            System.out.print("Ange priser för för 24 timmar (öre/kWh\n");

        for (int i = 0; i < 24; i++) {
            System.out.printf("%02d - %02d", i , (i + 1) % 24);
            int price = scnr.nextInt();
            prices.add (price);
            
        }
        scnr.nextLine();

    }



}