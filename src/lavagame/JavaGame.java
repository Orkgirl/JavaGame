/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lavagame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Оля
 */
public class JavaGame {

    static int bottomMarge;
    static int topMarge;
    //static String = ""

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("If you want break the program enter 'exit'");

            enterMarge(reader);

            while ((bottomMarge > topMarge) || (topMarge - bottomMarge) < 2) {
                if (topMarge - bottomMarge < 2) {
                    System.out.println("topMarge must be greater than bottoMarge ");
                } else if (bottomMarge > topMarge) {
                    System.out.println("bottomMarge must be less than topMarge");
                }
                enterMarge(reader);

            }
           

            System.out.println("for " + bottomMarge + " to " + topMarge);
            int zNum = rand(bottomMarge + 1, topMarge - 1);
            String tmp = reader.readLine();
            checkExit(tmp);
            int sNumber = Integer.parseInt(tmp);

            while (sNumber != zNum) {

                if (sNumber < zNum) {
                    System.out.println("Numder > " + sNumber);
                    bottomMarge = sNumber;
                    System.out.println("Enter number for " + bottomMarge + " to " + topMarge);
                    // sNumber = Integer.parseInt(reader.readLine());

                } else if (sNumber > zNum) {
                    System.out.println("Numder < " + sNumber);
                    topMarge = sNumber;
                    System.out.println("Enter number for " + bottomMarge + " to " + topMarge);

                }
                tmp = reader.readLine();
                checkExit(tmp);
                sNumber = Integer.parseInt(tmp);

            }
            System.out.println("Uiiii");

        } catch (IOException ex) {
            Logger.getLogger(JavaGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void checkExit(String tmp) {
        if (tmp.equalsIgnoreCase("exit")) {
            System.exit(0);
        }
    }

    public static void enterMarge(BufferedReader reader) throws IOException, NumberFormatException {
        System.out.println("Enter the BottomMarge ");
        String tmp = reader.readLine();
        checkExit(tmp);
        bottomMarge = Integer.parseInt(tmp);
        System.out.println("Enter the TopMarge ");
        tmp = reader.readLine();
        checkExit(tmp);
        topMarge = Integer.parseInt(tmp);

    }

    public static int rand(int min, int max) {
        return min + (int) (Math.random() * (max - min - 1));
    }
}
