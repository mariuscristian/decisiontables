package com.example.droolsdecisiontablesdemo;

public class Customer {
  private CustomerType type;
  private int years;
  private int discount;

  public int getDiscount() {
    return discount;
  }

  public void setDiscount(int discount) {
    this.discount = discount;
  }

  public CustomerType getType() {
    return type;
  }

  public void setType(CustomerType type) {
    this.type = type;
  }

  public int getYears() {
    return years;
  }

  public void setYears(int years) {
    this.years = years;
  }

  public Customer(CustomerType type, int years) {
    this.type = type;
    this.years = years;
  }

  public enum CustomerType {
    INDIVIDUAL,
    BUSINESS;
  }
}
