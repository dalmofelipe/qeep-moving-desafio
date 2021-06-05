package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Terminal {

  public static Scanner teclado = new Scanner(System.in);
  
  public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
  }
  
  public static void pressEnterToContinue() { 
    System.out.println("\nPressione [Enter] para continuar...\n");
    try { System.in.read(); } catch(Exception e) { }
  }

  public static int getInt() {
    int number = 0;
    try {
      number = teclado.nextInt();
      teclado.nextLine();
    } catch (InputMismatchException e) {
      System.out.println("Digite um valor numérico como opção!");
      teclado.nextLine();
      // System.out.println(e.getMessage());
      pressEnterToContinue();
    }
    return number;
  }
}
