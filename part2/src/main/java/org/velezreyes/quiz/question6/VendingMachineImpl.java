package org.velezreyes.quiz.question6;

public class VendingMachineImpl implements VendingMachine {


  private static VendingMachineImpl instance;

  // Variables to keep track of money inserted by the user
  private int quartersInserted = 0;

  // Private constructor to ensure only one instance is created
  private VendingMachineImpl() {
  }

  public static VendingMachine getInstance() {
    if (instance == null) {
      instance = new VendingMachineImpl();
    }
    return instance;
  }

  @Override
  public void insertQuarter() {
    quartersInserted++;
  }

  @Override
  public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {
    if ("ScottCola".equals(name)) {
      if (quartersInserted >= 3) {
        // User has enough money for ScottCola
        quartersInserted -= 3;
        return new ScottCola();
      } else {
        throw new NotEnoughMoneyException();
      }
    } else if ("KarenTea".equals(name)) {
      if (quartersInserted >= 4) {
        // User has enough money for KarenTea
        quartersInserted -= 4;
        return new KarenTea();
      } else {
        throw new NotEnoughMoneyException();
      }
    } else {
      // Unknown drink
      throw new UnknownDrinkException();
    }
  }
}
