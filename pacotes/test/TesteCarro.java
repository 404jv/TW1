package test;

import model.Carro;

public class TesteCarro {
  public static void main(String[] args) {
    Carro carro = new Carro("Toyota", "Corolla", 1966);

    System.out.println("Marca: " + carro.getMarca());
    System.out.println("Modelo: " + carro.getModelo());
    System.out.println("Ano: " + carro.getAno());
  }
}
