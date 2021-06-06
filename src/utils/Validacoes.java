package utils;

import java.util.regex.Pattern;

public class Validacoes {
  public static void main(String[] args) {

    String[] cpfs = { "123.123.123-", "111.222.333-85", "123123.123-12", "111.222.333-85", 
    "1232123.123-12", "111222333-05", "123.456.789-00", "11122233305"};

    for(String cpf : cpfs) {
      if(cpfIsValid(cpf)) System.out.println("CPF Válido: "+cpf);
      // if(allDigits(cpf)) System.out.println("Todos são digitos: "+cpf);
    }
  }

  // aceita se o cpf for preenchido com pontos e traço ou somento números
  public static boolean cpfIsValid(String cpf) {
    if(Pattern.matches("(\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2})", cpf) || (allDigits(cpf) && cpf.length() == 11)) {
      return true;
    }
    return false;
  }

  public static boolean allDigits(String cpf) {
    boolean flag = true;

    for(char c : cpf.toCharArray()) {
      if(!Character.isDigit(c)) flag = false;
      break;
    }

    return flag;
  }

  public static boolean stringNoEmpty(String str, String msg) {
    if(!str.isEmpty()) return true; else System.out.println(msg);
    return false; 
  }

  public static boolean integerGreatherZero(Integer number, String msg) {
    if(number > 0) return true; else System.out.println(msg);
    return false; 
  }
}
