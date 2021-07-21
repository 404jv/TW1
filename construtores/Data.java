package construtores;

public class Data {
  public int dia;
  public int mes;
  public int ano;

  public Data() {
    this.dia = 01;
    this.mes = 01;
    this.ano = 2021;
  }

  public Data(int dia, int mes, int ano) {
    if (!eDiaValido(dia)) return;
    this.dia = dia;
    
    if (!eMesValido(mes)) return;
    this.mes = mes;
        
    if (!eAnoValido(ano)) return;
    this.ano = ano;
  }

  private static boolean eDiaValido(int dia) {
    if (dia <= 0 || dia > 31) {
      System.out.printf("O dia %d é incorreto, informa um dia entre 1 e 31", dia);
      return false;
    }

    return true;
  }

  private static boolean eMesValido(int mes) {
    if (mes <= 0 || mes > 12) {
      System.out.printf("O mes %d é incorreto, informa um mes entre 1 e 12", mes);
      return false;
    }

    return true;
  }

  private static boolean eAnoValido(int ano) {
    if (ano <= 0) {
      System.out.printf("O ano %d é incorreto, informa um ano depois de 0", ano);
      return false;
    }

    return true;
  }

  public static void main(String args[]) {
    Data data = new Data(16, 01, 2000);
    
    System.out.println();
    System.out.println(String.format("%02d/%02d/%04d", data.dia, data.mes, data.ano));
  }
}
