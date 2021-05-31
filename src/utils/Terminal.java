package utils;

public class Terminal {
  public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
  }
  public static void pressEnterToContinue() { 
    System.out.println("\nPressione [Enter] para continuar...\n");
    try { System.in.read(); } catch(Exception e) { }
  } 
}
